package com.company.CoffeeInventoryDaoRichardFenix.dao;

import com.company.CoffeeInventoryDaoRichardFenix.model.Coffee;

import java.util.List;

public interface CoffeeDao {
    Coffee addCoffee(Coffee coffee);

    Coffee getCoffee(int id);

    List<Coffee> getAllCoffee();

    void updateCoffee(Coffee coffee);

    void deleteCoffee(int id);

//    List<Coffee> coffeeByRoster(int id);
//
//    List<Coffee> coffeeByType(String type);
}
