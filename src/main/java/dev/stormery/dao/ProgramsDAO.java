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

    /**
     * save component to db
     */
    void save(Programs programs);

    /**
     * @return Return list with all programs from database
     */
    List<Programs> getAll();


}
