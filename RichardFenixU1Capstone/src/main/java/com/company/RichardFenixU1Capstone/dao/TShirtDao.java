package com.company.RichardFenixU1Capstone.dao;

import com.company.RichardFenixU1Capstone.dto.TShirt;

import java.util.List;

public interface TShirtDao {
    TShirt addTShirt(TShirt tShirt);

    TShirt getTShirt(int id);

    List<TShirt> getAllTShirts();

    void updateTShirt(TShirt tShirt);

    void deleteTShirt(int id);

    List<TShirt> getTShirtsByColor(String color);

    List<TShirt> getTShirtsBySize(String size);

}
