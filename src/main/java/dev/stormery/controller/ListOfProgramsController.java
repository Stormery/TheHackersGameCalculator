package dev.stormery.controller;

import dev.stormery.dao.ProgramsDAO;
import dev.stormery.ui.ListOfProgramsFrame;
import org.springframework.context.ApplicationContext;

/**
 * Created by Stormery on 2018-06-26.
 */
public class ListOfProgramsController {

    private ListOfProgramsFrame frame; //Main frame with list of programs

    private ApplicationContext context;

    public ListOfProgramsController(ApplicationContext context){
        this.context = context;
        this.frame = new ListOfProgramsFrame();


        getProgramsDAO().init();
        //TODO
            //getProgramsDAO().dummySave();

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
