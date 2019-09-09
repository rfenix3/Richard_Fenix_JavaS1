package com.company.VideoGameCollectionDaoRichardFenix.dao;

import com.company.VideoGameCollectionDaoRichardFenix.model.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PublisherDaoJdbcTemplateImpl implements PublisherDao {
    private JdbcTemplate jdbcTemplate;

    private final static String INSERT_PUBLISHER_SQL =
            "INSERT INTO publisher (name, website) VALUES (?, ?)";

    private final static String SELECT_PUBLISHER_SQL =
            "SELECT * FROM publisher WHERE publisher_id = ?";

    private final static String SELECT_ALL_PUBLISHER_SQL =
            "SELECT * FROM publisher";

    private final static String UPDATE_PUBLISHER_SQL =
            "UPDATE publisher SET name = ?, website = ? WHERE publisher_id = ?";

    private final static String DELETE_PUBLISHER_SQL =
            "DELETE FROM publisher WHERE publisher_id = ?";


    @Autowired
    public PublisherDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    @Transactional
    public Publisher addPublisher(Publisher publisher) {
        jdbcTemplate.update(INSERT_PUBLISHER_SQL,
                publisher.getName(),
                publisher.getWebsite());
        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        publisher.setPublisher_id(id);
        return publisher;
    }

    @Override
    public Publisher getPublisher(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_PUBLISHER_SQL, this::mapRowToPublisher, id);
        } catch (EmptyResultDataAccessException e) {
            // if there is no Console object with this id, just return null
            return null;
        }
    }

    @Override
    public List<Publisher> getAllPublisher() {
        return jdbcTemplate.query(SELECT_ALL_PUBLISHER_SQL, this::mapRowToPublisher);
    }

    @Override
    public void updatePublisher(Publisher publisher) {
        jdbcTemplate.update(UPDATE_PUBLISHER_SQL, publisher.getName(), publisher.getWebsite(), publisher.getPublisher_id());

    }

    @Override
    public void deletePublisher(int id) {
        jdbcTemplate.update(DELETE_PUBLISHER_SQL, id);
    }

    private Publisher mapRowToPublisher(ResultSet rs, int rowNum) throws SQLException {
        Publisher publisher = new Publisher();
        publisher.setPublisher_id(rs.getInt("publisher_id"));
        publisher.setName(rs.getString("name"));
        publisher.setWebsite(rs.getString("website"));

        return publisher;

    }
}
