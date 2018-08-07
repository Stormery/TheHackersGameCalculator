package dev.stormery.ui;

import dev.stormery.model.Programs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.text.ParseException;

/**
 * AddProgramsFrame is used for manage GUI button to add/save or edit chosen values from db
 */
public class AddProgramsFrame extends JFrame {

    private JTextField tfName;
    private JFormattedTextField tfDiscSpace;
    private JFormattedTextField tfCompilationTime;
    private JFormattedTextField tfInstallTime;
    private JFormattedTextField tfDelay;
    private JFormattedTextField tfProgramLevel;
    private JFormattedTextField tfStrength;
    private JFormattedTextField tfPrice;
    private JFormattedTextField tfAmount;


    private JButton bttSave;
    private JButton bttCancel;
    private JButton bttRemove;

    public AddProgramsFrame(){
        setSize(300,300);
        setLocationRelativeTo(null); // null is center of the screen
        setResizable(false);

        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.add(panelWithFields(), BorderLayout.CENTER);
        panel.add(panelWithButtons(), BorderLayout.SOUTH);
        add(panel,BorderLayout.CENTER);
    }


    private JPanel panelWithFields() {
        JPanel panel = new JPanel();
        GridBagLayout gb = new GridBagLayout();
        panel.setLayout(gb);

        GridBagConstraints c = new GridBagConstraints();

        JLabel nameLabel = new JLabel("Program name:");
        tfName = new JTextField(10);
        nameLabel.setLabelFor(tfName);

        JLabel dsLabel = new JLabel("Disc Space:");
        tfDiscSpace = new JFormattedTextField();
        dsLabel.setLabelFor(tfDiscSpace);

        JLabel ctLabel = new JLabel("Compilation time:");
        tfCompilationTime = new JFormattedTextField();
        ctLabel.setLabelFor(tfCompilationTime);

        JLabel itLabel = new JLabel("Install time:");
        tfInstallTime = new JFormattedTextField();
        itLabel.setLabelFor(tfInstallTime);

        JLabel delayLabel = new JLabel("Delay:");
        tfDelay = new JFormattedTextField();
        delayLabel.setLabelFor(tfDelay);

        JLabel plLabel = new JLabel("Program level:");
        tfProgramLevel = new JFormattedTextField();
        plLabel.setLabelFor(tfProgramLevel);

        JLabel strengthLabel = new JLabel("Strength (DPS):");
        tfStrength = new JFormattedTextField();
        strengthLabel.setLabelFor(tfStrength);

        JLabel priceLabel = new JLabel("Bitcoin Price:");
        tfPrice = new JFormattedTextField();
        priceLabel.setLabelFor(tfPrice);

        JLabel amountLabel = new JLabel("Amount:");
        tfAmount = new JFormattedTextField();
        priceLabel.setLabelFor(tfAmount);

        JTextField[] textFields = {tfName,tfDiscSpace,tfCompilationTime,tfInstallTime,tfDelay,tfProgramLevel,tfStrength,tfPrice,tfAmount};
        JLabel[] labels = {nameLabel,dsLabel,ctLabel,itLabel,delayLabel,plLabel,strengthLabel,priceLabel,amountLabel};

        addLabels(labels, textFields, gb, panel);

        return panel;
    }

    private void addLabels(JLabel[] labels, JTextField[] textFields, GridBagLayout gb, JPanel panel) {
        GridBagConstraints c  = new GridBagConstraints();
        c.anchor = GridBagConstraints.WEST;
        int numberOfLabel = labels.length;

        for(int i=0; i<numberOfLabel; i++){
            c.gridwidth = GridBagConstraints.RELATIVE;
            c.fill = GridBagConstraints.NONE;
            c.weightx = 0.0;
            panel.add(labels[i],c);

            c.gridwidth = GridBagConstraints.REMAINDER;
            c.fill = GridBagConstraints.HORIZONTAL;
            c.weightx = 1.0;
            c.ipadx = 20;
            panel.add(textFields[i],c);
        }
    }

    private JPanel panelWithButtons() {
        JPanel panel = new JPanel(new FlowLayout());

        bttSave = new JButton("Save");
        bttSave.setActionCommand("saveProgramAction");
        bttSave.setMnemonic(KeyEvent.VK_S);
        panel.add(bttSave);

        bttCancel = new JButton("Cancel");
        bttCancel.setActionCommand("cancelAddProgramAction");
        bttCancel.setMnemonic(KeyEvent.VK_C);
        panel.add(bttCancel);

        bttRemove = new JButton("Remove");
        bttRemove.setActionCommand("removeProgramAction");
        bttRemove.setMnemonic(KeyEvent.VK_R);
        panel.add(bttRemove); // TODO this is during edditing row panel, should be only there

        panel.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
        return panel;
    }

//----------------------------------------------------------------------------------------------------------------------
    /**
     * @return load values from GUI Panel
     */
    public Programs getPrograms() {
        return loadProgramsFromPanel();
    }

