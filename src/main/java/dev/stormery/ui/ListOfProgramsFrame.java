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

    private JTextField fieldTotalCosts;

    private JButton bttAddProgram;
    private JButton bttFindProgram;
    private JButton bttRefreshList;
//
    private String[] colNames;
//
    public ListOfProgramsFrame(){
        setTitle("The Hackers Game Calculator");

        initComponents();
        addComponents();


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
        setupColumnWidth();

        fieldTotalCosts = new JTextField("Total costs:");
        fieldTotalCosts.setHorizontalAlignment(JTextField.LEFT);


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

        JPanel upperPanel = new JPanel();
        upperPanel.add(fieldTotalCosts);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(bttAddProgram);
        bottomPanel.add(bttFindProgram);
        bottomPanel.add(bttRefreshList);

        JPanel innerPanel = new JPanel();
        innerPanel.add(upperPanel);
        innerPanel.add(bottomPanel);
        BoxLayout layout = new BoxLayout(innerPanel,BoxLayout.Y_AXIS);
        innerPanel.setLayout(layout);


        panel.add(innerPanel);

        add(panel, BorderLayout.SOUTH);





    }


    private void setupColumnWidth() {
        for(int i =0; i<= 7; i++){
            switch(i){
                case 0: table.getColumnModel().getColumn(i).setPreferredWidth(130); break;
                case 1: table.getColumnModel().getColumn(i).setPreferredWidth(60); break;
                case 2: table.getColumnModel().getColumn(i).setPreferredWidth(100); break;
                case 3: table.getColumnModel().getColumn(i).setPreferredWidth(70); break;
                case 4: table.getColumnModel().getColumn(i).setPreferredWidth(30); break;
                case 5: table.getColumnModel().getColumn(i).setPreferredWidth(80); break;
                case 6: table.getColumnModel().getColumn(i).setPreferredWidth(80); break;
                case 7: table.getColumnModel().getColumn(i).setPreferredWidth(30); break;

            }

            table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        }
    }

    public JButton getAddProgramButton(){return bttAddProgram;}
    public JButton getFindProgramButton(){return bttFindProgram;}
    public JButton getRefreshListButton(){return bttRefreshList;}

    public void refreshTable(List<Programs> programList){table.reload(programList);}

    public ProgramsTable getTable(){return table;}




}
