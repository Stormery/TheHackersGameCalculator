package dev.stormery.ui;

import dev.stormery.model.Programs;

import javax.swing.*;
import java.util.List;


/**
 * The table management class for the program list<br>
 * Setup data model for JTable
 */
public class ProgramsTable extends JTable{

    private ProgramsTableModel tableModel;

    public ProgramsTable(){
        tableModel = new ProgramsTableModel();
        setModel(tableModel);
    }

    public Programs getSelectedProgram(){
        int i = getSelectedRow();
        if(i<0){
            return null;
        }
        return tableModel.getProgramAt(i);
    }


    public void reload(List<Programs> programs){
        tableModel.reload(programs);
    }

//    public String[] getColumnNames(){
//        return tableModel.getColNames();    not used anymore?
//    }

}
