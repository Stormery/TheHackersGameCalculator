package dev.stormery.ui;

import dev.stormery.model.Programs;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Main window with GUI components, and manageable table. <br>
 * Invoke components, and sets properties for the main application window<br>
 *
 */
public class ListOfProgramsFrame extends JFrame{

    private ProgramsTable table;

    private JScrollPane scrollPane;
    private JButton bttAddProgram;
    private JButton bttFindProgram;
    private JButton bttRefreshList;
//
    private String[] colNames;
    private JTable tableWithListOfPrograms;
//
    public ListOfProgramsFrame(){
        setTitle("The Hackers Game Calculator");

        initComponents();
        addComponents();
        //addDummyPrograms();


        pack();
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 500);
        setVisible(true);
    }

    /**
     * Init GUI components for table
     */
    private void initComponents() {
        table = new ProgramsTable();

        //Scrolling function for inner table
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);

        bttAddProgram = new JButton("Add");
        bttAddProgram.setActionCommand("addProgramAction");

        bttFindProgram = new JButton("Find");
        bttFindProgram.setActionCommand("findProgramAction");

        bttRefreshList = new JButton("Refresh");
        bttRefreshList.setActionCommand("refreshProgramAction");

    }

    /**
     * Add initialized components to GUI panel
     */
    private void addComponents() {
        JPanel panel = new JPanel();
        add(scrollPane);
        panel.add(bttAddProgram);
        panel.add(bttFindProgram);
        panel.add(bttRefreshList);

        add(panel, BorderLayout.SOUTH);

    }

    private void addDummyPrograms(){
        colNames = table.getColumnNames();
        Object[][] data = {
                {"Beam",1,20,1.0,1.0,1,0,0,0},
                {"Worm",2,2,0.2,0.2,1,0,0,0}};

        tableWithListOfPrograms = new JTable(data,colNames);
        scrollPane.getViewport().add(tableWithListOfPrograms);
        setupColumnWidth();
    }

    private void setupColumnWidth() {
        for(int i =0; i<= 7; i++){
            switch(i){
                case 0: tableWithListOfPrograms.getColumnModel().getColumn(i).setPreferredWidth(130); break;
                case 1: tableWithListOfPrograms.getColumnModel().getColumn(i).setPreferredWidth(60); break;
                case 2: tableWithListOfPrograms.getColumnModel().getColumn(i).setPreferredWidth(100); break;
                case 3: tableWithListOfPrograms.getColumnModel().getColumn(i).setPreferredWidth(70); break;
                case 4: tableWithListOfPrograms.getColumnModel().getColumn(i).setPreferredWidth(30); break;
                case 5: tableWithListOfPrograms.getColumnModel().getColumn(i).setPreferredWidth(80); break;
                case 6: tableWithListOfPrograms.getColumnModel().getColumn(i).setPreferredWidth(80); break;
                case 7: tableWithListOfPrograms.getColumnModel().getColumn(i).setPreferredWidth(30); break;

            }

            tableWithListOfPrograms.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        }
    }

    public JButton getAddProgramButton(){return bttAddProgram;}
    public JButton getFindProgramButton(){return bttFindProgram;}
    public JButton getRefreshListButton(){return bttRefreshList;}

    public void refreshTable(List<Programs> programList){table.reload(programList);}

    public ProgramsTable getTable(){return table;}




}
