package dev.stormery.ui;

import dev.stormery.model.Programs;

import javax.swing.*;
import java.util.List;


/**
 * Created by Stormery on 2018-06-22.
 */
public class ProgramsTable extends JTable{

    private ProgramsTableModel tableModel;

    public ProgramsTable(){
        tableModel = new ProgramsTableModel();
        setModel(tableModel);
    }

    public void reload(List<Programs> programs){
        tableModel.reload(programs);
    }


}
