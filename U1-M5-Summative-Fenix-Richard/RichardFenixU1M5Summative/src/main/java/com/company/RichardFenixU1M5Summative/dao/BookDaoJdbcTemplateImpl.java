package com.company.RichardFenixU1M5Summative.dao;

import com.company.RichardFenixU1M5Summative.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookDaoJdbcTemplateImpl implements BookDao{
    private JdbcTemplate jdbcTemplate;

    private final static String INSERT_BOOK_SQL =
            "INSERT INTO book (isbn, publish_date, author_id, title, publisher_id, price) VALUES (?, ?, ?, ?, ?, ?)";

    private final static String SELECT_BOOK_SQL =
            "SELECT * FROM book WHERE book_id = ?";

    private final static String SELECT_ALL_BOOK_SQL =
            "SELECT * FROM book";

    private final static String UPDATE_BOOK_SQL =
            "UPDATE book SET isbn = ?, publish_date = ?, author_id = ?, title = ?, publisher_id = ?, price = ? WHERE book_id = ?";

    private final static String DELETE_BOOK_SQL =
            "DELETE FROM book WHERE book_id = ?";

    private static final String SELECT_BOOKS_BY_AUTHOR_SQL =
            "SELECT * FROM book WHERE author_id = ?";

    @Autowired
    public BookDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Book addBook(Book book) {
        jdbcTemplate.update(INSERT_BOOK_SQL,
                book.getIsbn(),
                book.getPublishDate(),
                book.getAuthorId(),
                book.getTitle(),
                book.getPublisherId(),
                book.getPrice());
        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        book.setBookId(id);
        return book;
    }

    @Override
    public Book getBook(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_BOOK_SQL, this::mapRowToBook, id);
        } catch (EmptyResultDataAccessException e) {
            // if there is no Book object with this id, just return null
            return null;
        }
    }

    @Override
    public List<Book> getAllBook() {
        return jdbcTemplate.query(SELECT_ALL_BOOK_SQL, this::mapRowToBook);
    }

    @Override
    public void updateBook(Book book) {
        jdbcTemplate.update(UPDATE_BOOK_SQL,
                book.getIsbn(),
                book.getPublishDate(),
                book.getAuthorId(),
                book.getTitle(),
                book.getPublisherId(),
                book.getPrice(),
                book.getBookId());
    }

    @Override
    public void deleteBook(int id) {
        jdbcTemplate.update(DELETE_BOOK_SQL, id);

    }

    @Override
    public List<Book> getBookByAuthor(int authorId) {
        return jdbcTemplate.query(SELECT_BOOKS_BY_AUTHOR_SQL, this::mapRowToBook, authorId);
    }

    private Book mapRowToBook(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setBookId(rs.getInt("book_id"));
        book.setIsbn(rs.getString("isbn"));
        book.setPublishDate(rs.getDate("publish_date").toLocalDate());
        book.setAuthorId(rs.getInt("author_id"));
        book.setTitle(rs.getString("title"));
        book.setPublisherId(rs.getInt("publisher_id"));
        book.setPrice(rs.getBigDecimal("price"));

        return book;
    }

}
