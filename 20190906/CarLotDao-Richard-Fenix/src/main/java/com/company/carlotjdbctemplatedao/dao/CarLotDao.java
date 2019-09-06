package com.company.carlotjdbctemplatedao.dao;

import com.company.carlotjdbctemplatedao.model.Car;

import java.util.List;

public interface CarLotDao {
    /**
     * Getting one Car for the given id
     * @param id
     * @return Car
     */
    Car getCar(int id);

    /**
     * Get all cars
     * @return
     */
    List<Car> getAllCars();

    /**
     * Adds the given Car to the DB
     * @param car
     * @return
     */
    Car addCar(Car car);

    /**
     * Updates the Car with the matching id of the given Car object
     * @param car
     */
    void updateCar(Car car);

    /**
     * Delete the Car with the given id.
     * @param id
     */
    void deleteCar(int id);

    /**
     * Get list of Car with given make.
     * @param make
     * @return
     */
    List<Car> getCarByMake(String make);

    List<Car> getCarByColor(String color);

}
