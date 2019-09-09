package com.company.VideoGameCollectionDaoRichardFenix.dao;

import com.company.VideoGameCollectionDaoRichardFenix.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GameDaoJdbcTemplateImpl implements GameDao {
    private JdbcTemplate jdbcTemplate;

    private final static String INSERT_GAME_SQL =
            "INSERT INTO game (console_id, publisher_id, type_id) VALUES (?, ?, ?)";

    private final static String SELECT_GAME_SQL =
            "SELECT * FROM game WHERE game_id = ?";

    private final static String SELECT_ALL_GAME_SQL =
            "SELECT * FROM game";

    private final static String UPDATE_GAME_SQL =
            "UPDATE game SET console_id = ?, publisher_id = ?, type_id = ? WHERE game_id = ?";

    private final static String DELETE_GAME_SQL =
            "DELETE FROM game WHERE game_id = ?";

    @Autowired
    public GameDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Game addGame(Game game) {
        jdbcTemplate.update(INSERT_GAME_SQL,
                game.getConsole_id(),
                game.getPublisher_id(),
                game.getType_id());
        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        game.setGame_id(id);
        return game;
    }

    @Override
    public Game getGame(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_GAME_SQL, this::mapRowToGame, id);
        } catch (EmptyResultDataAccessException e) {
            // if there is no Game object with this id, just return null
            return null;
        }
    }

    @Override
    public List<Game> getAllGame() {
        return jdbcTemplate.query(SELECT_ALL_GAME_SQL, this::mapRowToGame);
    }

    @Override
    public void updateGame(Game game) {
        jdbcTemplate.update(UPDATE_GAME_SQL, game.getConsole_id(), game.getPublisher_id(), game.getType_id(), game.getGame_id());
    }

    @Override
    public void deleteGame(int id) {
        jdbcTemplate.update(DELETE_GAME_SQL, id);
    }

    private Game mapRowToGame(ResultSet rs, int rowNum) throws SQLException {
        Game game = new Game();
        game.setGame_id(rs.getInt("game_id"));
        game.setConsole_id(rs.getInt("console_id"));
        game.setPublisher_id(rs.getInt("publisher_id"));
        game.setType_id(rs.getInt("type_id"));
        return game;
    }
}
