package com.company.reccolldao.dao;

import com.company.reccolldao.model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ArtistDaoJdbcTemplateImpl implements ArtistDao {
    private JdbcTemplate jdbcTemplate;

    private final static String INSERT_ARTIST_SQL =
            "INSERT INTO artist (name, instagram, twitter) VALUES (?, ?, ?)";

    private final static String SELECT_ARTIST_SQL =
            "SELECT * FROM artist WHERE artist_id = ?";

    private final static String SELECT_ALL_ARTIST_SQL =
            "SELECT * FROM artist";

    private final static String UPDATE_ARTIST_SQL =
            "UPDATE artist SET name = ?, instagram = ?, twitter = ? WHERE artist_id = ?";

    private final static String DELETE_ARTIST_SQL =
            "DELETE FROM artist WHERE artist_id = ?";


    @Autowired
    public ArtistDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Artist addArtist(Artist artist) {
        jdbcTemplate.update(INSERT_ARTIST_SQL,
                artist.getName(),
                artist.getInstagram(),
                artist.getTwitter());

        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        artist.setId(id);
        return artist;
    }


    @Override
    public Artist getArtist(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_ARTIST_SQL, this::mapRowToArtist, id);
        } catch (EmptyResultDataAccessException e) {
            // if there is no Artist with this id, just return null
            return null;
        }
    }

    @Override
    public List<Artist> getAllArtists() {
        return jdbcTemplate.query(SELECT_ALL_ARTIST_SQL, this::mapRowToArtist);
    }

    @Override
    public void updateArtist(Artist artist) {
        jdbcTemplate.update(UPDATE_ARTIST_SQL, artist.getName(), artist.getInstagram(), artist.getTwitter(), artist.getId());
    }

    @Override
    public void deleteArtist(int id) {
        jdbcTemplate.update(DELETE_ARTIST_SQL, id);
    }

    private Artist mapRowToArtist(ResultSet rs, int rowNum) throws SQLException {
        Artist artist = new Artist();
        artist.setId(rs.getInt("artist_id"));
        artist.setName(rs.getString("name"));
        artist.setInstagram(rs.getString("instagram"));
        artist.setTwitter(rs.getString("twitter"));

        return artist;


    }
}
