package com.company.VideoGameCollectionDaoRichardFenix.dao;

import com.company.VideoGameCollectionDaoRichardFenix.model.Type;

import java.util.List;

public interface TypeDao {
    Type addType(Type type);

    Type getType(int id);

    List<Type> getAllType();

    void updateType(Type type);

    void deleteType(int id);

}
