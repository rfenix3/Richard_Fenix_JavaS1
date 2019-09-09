package com.company.VideoGameCollectionDaoRichardFenix.dao;

import com.company.VideoGameCollectionDaoRichardFenix.model.Game;

import java.util.List;

public interface GameDao {

    Game addGame(Game game);

    Game getGame(int id);

    List<Game> getAllGame();

    void updateGame(Game game);

    void deleteGame(int id);

}
