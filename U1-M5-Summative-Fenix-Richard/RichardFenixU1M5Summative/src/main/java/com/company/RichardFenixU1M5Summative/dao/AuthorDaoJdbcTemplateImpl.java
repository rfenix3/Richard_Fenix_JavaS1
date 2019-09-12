package com.company.RichardFenixU1M5Summative.dao;

import com.company.RichardFenixU1M5Summative.dto.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AuthorDaoJdbcTemplateImpl implements AuthorDao {
    private JdbcTemplate jdbcTemplate;

    private final static String INSERT_AUTHOR_SQL =
            "INSERT INTO author (first_name, last_name, street, city, state, postal_code, phone, email) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    private final static String SELECT_AUTHOR_SQL =
            "SELECT * FROM author WHERE author_id = ?";

    private final static String SELECT_ALL_AUTHOR_SQL =
            "SELECT * FROM author";

    private final static String UPDATE_AUTHOR_SQL =
            "UPDATE author " +
                    "SET first_name = ?, last_name = ?, street = ?, city = ?, state = ?, postal_code = ?, phone = ?, email = ? " +
                    "WHERE author_id = ?";

    private final static String DELETE_AUTHOR_SQL =
            "DELETE FROM author WHERE author_id = ?";

    @Autowired
    public AuthorDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Author addAuthor(Author author) {
        jdbcTemplate.update(INSERT_AUTHOR_SQL,
                author.getFirstName(),
                author.getLastName(),
                author.getStreet(),
                author.getCity(),
                author.getState(),
                author.getPostalCode(),
                author.getPhone(),
                author.getEmail());
        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        author.setAuthorId(id);
        return author;
    }

    @Override
    public Author getAuthor(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_AUTHOR_SQL, this::mapRowToAuthor, id);
        } catch (EmptyResultDataAccessException e) {
            // if there is no Author object with this id, just return null
            return null;
        }
    }

    @Override
    public List<Author> getAllAuthor() {
        return jdbcTemplate.query(SELECT_ALL_AUTHOR_SQL, this::mapRowToAuthor);
    }

    @Override
    public void updateAuthor(Author author) {
        jdbcTemplate.update(UPDATE_AUTHOR_SQL,
                author.getFirstName(),
                author.getLastName(),
                author.getStreet(),
                author.getCity(),
                author.getState(),
                author.getPostalCode(),
                author.getPhone(),
                author.getEmail(),
                author.getAuthorId());
    }

    @Override
    public void deleteAuthor(int id) {
        jdbcTemplate.update(DELETE_AUTHOR_SQL, id);
    }

    private Author mapRowToAuthor(ResultSet rs, int rowNum) throws SQLException {
        Author author = new Author();
        author.setAuthorId(rs.getInt("author_id"));
        author.setFirstName(rs.getString("first_name"));
        author.setLastName(rs.getString("last_name"));
        author.setStreet(rs.getString("street"));
        author.setCity(rs.getString("city"));
        author.setState(rs.getString("state"));
        author.setPostalCode(rs.getString("postal_code"));
        author.setPhone(rs.getString("phone"));
        author.setEmail(rs.getString("email"));

        return author;

    }

}
