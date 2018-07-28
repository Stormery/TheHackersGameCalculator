package dev.stormery.controller;

import dev.stormery.action.AbstractAction;
import dev.stormery.dao.ProgramsDAO;
import dev.stormery.model.Programs;
import dev.stormery.ui.AddProgramsFrame;

/**
 * Controlls the activity to add or change <code>Programs</code> row values
 */
public class AddProgramsController extends AbstractController {

    private AddProgramsFrame frame;

    //validation

    public AddProgramsController(ListOfProgramsController parent){
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

        //TODO register Save Button acion

    }

    public void saveProgramAction(ListOfProgramsController parent){
        dummySave(parent);
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
    //Exchangable for future button actions
    private void dummySave(ListOfProgramsController parent) {
        //action
        Programs p = frame.getPrograms();

        ProgramsDAO dao = parent.getProgramsDAO();
        System.err.println("TODO Save jest zastopowany: " + getClass());
        //dao.save(p);
    }
}
