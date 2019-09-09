package com.company.CoffeeInventoryDaoRichardFenix.dao;

import com.company.CoffeeInventoryDaoRichardFenix.model.Coffee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CoffeeDaoJdbcTemplateImpl implements CoffeeDao {
    private JdbcTemplate jdbcTemplate;

    private final static String INSERT_COFFEE_SQL =
            "INSERT INTO coffee (roaster_id, name, count, unit_price, description, type) VALUES (?, ?, ?, ?, ?, ?)";

    private final static String SELECT_COFFEE_SQL =
            "SELECT * FROM coffee WHERE coffee_id = ?";

    private final static String SELECT_ALL_COFFEE_SQL =
            "SELECT * FROM coffee";

    private final static String UPDATE_COFFEE_SQL =
            "UPDATE coffee SET roaster_id = ?, name = ?, count = ?, unit_price = ?, description = ?, type = ? WHERE coffee_id = ?";

    private final static String DELETE_COFFEE_SQL =
            "DELETE FROM coffee WHERE coffee_id = ?";

    @Autowired
    public CoffeeDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Coffee addCoffee(Coffee coffee) {
        jdbcTemplate.update(INSERT_COFFEE_SQL,
                coffee.getRoaster_id(),
                coffee.getName(),
                coffee.getCount(),
                coffee.getUnit_price(),
                coffee.getDescription(),
                coffee.getType());
        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        coffee.setCoffee_id(id);
        return coffee;
    }

    @Override
    public Coffee getCoffee(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_COFFEE_SQL, this::mapRowToCoffee, id);
        } catch (EmptyResultDataAccessException e) {
            // if there is no Coffee object with this id, just return null
            return null;
        }
    }

    @Override
    public List<Coffee> getAllCoffee() {
        return jdbcTemplate.query(SELECT_ALL_COFFEE_SQL, this::mapRowToCoffee);
    }

    @Override
    public void updateCoffee(Coffee coffee) {
        jdbcTemplate.update(UPDATE_COFFEE_SQL,
                coffee.getRoaster_id(),
                coffee.getName(),
                coffee.getCount(),
                coffee.getUnit_price(),
                coffee.getDescription(),
                coffee.getType(),
                coffee.getCoffee_id());
    }

    @Override
    public void deleteCoffee(int id) {
        jdbcTemplate.update(DELETE_COFFEE_SQL, id);
    }

//    @Override
//    public List<Coffee> coffeeByRoster(int id) {
//        return null;
//    }
//
//    @Override
//    public List<Coffee> coffeeByType(String type) {
//        return null;
//    }

    private Coffee mapRowToCoffee(ResultSet rs, int rowNum) throws SQLException {
        Coffee coffee = new Coffee();
        coffee.setCoffee_id(rs.getInt("coffee_id"));
        coffee.setRoaster_id(rs.getInt("roaster_id"));
        coffee.setName(rs.getString("name"));
        coffee.setCount(rs.getInt("count"));
        coffee.setUnit_price(rs.getDouble("unit_price"));
        coffee.setDescription(rs.getString("description"));
        coffee.setType(rs.getString("type"));
        return coffee;
    }


}
