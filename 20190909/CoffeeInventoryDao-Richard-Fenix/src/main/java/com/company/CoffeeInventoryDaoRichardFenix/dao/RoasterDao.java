package com.company.CoffeeInventoryDaoRichardFenix.dao;

import com.company.CoffeeInventoryDaoRichardFenix.model.Roaster;

import java.util.List;

public interface RoasterDao {
    Roaster addRoaster(Roaster roaster);

    Roaster getRoaster(int id);

    List<Roaster> getAllRoaster();

    void updateRoaster(Roaster roaster);

    void deleteRoaster(int id);

}
