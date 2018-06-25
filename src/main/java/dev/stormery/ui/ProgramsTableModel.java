package dev.stormery.ui;

import dev.stormery.model.Programs;

import javax.swing.table.AbstractTableModel;
import java.sql.Timestamp;
import java.util.List;

/**
 * Defines data model for main table<br>
 * Contains data to make columns:
 * <ul>
 *     <li>Name</li>
 *     <li>Disk Space</li>
 *     <li>Compilation Time</li>
 *     <li>Install Time</li>
 *     <li>Delay</li>
 *     <li>Program Level</li>
 *     <li>Strength (DPS)</li>
 *     <li>Price</li>
 *     <li>Amount</li>
 * </ul>
 */
public class ProgramsTableModel extends AbstractTableModel {

   private List<Programs> programs;


    private String[] colNames = {"Name", "Disk Space", "Compilation Time", "Install Time", "Delay", "Program Level", "Strength (DPS)", "Price", "Amount"};

    private Class<?>[] colTypes = {String.class, Integer.class, Timestamp.class, Timestamp.class, Timestamp.class, Integer.class, Integer.class, Integer.class, Integer.class};

    public ProgramsTableModel(){}

    public void reload(List<Programs> programs){
        this.programs = programs;
        //Update table components
        fireTableDataChanged();
    }

    @Override
    public Class<?> getColumnClass(int column){
        return colTypes[column];
    }

    public int getColumnCount() {
        return 9;
    }

    @Override
    public String getColumnName(int column){
        return colNames[column];
    }

    /**
     * Counting rows in table
     * @return amount of table rows
     */
    @Override
    public int getRowCount() {
        if(programs == null){
            return 0;
        }
        return programs.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Programs p = programs.get(rowIndex);
        switch (columnIndex){
            case 0: return p.getName();
            case 1: return p.getDiskSpace();
            case 2: return p.getCompilationTime();
            case 3: return p.getInstallTime();
            case 4: return p.getDelay();
            case 5: return p.getProgramLevel();
            case 6: return p.getStrength();
            case 7: return p.getPrice();
            case 8: return p.getAmount();
        }
        return null;
    }


    @Override
    public boolean isCellEditable(int rowIndex, int columntIndex){ return false;}

    public Programs getProgramAt(int index) {return programs.get(index);}

    public String[] getColNames() {
        return colNames;
    }
}
