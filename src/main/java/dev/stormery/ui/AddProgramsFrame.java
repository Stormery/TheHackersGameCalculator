package dev.stormery.ui;

import dev.stormery.model.Programs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * AddProgramsFrame is used for manage GUI button for save values to db (not implemented)
 *
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

    private JButton bttSave;
    private JButton bttCancel;
    private JButton bttRemove;

    public AddProgramsFrame(){
        setSize(300,250);
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

        JTextField[] textFields = {tfName,tfDiscSpace,tfCompilationTime,tfInstallTime,tfDelay,tfProgramLevel,tfStrength,tfPrice};
        JLabel[] labels = {nameLabel,dsLabel,ctLabel,itLabel,delayLabel,plLabel,strengthLabel,priceLabel};

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
        panel.add(bttRemove); // TODO this is during edditing row panel

        panel.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        return panel;
    }
    /**
     * @return load values from GUI Panel
     */
    public Programs getPrograms() {
        return loadProgramsFromPanel();
    }

    /**
     * @return <code>Programs</code> constructor with loaded values from panel
     */
    private Programs loadProgramsFromPanel() {
        //TODO Implementation to get values from frame
        Integer id = null;

        String name = null;

        Integer diskSpace = null;

        Integer compilationTime = null;

        Double installTime = null;

        Double delay = null;

        Integer programLevel = null;

        Integer strength = null;

        Integer price = null;

        Integer amount = null;

        //DummyAdd without button
        id = null;  //if null it will be new instance in db,
                    // if there is value, it will change given row
        name = "Dummy Program";
        diskSpace = 2;
        compilationTime = 10;
        installTime = 1.5;
        delay = 0.5;
        programLevel = 5;
        strength = 15;
        price = 25;
        amount = 1;
        //
        return new Programs(id, name, diskSpace, compilationTime, installTime, delay, programLevel, strength, price, amount);
    }

}
