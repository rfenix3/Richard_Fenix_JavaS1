package com.company.RichardFenixU1M5Summative.dao;

import com.company.RichardFenixU1M5Summative.dto.Book;

import java.util.List;

public interface BookDao {
    Book addBook(Book book);

    Book getBook(int id);

    List<Book> getAllBook();

    void updateBook(Book book);

    void deleteBook(int id);

    List<Book> getBookByAuthor(int authorId);

}
