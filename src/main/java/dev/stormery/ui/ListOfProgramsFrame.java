package dev.stormery.ui;

import dev.stormery.model.Programs;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.List;

/**
 * Main window with GUI components, and manageable table.
 */
public class ListOfProgramsFrame extends JFrame{

    private ProgramsTable table;

    private JScrollPane scrollPane;
    private JButton bttAddProgram;
    private JButton bttFindProgram;
    private JButton bttRefreshList;
    private TableColumn column = null;
//
    private String[] colNames;
    private JTable tableWithListOfPrograms;
//
    public ListOfProgramsFrame(){
        setTitle("The Hackers Game Calculator");

        initComponents();
        addComponents();
        addDummyPrograms("Beam", 1, 20.0, 1.0, 1.0, 1);



        pack();
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(950, 500);
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

//TODO rozne okna maja miec rozne wymiary
      for(int i =0; i<= 7; i++){
          column = table.getColumnModel().getColumn(i);
          column.setMinWidth(70);
        }

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

    private void addDummyPrograms(String name, Integer diskSpace, Double compilationTime, Double installTime, Double delay, Integer programLevel){
        colNames = table.getColumnNames();
        Object[][] data = {{name,diskSpace,compilationTime,installTime,delay,programLevel,0,0,0},{"Worm", 2,0.2,0.2,0.2,1,0,0,0}};

        tableWithListOfPrograms = new JTable(data,colNames);
        scrollPane.getViewport().add(tableWithListOfPrograms);

    }

    public JButton getAddProgramButton(){return bttAddProgram;}
    public JButton getFindProgramButton(){return bttFindProgram;}
    public JButton getRefreshListButton(){return bttRefreshList;}

    public void refreshTable(List<Programs> programList){table.reload(programList);}

    public ProgramsTable getTable(){return table;}




}
