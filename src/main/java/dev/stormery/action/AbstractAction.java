package dev.stormery.action;

/**
 * Created by Stormery on 2018-07-20.
 */
public abstract class AbstractAction {

    /**
     * Main metod to involve action.
     */
    protected abstract void action();

    /**
     * This method is responsible for involving chain action of <code>AbstractAction</code>.
     */
    public final void actionPerformed(){
        try{
            action();
        }catch(Exception ex){
            actionFailure();
            throw new RuntimeException(ex);
        }
    }

    /**
     * The method runs when there is an error in any of the action chain elements.
     */
    protected void actionFailure() {
    }
}
