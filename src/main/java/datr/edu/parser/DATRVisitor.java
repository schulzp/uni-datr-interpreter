// Generated from /Users/peter/Documents/git/uni/datr-interpreter/src/main/resources/DATR.g4 by ANTLR 4.5.3
package datr.edu.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DATRParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DATRVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DATRParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery(DATRParser.QueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DATRParser#theory}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTheory(DATRParser.TheoryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DATRParser#sentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentence(DATRParser.SentenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link DATRParser#equation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquation(DATRParser.EquationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DATRParser#lhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLhs(DATRParser.LhsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DATRParser#rhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRhs(DATRParser.RhsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DATRParser#valueExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueExpression(DATRParser.ValueExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DATRParser#descriptor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescriptor(DATRParser.DescriptorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DATRParser#globalDescriptor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalDescriptor(DATRParser.GlobalDescriptorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DATRParser#path}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPath(DATRParser.PathContext ctx);
	/**
	 * Visit a parse tree produced by {@link DATRParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(DATRParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link DATRParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(DATRParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link DATRParser#node}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNode(DATRParser.NodeContext ctx);
}