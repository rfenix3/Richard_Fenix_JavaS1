package com.company.RichardFenixU1Capstone.dao;

import com.company.RichardFenixU1Capstone.dto.Game;

import java.util.List;

public interface GameDao {
    Game addGame(Game game);

    Game getGame(int id);

    List<Game> getAllGames();

    void updateGame(Game game);

    void deleteGame(int id);

}
