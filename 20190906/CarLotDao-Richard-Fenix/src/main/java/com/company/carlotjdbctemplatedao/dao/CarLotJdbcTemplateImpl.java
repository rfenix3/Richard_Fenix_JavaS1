package com.company.carlotjdbctemplatedao.dao;

import com.company.carlotjdbctemplatedao.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CarLotJdbcTemplateImpl implements CarLotDao {

    //Prepared statement strings
    private static final String INSERT_MOTO_SQL =
            "INSERT INTO CAR (MAKE, MODEL, YEAR, COLOR) VALUES (?,?,?,?)";

    private static final String SELECT_MOTO_SQL =
            "SELECT * FROM CAR WHERE id = ?";

    private static final String SELECT_ALL_MOTOS_SQL =
            "SELECT * FROM CAR";

    private static final String  DELETE_MOTO_SQL =
            "DELETE FROM CAR WHERE id = ?";

    private static final String Update_MOTO_SQL =
            "UPDATE CAR SET make =?, model=?, year=?, color=? WHERE id = ?";

    private static final String SELECT_MOTOS_BY_MAKE_SQL =
            "SELECT * FROM CAR WHERE make = ?";

    private static final String SELECT_MOTOS_BY_COLOR_SQL =
            "SELECT * FROM CAR WHERE color = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CarLotJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Car getCar(int id) {
        try{
            return jdbcTemplate.queryForObject(SELECT_MOTO_SQL, this::mapRowToCar, id);
        } catch (EmptyResultDataAccessException e) {
            // If nothing is returned just catch the exception and return null;
            return null;
        }
    }

    @Override
    public List<Car> getAllCars() {
        try{
            return jdbcTemplate.query(SELECT_ALL_MOTOS_SQL, this::mapRowToCar);
        } catch (EmptyResultDataAccessException e) {
            // If nothing is returned just catch the exception and return null;
            return null;
        }
    }

    @Override
    @Transactional
    public Car addCar(Car car) {
        // Inserting data into the database.
        jdbcTemplate.update(INSERT_MOTO_SQL,
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getColor()
        );
        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        //Updating java object with the newly created ID from the database.
        car.setId(id);
        return car;
    }

    @Override
    @Transactional
    public void updateCar(Car car) {
        jdbcTemplate.update(Update_MOTO_SQL,
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getColor(),
                car.getId());
    }

    @Override
    public void deleteCar(int id) {
        jdbcTemplate.update(DELETE_MOTO_SQL, id);
    }

    @Override
    public List<Car> getCarByMake(String make) {
        try{
            return jdbcTemplate.query(SELECT_MOTOS_BY_MAKE_SQL, this::mapRowToCar, make);
        } catch (EmptyResultDataAccessException e) {
            // If nothing is returned just catch the exception and return null;
            return null;
        }
    }

    @Override
    public List<Car> getCarByColor(String color) {
        try{
            return jdbcTemplate.query(SELECT_MOTOS_BY_COLOR_SQL, this::mapRowToCar, color);
        } catch (EmptyResultDataAccessException e) {
            // If nothing is returned just catch the exception and return null;
            return null;
        }
    }



    // Method will accept Resultset and int. - must have...
    /**
     * Maps car table row to Car object
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     */
    private Car mapRowToCar(ResultSet rs, int rowNum) throws SQLException {
        Car car = new Car();
        car.setId(rs.getInt("id"));
        car.setMake(rs.getString("make"));
        car.setModel(rs.getString("model"));
        car.setYear(rs.getString("year"));
        car.setColor(rs.getString("color"));
        return car;
    }


}
