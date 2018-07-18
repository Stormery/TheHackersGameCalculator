package dev.stormery.controller;

import dev.stormery.dao.ProgramsDAO;
import dev.stormery.model.Programs;
import dev.stormery.ui.ListOfProgramsFrame;
import org.springframework.context.ApplicationContext;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Controling unit for overall actions in main panel
 */
public class ListOfProgramsController extends AbstractController{

    private ListOfProgramsFrame frame; //Main frame with list of programs
    private AddProgramsController addProgramsController;

    private ApplicationContext context;

    public ListOfProgramsController(ApplicationContext context){
        this.context = context;
        this.frame = new ListOfProgramsFrame();
        this.frame.addWindowListener(this);
        this.addProgramsController = new AddProgramsController(this);


        /*
        * Mouse Listener
         */
        frame.getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() ==2){
                    log.info("Action: MouseEvent on " + frame.getClass() + " in " +getClass());
                    Programs p = frame.getTable().getSelectedProgram();
                    if(p !=null){
                        addProgramsController.show();
                    }
                }

            }
        });

        /*
        *Register Event Listeners
         */
       // registerEventListener();


        //TODO with Gui
        addProgramsController.saveProgramAction(this);

        getProgramsDAO().init();
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