    /**
     * Creates constructor with values from AddProgramsFrame
     * @return <code>Programs</code> constructor with loaded values from panel AddProgramsFrame
     */
    private Programs loadProgramsFromPanel() {
        //TODO Implementation to get values from frame
        Integer id = null;

        String name = null;
        if(!tfName.getText().trim().isEmpty()){
            name = tfName.getText().trim();
        }

        Integer diskSpace = null;
        try{
            if(!tfDiscSpace.getText().trim().isEmpty()){
                diskSpace = Integer.valueOf(tfDiscSpace.getText());
            }
        }catch (NumberFormatException nfe){
            throw new RuntimeException("Exception during parsing field (Integer) in tfDiscSpace");
        }

        Integer compilationTime = null;
        try{
            if(!tfCompilationTime.getText().trim().isEmpty()){
                compilationTime = Integer.valueOf(tfCompilationTime.getText());
            }
        }catch (NumberFormatException nfe){
            throw new RuntimeException("Exception during parsing field (Integer) in tfCompilationTime");
        }

        Double installTime = null;
        try{
            if(!tfInstallTime.getText().trim().isEmpty()){
                installTime = Programs.formatStringToDouble(tfInstallTime.getText());
            }
        }catch (ParseException pe){
            throw new RuntimeException("Exception during parsing field String to Double  in tfInstallTime");
        }
        Double delay = null;
        try{
            if(!tfDelay.getText().trim().isEmpty()){
                delay = Programs.formatStringToDouble(tfDelay.getText());
            }
        }catch (ParseException pe){
            throw new RuntimeException("Exception during parsing field String to Double  in tfDelay");
        }
        Integer programLevel = null;
        try{
            if(!tfProgramLevel.getText().trim().isEmpty()){
                programLevel = Integer.valueOf(tfProgramLevel.getText());
            }
        }catch (NumberFormatException nfe){
            throw new RuntimeException("Exception during parsing field (Integer) in tfProgramLevel");
        }

        Integer strength = null;
        try{
            if(!tfStrength.getText().trim().isEmpty()){
                strength = Integer.valueOf(tfStrength.getText());
            }
        }catch (NumberFormatException nfe){
            throw new RuntimeException("Exception during parsing field (Integer) in tfStrength");
        }

        Integer price = null;
        try{
            if(!tfPrice.getText().trim().isEmpty()){
                price = Integer.valueOf(tfPrice.getText());
            }
        }catch (NumberFormatException nfe){
            throw new RuntimeException("Exception during parsing field (Integer) in tfPrice");
        }

        Integer amount = null;
        try{
            if(!tfAmount.getText().trim().isEmpty()){
                amount = Integer.valueOf(tfAmount.getText());
            }
        }catch (NumberFormatException nfe){
            throw new RuntimeException("Exception during parsing field (Integer) in tfAmount");
        }




//        //DummyAdd without button
//         Integer id = null;  //if null it will be new instance in db,
//                    // if there is value, it will change given row
//        name = "Dummy Program";
//        diskSpace = 2;
//        compilationTime = 10;
//        installTime = 1.5;
//        delay = 0.5;
//        programLevel = 5;
//        strength = 15;
//        price = 25;
//        amount = 1;
//        //
    return new Programs(id, name, diskSpace, compilationTime, installTime, delay, programLevel, strength, price,amount);
}
//----------------------------------------------------------------------------------------------------------------------
    /**
     * Clears and loads screen fields from list in <code>ListOfPrograms</code><br>
     * Sets bttRemove to Visible.
     * @param p refers to Programs
     */
    public void changePrograms(Programs p) {
        //cleanForm();
        if (p != null) {
            loadValuesFromTable(p);
            bttRemove.setVisible(true);

        }
    }
//----------------------------------------------------------------------------------------------------------------------
    /**
     * Loads values from table and show it in AddProgramsFrame panel.
     */
   private void loadValuesFromTable(Programs p) {
       tfName.setText(p.getName());
       tfDiscSpace.setValue(p.getDiskSpace());
       tfCompilationTime.setValue(p.getCompilationTime());
       tfInstallTime.setValue(p.getInstallTime());
       tfDelay.setValue(p.getDelay());
       tfProgramLevel.setValue(p.getProgramLevel());
       tfStrength.setValue(p.getStrength());
       tfPrice.setValue(p.getPrice());
       tfAmount.setValue(p.getAmount());
   }
//----------------------------------------------------------------------------------------------------------------------

    /**
     * Clear panels and disable visability of BttRemove
     */
    public void resetForm() {
        tfName.setText("");
        tfDiscSpace.setValue(null);
        tfCompilationTime.setValue(null);
        tfInstallTime.setValue(null);
        tfDelay.setValue(null);
        tfProgramLevel.setValue(null);
        tfStrength.setValue(null);
        tfPrice.setValue(null);
        tfAmount.setValue(null);
        bttRemove.setVisible(false);
    }
//---------------Getters ----------------------------------------------------------------------------------------------
    public JButton getBttSave() {
        return bttSave;
    }

    public JButton getBttCancel() {
        return bttCancel;
    }

    public JButton getBttRemove() {
        return bttRemove;
    }


}
