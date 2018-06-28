package dev.stormery.dao;


import dev.stormery.model.Programs;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
//FINISHED
/**
 * Class have access by <code>ResultSetExtractor</code> to database, and can extract informations into object.
 *
 */
public class DatabaseProgramsExtractor implements ResultSetExtractor<Programs>{


    public Programs extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        int diskSpace = resultSet.getInt("disk_space");
        int compilationTime = resultSet.getInt("compilation_time");
        double installTime = resultSet.getDouble("install_time");
        double delay = resultSet.getDouble("delay");
        int programLevel = resultSet.getInt("program_level");
        int strength = resultSet.getInt("strength");
        int price = resultSet.getInt("price");
        int amount = resultSet.getInt("amount");

        return new Programs(id,name,diskSpace,compilationTime,installTime,delay,programLevel,strength,price,amount);
    }
}
