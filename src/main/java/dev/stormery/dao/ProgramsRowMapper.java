package dev.stormery.dao;

import dev.stormery.model.Programs;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * TODO
 */
public class ProgramsRowMapper implements RowMapper<Programs> {
    @Override
    public Programs mapRow(ResultSet resultSet, int row) throws SQLException {
        DatabaseProgramsExtractor programExtractor = new DatabaseProgramsExtractor();
        return programExtractor.extractData(resultSet);
    }
}
