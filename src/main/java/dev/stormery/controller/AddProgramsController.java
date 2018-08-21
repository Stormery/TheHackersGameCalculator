package dev.stormery.controller;

import dev.stormery.action.AbstractAction;
import dev.stormery.action.BooleanExpression;
import dev.stormery.action.ConditionalAction;
import dev.stormery.dao.ProgramsDAO;
import dev.stormery.event.AddProgramsEvent;
import dev.stormery.model.Programs;
import dev.stormery.ui.AddProgramsFrame;

/**
 * Controlls the activity to add or change <code>Programs</code> row values
 */
public class AddProgramsController extends AbstractController {

    private AddProgramsFrame frame;

    //validation

    public AddProgramsController(final ListOfProgramsController parent){
        super(parent);
        this.frame = new AddProgramsFrame();

        //Dodaje zarządzanie dla tego okna
        frame.addWindowListener(this);

//BEGIN----------------------------- Register Buttons Actions ----------------------------------------------------------
        registerAction(frame.getBttCancel(), new AbstractAction() {
            @Override
            protected void action() {
                log.info("Hide window and reset form in class: " + getClass());
                cleanUp();
            }
        });

        registerAction(frame.getBttSave(), ConditionalAction.build()
                            .addConditional(new BooleanExpression() {

                                //Test if frames are empty or not
                                @Override
                                public boolean conditional() {
                        //Programs p = frame.getPrograms();
                        //TODO proper Validation

                        return true;
                    }
                })
                .addAction(new AbstractAction() {
                    private Programs p;

                    @Override
                    protected void action() {
                       p = frame.getPrograms();
                       ProgramsDAO dao = parent.getProgramsDAO();
                       dao.save(p);
                    }

                    @Override
                    protected void posAction(){
                        cleanUp();
                        fireEvent(new AddProgramsEvent(p));
                        p = null;
                   }
                }));

    }


//END------------------------------- Register Buttons Actions ----------------------------------------------------------

//----------------------------- Add new Program window -----------------------------------------------------------------
    /**
     * No argument method evokes window to add new row.
     * CleanUp method is evoked before show up.
     */
    public void show(){
        cleanUp();
        frame.setTitle("Add new program");
        frame.setVisible(true);
    }

//----------------------------- Change Values window -------------------------------------------------------------------
    /**
     * Method with argument <code>Programs p</code> evokes window after double click on the row<br>
     * Window has one more button <b>Remove</b>  to remove object from the list.
     */
    public void show(Programs p){
        frame.changePrograms(p);
        frame.setTitle("Change program values");
        frame.setVisible(true);
    }
//----------------------------------------------------------------------------------------------------------------------
    @Override
    protected void cleanUp(){
        frame.setVisible(false);
        frame.resetForm();


        super.cleanUp();
    }

}
