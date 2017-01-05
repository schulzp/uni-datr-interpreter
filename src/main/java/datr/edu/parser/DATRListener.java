// Generated from /Users/peter/Documents/git/uni/datr-interpreter/src/main/resources/DATR.g4 by ANTLR 4.5.3
package datr.edu.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DATRParser}.
 */
public interface DATRListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DATRParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(DATRParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link DATRParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(DATRParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link DATRParser#theory}.
	 * @param ctx the parse tree
	 */
	void enterTheory(DATRParser.TheoryContext ctx);
	/**
	 * Exit a parse tree produced by {@link DATRParser#theory}.
	 * @param ctx the parse tree
	 */
	void exitTheory(DATRParser.TheoryContext ctx);
	/**
	 * Enter a parse tree produced by {@link DATRParser#sentence}.
	 * @param ctx the parse tree
	 */
	void enterSentence(DATRParser.SentenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link DATRParser#sentence}.
	 * @param ctx the parse tree
	 */
	void exitSentence(DATRParser.SentenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link DATRParser#equation}.
	 * @param ctx the parse tree
	 */
	void enterEquation(DATRParser.EquationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DATRParser#equation}.
	 * @param ctx the parse tree
	 */
	void exitEquation(DATRParser.EquationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DATRParser#lhs}.
	 * @param ctx the parse tree
	 */
	void enterLhs(DATRParser.LhsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DATRParser#lhs}.
	 * @param ctx the parse tree
	 */
	void exitLhs(DATRParser.LhsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DATRParser#rhs}.
	 * @param ctx the parse tree
	 */
	void enterRhs(DATRParser.RhsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DATRParser#rhs}.
	 * @param ctx the parse tree
	 */
	void exitRhs(DATRParser.RhsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DATRParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void enterValueExpression(DATRParser.ValueExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DATRParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void exitValueExpression(DATRParser.ValueExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DATRParser#descriptor}.
	 * @param ctx the parse tree
	 */
	void enterDescriptor(DATRParser.DescriptorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DATRParser#descriptor}.
	 * @param ctx the parse tree
	 */
	void exitDescriptor(DATRParser.DescriptorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DATRParser#globalDescriptor}.
	 * @param ctx the parse tree
	 */
	void enterGlobalDescriptor(DATRParser.GlobalDescriptorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DATRParser#globalDescriptor}.
	 * @param ctx the parse tree
	 */
	void exitGlobalDescriptor(DATRParser.GlobalDescriptorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DATRParser#path}.
	 * @param ctx the parse tree
	 */
	void enterPath(DATRParser.PathContext ctx);
	/**
	 * Exit a parse tree produced by {@link DATRParser#path}.
	 * @param ctx the parse tree
	 */
	void exitPath(DATRParser.PathContext ctx);
	/**
	 * Enter a parse tree produced by {@link DATRParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(DATRParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link DATRParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(DATRParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link DATRParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(DATRParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link DATRParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(DATRParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link DATRParser#node}.
	 * @param ctx the parse tree
	 */
	void enterNode(DATRParser.NodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DATRParser#node}.
	 * @param ctx the parse tree
	 */
	void exitNode(DATRParser.NodeContext ctx);
}