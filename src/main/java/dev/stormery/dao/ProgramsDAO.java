package dev.stormery.dao;

import dev.stormery.model.Programs;

import java.util.List;

/**
 * Created by Stormery on 2018-06-26.
 */
public interface ProgramsDAO {

    /**
     * Initialize database
     */
    void init();

    void dummySave();

    /**
     * @return Return list with all programs from database
     */
    List<Programs> getAll();


}
