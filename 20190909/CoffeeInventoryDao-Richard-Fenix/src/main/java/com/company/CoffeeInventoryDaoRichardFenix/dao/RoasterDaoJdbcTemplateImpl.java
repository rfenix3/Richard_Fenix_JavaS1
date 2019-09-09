package com.company.CoffeeInventoryDaoRichardFenix.dao;

import com.company.CoffeeInventoryDaoRichardFenix.model.Roaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RoasterDaoJdbcTemplateImpl implements RoasterDao{
    private JdbcTemplate jdbcTemplate;

    private final static String INSERT_ROASTER_SQL =
            "INSERT INTO roaster (name, street, city, state, postal_code, phone, email, note) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    private final static String SELECT_ROASTER_SQL =
            "SELECT * FROM roaster WHERE roaster_id = ?";

    private final static String SELECT_ALL_ROASTER_SQL =
            "SELECT * FROM roaster";

    private final static String UPDATE_ROASTER_SQL =
            "UPDATE roaster SET " +
                    "name = ?, " +
                    "street = ?, " +
                    "city = ?, " +
                    "state = ?, " +
                    "postal_code = ?, " +
                    "phone = ?, " +
                    "email = ?, " +
                    "note = ? " +
                    "WHERE roaster_id = ?";

    private final static String DELETE_ROASTER_SQL =
            "DELETE FROM roaster WHERE roaster_id = ?";

    @Autowired
    public RoasterDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Roaster addRoaster(Roaster roaster) {
        jdbcTemplate.update(INSERT_ROASTER_SQL,
                roaster.getName(),
                roaster.getStreet(),
                roaster.getCity(),
                roaster.getState(),
                roaster.getPostal_code(),
                roaster.getPhone(),
                roaster.getEmail(),
                roaster.getNote());
        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        roaster.setRoaster_id(id);
        return roaster;
    }

    @Override
    public Roaster getRoaster(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_ROASTER_SQL, this::mapRowToRoaster, id);
        } catch (EmptyResultDataAccessException e) {
            // if there is no Roaster object with this id, just return null
            return null;
        }
    }

    @Override
    public List<Roaster> getAllRoaster() {
        return jdbcTemplate.query(SELECT_ALL_ROASTER_SQL, this::mapRowToRoaster);
    }

    @Override
    public void updateRoaster(Roaster roaster) {
        jdbcTemplate.update(UPDATE_ROASTER_SQL, roaster.getName(), roaster.getStreet(),
                roaster.getCity(), roaster.getState(), roaster.getPostal_code(), roaster.getPhone(),
                roaster.getEmail(), roaster.getNote(), roaster.getRoaster_id());
    }

    @Override
    public void deleteRoaster(int id) {
        jdbcTemplate.update(DELETE_ROASTER_SQL, id);
    }

    private Roaster mapRowToRoaster(ResultSet rs, int rowNum) throws SQLException {
        Roaster roaster = new Roaster();
        roaster.setRoaster_id(rs.getInt("roaster_id"));
        roaster.setName(rs.getString("name"));
        roaster.setStreet(rs.getString("street"));
        roaster.setCity(rs.getString("city"));
        roaster.setState(rs.getString("state"));
        roaster.setPostal_code(rs.getString("postal_code"));
        roaster.setPhone(rs.getString("phone"));
        roaster.setEmail(rs.getString("email"));
        roaster.setNote(rs.getString("note"));
        return roaster;
    }

}
