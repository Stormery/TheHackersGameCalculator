package dev.stormery.controller;

import dev.stormery.dao.ProgramsDAO;
import dev.stormery.ui.ListOfProgramsFrame;
import org.springframework.context.ApplicationContext;

/**
 * Controling unit for overall actions in main panel
 */
public class ListOfProgramsController {

    private ListOfProgramsFrame frame; //Main frame with list of programs
    private AddProgramsController addProgramsController;

    private ApplicationContext context;

    public ListOfProgramsController(ApplicationContext context){
        this.context = context;
        this.frame = new ListOfProgramsFrame();
        this.addProgramsController = new AddProgramsController(this);



        getProgramsDAO().init();
        //TODO with Gui
        addProgramsController.saveProgramAction(this);

        refreshTable();

    }

    private void refreshTable() {
        frame.refreshTable(getProgramsDAO().getAll());
    }

    protected ProgramsDAO getProgramsDAO(){
        ProgramsDAO dao = (ProgramsDAO) context.getBean("programsDAOSpring");
        if(dao == null){
            throw new RuntimeException("There is no component for programsDAOSpring");
        }
        return dao;
    }
}
