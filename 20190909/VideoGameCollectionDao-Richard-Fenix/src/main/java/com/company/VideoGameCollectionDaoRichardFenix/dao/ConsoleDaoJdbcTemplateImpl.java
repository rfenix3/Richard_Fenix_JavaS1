package com.company.VideoGameCollectionDaoRichardFenix.dao;

import com.company.VideoGameCollectionDaoRichardFenix.model.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ConsoleDaoJdbcTemplateImpl implements ConsoleDao {
    private JdbcTemplate jdbcTemplate;

    private final static String INSERT_CONSOLE_SQL =
            "INSERT INTO console (name, year) VALUES (?, ?)";

    private final static String SELECT_CONSOLE_SQL =
            "SELECT * FROM console WHERE console_id = ?";

    private final static String SELECT_ALL_CONSOLE_SQL =
            "SELECT * FROM console";

    private final static String UPDATE_CONSOLE_SQL =
            "UPDATE console SET name = ?, year = ? WHERE console_id = ?";

    private final static String DELETE_CONSOLE_SQL =
            "DELETE FROM console WHERE console_id = ?";


    @Autowired
    public ConsoleDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Console addConsole(Console console) {
        jdbcTemplate.update(INSERT_CONSOLE_SQL,
                console.getName(),
                console.getYear());
        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        console.setConsole_id(id);
        return console;
    }

    @Override
    public Console getConsole(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_CONSOLE_SQL, this::mapRowToConsole, id);
        } catch (EmptyResultDataAccessException e) {
            // if there is no Console object with this id, just return null
            return null;
        }
    }

    @Override
    public List<Console> getAllConsole() {
        return jdbcTemplate.query(SELECT_ALL_CONSOLE_SQL, this::mapRowToConsole);
    }

    @Override
    public void updateConsole(Console console) {
        jdbcTemplate.update(UPDATE_CONSOLE_SQL, console.getName(), console.getYear(), console.getConsole_id());
    }

    @Override
    public void deleteConsole(int id) {
        jdbcTemplate.update(DELETE_CONSOLE_SQL, id);
    }

    private Console mapRowToConsole(ResultSet rs, int rowNum) throws SQLException {
        Console console = new Console();
        console.setConsole_id(rs.getInt("console_id"));
        console.setName(rs.getString("name"));
        console.setYear(rs.getString("year"));

        return console;

    }
}
