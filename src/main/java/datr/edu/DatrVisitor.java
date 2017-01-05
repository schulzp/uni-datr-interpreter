package datr.edu;


import datr.edu.parser.DATRParser;
import datr.edu.parser.DATRVisitor;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Visits parsed tree and translates DATR (ANTLR) nodes into Datr nodes.
 */
class DatrVisitor implements DATRVisitor<Object> {

    @Override
    public DatrQuery visitQuery(DATRParser.QueryContext ctx) {
        return new DatrQuery(ctx.node().NODE().getText(), this.visitLhs(ctx.lhs()));
    }

    @Override
    public DatrTheory visitTheory(DATRParser.TheoryContext ctx) {
        return new DatrTheory(ctx.sentence().stream()
                .map(this::visitSentence)
                .collect(Collectors.toMap(
                        (sentence) -> sentence.node,
                        (sentence) -> sentence.equations,
                        (equationsA, equationsB) -> {
                            HashSet<DatrEquation> combined = new HashSet<>(equationsA.size(), equationsB.size());
                            combined.addAll(equationsA);
                            combined.addAll(equationsB);
                            return combined;
                        })));
    }

    @Override
    public DatrSentence visitSentence(DATRParser.SentenceContext ctx) {
        return new DatrSentence(ctx.node().getText(), ctx.equation().stream()
                .map(this::visitEquation)
                .collect(Collectors.toSet()));
    }

    @Override
    public DatrEquation visitEquation(DATRParser.EquationContext ctx) {
        return new DatrEquation(this.visitLhs(ctx.lhs()), this.visitRhs(ctx.rhs()));
    }


    @Override
    public DatrPath visitLhs(DATRParser.LhsContext ctx) {
        return new DatrPath(ctx.atom().stream()
                .map(this::visitAtom)
                .collect(Collectors.toList()));
    }

    @Override
    public List<DatrValueExpression> visitRhs(DATRParser.RhsContext ctx) {
        return ctx.valueExpression().stream()
                .map(this::visitValueExpression)
                .collect(Collectors.toList());
    }

    @Override
    public DatrValueExpression visitValueExpression(DATRParser.ValueExpressionContext ctx) {
        if (ctx.atom() != null) {
            return this.visitAtom(ctx.atom());
        }
        if (ctx.descriptor() != null) {
            return this.visitDescriptor(ctx.descriptor());
        }
        if (ctx.globalDescriptor() != null) {
            return this.visitGlobalDescriptor(ctx.globalDescriptor());
        }
        throw new IllegalStateException("unknown value expression");
    }

    @Override
    public DatrDescriptorValueExpression visitDescriptor(DATRParser.DescriptorContext ctx) {
        Optional<String> node = Optional.ofNullable(ctx.node()).map(this::visitNode);
        Optional<DatrPath> path = Optional.ofNullable(ctx.path()).map(this::visitPath);
        return new DatrDescriptorValueExpression(node, path, getQueryFactory());
    }

    @Override
    public DatrDescriptorValueExpression visitGlobalDescriptor(DATRParser.GlobalDescriptorContext ctx) {
        setQueryFactory(GLOBAL);
        return this.visitDescriptor(ctx.descriptor());
    }

    @Override
    public DatrPath visitPath(DATRParser.PathContext ctx) {
        Optional<List<DATRParser.ValueExpressionContext>> expressions = Optional.ofNullable(ctx.valueExpression());
        return new DatrPath(expressions.map(exp -> exp.stream().map(this::visitValueExpression).collect(Collectors.toList())).orElse(Collections.emptyList()));
    }

    @Override
    public DatrAtomValueExpression visitAtom(DATRParser.AtomContext ctx) {
        return new DatrAtomValueExpression(ctx.getText());
    }

    @Override
    public Object visitVariable(DATRParser.VariableContext ctx) {
        return null;
    }

    @Override
    public String visitNode(DATRParser.NodeContext ctx) {
        return ctx.NODE().getText();
    }

    @Override
    public Object visit(ParseTree tree) {
        return null;
    }

    @Override
    public Object visitChildren(RuleNode node) {
        return null;
    }

    @Override
    public Object visitTerminal(TerminalNode node) {
        return null;
    }

    @Override
    public Object visitErrorNode(ErrorNode node) {
        return null;
    }

    private static DatrDescriptorValueExpression.QueryFactory LOCAL = (node, path, environment) -> new DatrQuery(
            node.orElse(environment.local.node),
            path.orElse(environment.local.path));

    private static DatrDescriptorValueExpression.QueryFactory GLOBAL = (node, path, environment) -> {
        return new DatrQuery(
                node.map(n -> environment.global.node = n).orElse(environment.global.node),
                path.map(p -> environment.global.path = p).orElse(environment.global.path)
        );
    };

    private DatrDescriptorValueExpression.QueryFactory queryFactory;

    public void setQueryFactory(DatrDescriptorValueExpression.QueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    private DatrDescriptorValueExpression.QueryFactory getQueryFactory() {
        try {
            return queryFactory == null ? LOCAL : queryFactory;
        } finally {
            queryFactory = null;
        }
    }

}
