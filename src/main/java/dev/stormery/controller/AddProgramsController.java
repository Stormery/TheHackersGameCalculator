package dev.stormery.controller;

import dev.stormery.dao.ProgramsDAO;
import dev.stormery.model.Programs;
import dev.stormery.ui.AddProgramsFrame;

/**
 * Controlls the activity to add or change <code>Programs</code> row values
 */
public class AddProgramsController {

    private AddProgramsFrame frame;

    //validation

    public AddProgramsController(ListOfProgramsController parent){
       //super
        this.frame = new AddProgramsFrame();



    }

    public void saveProgramAction(ListOfProgramsController parent){
        dummySave(parent);
    }

    public void show(){
        frame.setTitle("Add new program");
        frame.setVisible(true);
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
