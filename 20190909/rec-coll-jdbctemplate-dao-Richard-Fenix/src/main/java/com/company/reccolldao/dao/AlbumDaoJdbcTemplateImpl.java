package com.company.reccolldao.dao;

import com.company.reccolldao.model.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AlbumDaoJdbcTemplateImpl implements AlbumDao {
    private JdbcTemplate jdbcTemplate;

    private final static String INSERT_ALBUM_SQL =
            "INSERT INTO ALBUM (title, artist_id, release_date, label_id, list_price) VALUES (?, ?, ?, ?, ?)";

    private final static String SELECT_ALBUM_SQL =
            "SELECT * FROM ALBUM WHERE album_id = ?";

    private final static String SELECT_ALL_ALBUM_SQL =
            "SELECT * FROM ALBUM";

    private final static String UPDATE_ALBUM_SQL =
            "UPDATE ALBUM SET title = ?, artist_id = ?, release_date = ?, label_id = ?, list_price = ? WHERE album_id = ?";

    private final static String DELETE_ALBUM_SQL =
            "DELETE FROM ALBUM WHERE album_id = ?";

    @Autowired
    public AlbumDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Album addAlbum(Album album) {
        jdbcTemplate.update(
                INSERT_ALBUM_SQL,
                album.getTitle(),
                album.getArtistId(),
                album.getReleaseDate(),
                album.getLabelId(),
                album.getListPrice());

        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        album.setId(id);

        return album;
    }

    @Override
    public Album getAlbum(int id) {
        try {
            return jdbcTemplate.queryForObject(
                    SELECT_ALBUM_SQL,
                    this::mapRowToAlbum, id);
        } catch (EmptyResultDataAccessException e) {
            // if there is no match, return null
            return null;
        }
    }

    @Override
    public List<Album> getAllAlbums() {
        return jdbcTemplate.query(SELECT_ALL_ALBUM_SQL, this::mapRowToAlbum);
    }

    @Override
    public void updateAlbum(Album album) {
        jdbcTemplate.update(
                UPDATE_ALBUM_SQL,
                album.getTitle(),
                album.getArtistId(),
                album.getReleaseDate(),
                album.getLabelId(),
                album.getListPrice(),
                album.getId());   // getId is last since this is in the last ? of the UPDATE_ALBUM_SQL.
    }

    @Override
    public void deleteAlbum(int id) {
        jdbcTemplate.update(DELETE_ALBUM_SQL, id);
    }

    private Album mapRowToAlbum(ResultSet rs, int rowNum) throws SQLException {
        Album album = new Album();
        album.setId(rs.getInt("album_id"));
        album.setTitle(rs.getString("title"));
        album.setArtistId(rs.getInt("artist_id"));
        album.setLabelId(rs.getInt("label_id"));
        album.setListPrice(rs.getBigDecimal("list_price"));
        album.setReleaseDate(rs.getDate("release_date").toLocalDate());

        return album;
    }}
