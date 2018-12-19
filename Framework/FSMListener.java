// Generated from C:/research/javalib/FSM/src/Framework\FSM.g4 by ANTLR 4.7
package Framework;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FSMParser}.
 */
public interface FSMListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FSMParser#fsm}.
	 * @param ctx the parse tree
	 */
	void enterFsm(FSMParser.FsmContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSMParser#fsm}.
	 * @param ctx the parse tree
	 */
	void exitFsm(FSMParser.FsmContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSMParser#next_state}.
	 * @param ctx the parse tree
	 */
	void enterNext_state(FSMParser.Next_stateContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSMParser#next_state}.
	 * @param ctx the parse tree
	 */
	void exitNext_state(FSMParser.Next_stateContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSMParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(FSMParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSMParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(FSMParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSMParser#state}.
	 * @param ctx the parse tree
	 */
	void enterState(FSMParser.StateContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSMParser#state}.
	 * @param ctx the parse tree
	 */
	void exitState(FSMParser.StateContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSMParser#register_assign}.
	 * @param ctx the parse tree
	 */
	void enterRegister_assign(FSMParser.Register_assignContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSMParser#register_assign}.
	 * @param ctx the parse tree
	 */
	void exitRegister_assign(FSMParser.Register_assignContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSMParser#adder_assign}.
	 * @param ctx the parse tree
	 */
	void enterAdder_assign(FSMParser.Adder_assignContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSMParser#adder_assign}.
	 * @param ctx the parse tree
	 */
	void exitAdder_assign(FSMParser.Adder_assignContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSMParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(FSMParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSMParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(FSMParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSMParser#component}.
	 * @param ctx the parse tree
	 */
	void enterComponent(FSMParser.ComponentContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSMParser#component}.
	 * @param ctx the parse tree
	 */
	void exitComponent(FSMParser.ComponentContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSMParser#register}.
	 * @param ctx the parse tree
	 */
	void enterRegister(FSMParser.RegisterContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSMParser#register}.
	 * @param ctx the parse tree
	 */
	void exitRegister(FSMParser.RegisterContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSMParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(FSMParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSMParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(FSMParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSMParser#var_assign}.
	 * @param ctx the parse tree
	 */
	void enterVar_assign(FSMParser.Var_assignContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSMParser#var_assign}.
	 * @param ctx the parse tree
	 */
	void exitVar_assign(FSMParser.Var_assignContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSMParser#var_assigment}.
	 * @param ctx the parse tree
	 */
	void enterVar_assigment(FSMParser.Var_assigmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSMParser#var_assigment}.
	 * @param ctx the parse tree
	 */
	void exitVar_assigment(FSMParser.Var_assigmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSMParser#sub_assignment}.
	 * @param ctx the parse tree
	 */
	void enterSub_assignment(FSMParser.Sub_assignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSMParser#sub_assignment}.
	 * @param ctx the parse tree
	 */
	void exitSub_assignment(FSMParser.Sub_assignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSMParser#mult_assigment}.
	 * @param ctx the parse tree
	 */
	void enterMult_assigment(FSMParser.Mult_assigmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSMParser#mult_assigment}.
	 * @param ctx the parse tree
	 */
	void exitMult_assigment(FSMParser.Mult_assigmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSMParser#div_assigment}.
	 * @param ctx the parse tree
	 */
	void enterDiv_assigment(FSMParser.Div_assigmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSMParser#div_assigment}.
	 * @param ctx the parse tree
	 */
	void exitDiv_assigment(FSMParser.Div_assigmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSMParser#reg_assigment}.
	 * @param ctx the parse tree
	 */
	void enterReg_assigment(FSMParser.Reg_assigmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSMParser#reg_assigment}.
	 * @param ctx the parse tree
	 */
	void exitReg_assigment(FSMParser.Reg_assigmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSMParser#inputs}.
	 * @param ctx the parse tree
	 */
	void enterInputs(FSMParser.InputsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSMParser#inputs}.
	 * @param ctx the parse tree
	 */
	void exitInputs(FSMParser.InputsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSMParser#outputs}.
	 * @param ctx the parse tree
	 */
	void enterOutputs(FSMParser.OutputsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSMParser#outputs}.
	 * @param ctx the parse tree
	 */
	void exitOutputs(FSMParser.OutputsContext ctx);
}