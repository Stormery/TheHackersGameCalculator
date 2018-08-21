package dev.stormery.controller;

import dev.stormery.action.*;
import dev.stormery.action.AbstractAction;
import dev.stormery.dao.ProgramsDAO;
import dev.stormery.event.*;
import dev.stormery.model.Programs;
import dev.stormery.ui.ListOfProgramsFrame;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Controling unit for overall actions in main panel
 */
public class ListOfProgramsController extends AbstractController{

    private ListOfProgramsFrame frame; //Main frame with list of programs
    private AddProgramsController addProgramsController;

    private ApplicationContext context;
//----------------------------------------------------------------------------------------------------------------------

    public ListOfProgramsController(ApplicationContext context){
        this.context = context;
        this.frame = new ListOfProgramsFrame();
        this.frame.addWindowListener(this);
        this.addProgramsController = new AddProgramsController(this);

//BEGIN------------------------------------Register Actions-------------------------------------------------------------
        /*
         * Mouse Listener
         */
        //Get values from selected row
        frame.getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() ==2){
                    log.info("Action: MouseEvent on " + frame.getClass() + " in " +getClass());
                    Programs p = frame.getTable().getSelectedProgram();
                    if(p !=null){
                        addProgramsController.show(p);
                    }
                }

            }
        });

        // Add Button
        registerAction(frame.getAddProgramButton(), new AbstractAction() {
            @Override
            protected void action() {
                log.info("Action: Add Button presed on " + frame.getClass() + " in " +getClass());
                addProgramsController.show();
            }
        });

        //Refresh Button
        registerAction(frame.getRefreshListButton(), new AbstractAction() {
            @Override
            protected void action() {
                log.info("Action: Refresh Button pressed on " + frame.getClass());
                fireEvent(new DeleteProgramEvent(null));

            }
        });

//END--------------------------------------Register Actions-------------------------------------------------------------

//BEGIN---------------------------------Register Event Listeners--------------------------------------------------------


        // Add Program Event
        registerEventListener(AddProgramsEvent.class, new AbstractEventListener<AddProgramsEvent>() {
            @Override
            public void handleEvent(AddProgramsEvent event) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        System.err.println("RefreshTable in Add program"); //*
                        refreshTable();
                    }
                });
            }
        });

        //Refresh List Event
        registerEventListener(ActualizeProgramsEvent.class, new AbstractEventListener<ActualizeProgramsEvent>() {
            @Override
            public void handleEvent(ActualizeProgramsEvent event) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        log.info("Refresh Table in Refresh list event");
                        refreshTable();
                    }
                });
            }
        });

        registerEventListener(DeleteProgramEvent.class, new AbstractEventListener<DeleteProgramEvent>() {
            @Override
            public void handleEvent(DeleteProgramEvent event) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        refreshTable();
                    }
                });

            }
        });

//END-----------------------------------Register Event Listeners--------------------------------------------------------
       // addProgramsController.saveProgramAction(this);

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
