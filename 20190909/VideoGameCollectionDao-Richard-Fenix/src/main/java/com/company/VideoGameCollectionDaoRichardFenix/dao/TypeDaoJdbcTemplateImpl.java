package com.company.VideoGameCollectionDaoRichardFenix.dao;

import com.company.VideoGameCollectionDaoRichardFenix.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TypeDaoJdbcTemplateImpl implements TypeDao{

    private JdbcTemplate jdbcTemplate;

    private final static String INSERT_TYPE_SQL =
            "INSERT INTO type (name, description) VALUES (?, ?)";

    private final static String SELECT_TYPE_SQL =
            "SELECT * FROM type WHERE type_id = ?";

    private final static String SELECT_ALL_TYPE_SQL =
            "SELECT * FROM type";

    private final static String UPDATE_TYPE_SQL =
            "UPDATE type SET name = ?, description = ? WHERE type_id = ?";

    private final static String DELETE_TYPE_SQL =
            "DELETE FROM type WHERE type_id = ?";


    @Autowired
    public TypeDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Type addType(Type type) {
        jdbcTemplate.update(INSERT_TYPE_SQL,
                type.getName(),
                type.getDescription());
        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        type.setType_id(id);
        return type;
    }

    @Override
    public Type getType(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_TYPE_SQL, this::mapRowToType, id);
        } catch (EmptyResultDataAccessException e) {
            // if there is no Console object with this id, just return null
            return null;
        }
    }

    @Override
    public List<Type> getAllType() {
        return jdbcTemplate.query(SELECT_ALL_TYPE_SQL, this::mapRowToType);
    }

    @Override
    public void updateType(Type type) {
        jdbcTemplate.update(UPDATE_TYPE_SQL, type.getName(), type.getDescription(), type.getType_id());
    }

    @Override
    public void deleteType(int id) {
        jdbcTemplate.update(DELETE_TYPE_SQL, id);
    }

    private Type mapRowToType(ResultSet rs, int rowNum) throws SQLException {
        Type type = new Type();
        type.setType_id(rs.getInt("type_id"));
        type.setName(rs.getString("name"));
        type.setDescription(rs.getString("description"));

        return type;
    }


}
