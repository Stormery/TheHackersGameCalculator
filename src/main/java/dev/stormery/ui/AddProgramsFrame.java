package dev.stormery.ui;

import dev.stormery.model.Programs;

/**
 * AddProgramsFrame is used for manage GUI button for save values to db (not implemented)
 *
 */
public class AddProgramsFrame { //extends JFrame in future

    /**
     *
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
        id = null; //if null it will be new instance in db, if there is value, it will change row
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
