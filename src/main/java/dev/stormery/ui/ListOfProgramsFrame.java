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
//TODO Comments with explanations
public class ListOfProgramsFrame extends JFrame{

    private ProgramsTable table;

    private JScrollPane scrollPane;

    private JLabel fieldTotalCosts;
    private JLabel totalCostLabel;

    private JButton bttAddProgram;
    private JButton bttFindProgram;
    private JButton bttRefreshList;

    private ImageIcon addIcon;
    private ImageIcon findIcon;
    private ImageIcon refreshIcon;



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
        //TODO Comments with explanations
        String totalCostTextField = "Total costs: ";
        table = new ProgramsTable();

        //Scrolling function for inner table
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
        setupColumnWidth();

        //init label with
        totalCostLabel = new JLabel(totalCostTextField);
        fieldTotalCosts = new JLabel("15 Test");
        totalCostLabel.setLabelFor(fieldTotalCosts);

        addIcon = new ImageIcon(this.getClass().getResource("/dev/stormery/assets/add.png")); //*

        bttAddProgram = new JButton("Add");
        bttAddProgram.setIcon(addIcon);
        bttAddProgram.setActionCommand("addProgramAction");


        findIcon = new ImageIcon(this.getClass().getResource("/dev/stormery/assets/find.png")); //*
        bttFindProgram = new JButton("Find");
        bttFindProgram.setIcon(findIcon);
        bttFindProgram.setActionCommand("findProgramAction");

        refreshIcon = new ImageIcon(this.getClass().getResource("/dev/stormery/assets/refresh.png")); //*
        bttRefreshList = new JButton("Refresh");
        bttRefreshList.setIcon(refreshIcon);
        bttRefreshList.setActionCommand("refreshProgramAction");

    }

    /**
     * Add initialized components to GUI panel
     */
    private void addComponents() {
    //TODO Comments with explanations

        JPanel bottomPanel = new JPanel();

        add(scrollPane);

        bottomPanel.setLayout(new BorderLayout());

        JPanel informationsPanel = new JPanel();
        JPanel buttonsPanel = new JPanel();

        informationsPanel.add(totalCostLabel);
        informationsPanel.add(fieldTotalCosts);

        buttonsPanel.add(bttAddProgram); //*
        buttonsPanel.add(bttFindProgram);
        buttonsPanel.add(bttRefreshList);

        bottomPanel.add(informationsPanel, BorderLayout.NORTH);
        bottomPanel.add(buttonsPanel, BorderLayout.CENTER);


        add(bottomPanel, BorderLayout.SOUTH);


    }

    /**
     * Setting columns width, so they will fit text, last column autoresize
     */
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
