package dev.stormery.action;


/**
 * <p> <code>ConditionalAction</code> class is related to <code>AbstractAction</code> class, which determines the real action,<br>
 * but code is determined only if condition - <code>boolean</code> of this action is <code>true</code>. <br>
 * </p>
 *
 * This class is used as <b>Decorator</b> design pattern.
 */

    public class ConditionalAction extends AbstractAction {

    /**
     * A reference to the action to be made in accordance with the <code> boolean </ code> condition.
     */
    private AbstractAction abstractAction;

    /**
     * A reference to the <code> boolean </ code> condition.
     */
    private BooleanExpression booleanExpression;

    private ConditionalAction() {
    }

//----------------------------------------------------------------------------------------------------------------------

    /**
     * Conditions the triggering of action
     *
     * @throws java.lang.IllegalArgumentException if there is no action related.
     */
    @Override
    protected void action() {

        if (abstractAction == null) {
            throw new IllegalArgumentException("Indicate the action to be performed, use addAction method.");
        }

        if (booleanExpression == null) {
            throw new IllegalArgumentException("Indicate the expression to be performed, use addConditional method.");
        }
        if (booleanExpression.conditional()) {
            abstractAction.actionPerformed();
        }
    }
//----------------------------------------------------------------------------------------------------------------------

    /**
     * @return Constructor of the class without any action or expression.
     */
    public static ConditionalAction build() {
        return new ConditionalAction();
    }
//----------------------------------------------------------------------------------------------------------------------

    /**
     * Assign action to ConditionalAction.
     *
     * @param action is action to assign.
     * @return ConditionalAction with assigned action.
     */
    public ConditionalAction addAction(AbstractAction action) {
        this.abstractAction = action;
        return this;
    }

    /**
     * It assigns a condition that determines whether the requirements are met
     *
     * @param expression is expression condition calculated by ConditionalAction
     * @return ConditionalAction with definied boolean expression.
     */
    public ConditionalAction addConditional(BooleanExpression expression) {
        this.booleanExpression = expression;
        return this;
    }
//----------------------------------------------------------------------------------------------------------------------


}
