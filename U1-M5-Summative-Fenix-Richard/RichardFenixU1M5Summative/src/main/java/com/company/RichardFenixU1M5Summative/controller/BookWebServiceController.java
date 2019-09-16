package com.company.RichardFenixU1M5Summative.controller;

import com.company.RichardFenixU1M5Summative.dao.BookDao;
import com.company.RichardFenixU1M5Summative.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book") // http://localhost:8080/publisher
public class BookWebServiceController {
    private final BookDao bookDao;

    @Autowired
    public BookWebServiceController(BookDao bookDao) {
        this.bookDao = bookDao;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBookToDB(@RequestBody Book book) {
        return bookDao.addBook(book);
    }

    @DeleteMapping(path="/{book_id}")
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void  deleteBookFromDB(@PathVariable int book_id) {
        bookDao.deleteBook(book_id);
    }

    @GetMapping
    @ResponseStatus(value=HttpStatus.OK)
    public List<Book> getBookListfromDB() {
        return bookDao.getAllBook();
    }

    // Example: http://localhost:8080/book/2 will get book with book_id of 2.
    @GetMapping(path="/{book_id}")
    @ResponseStatus(value=HttpStatus.OK)
    public Book getBookFromDB(@PathVariable int book_id) {
        return bookDao.getBook(book_id);
    }

    @PutMapping
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void updateBookInDB(@RequestBody Book book){
        bookDao.updateBook(book);
    }

    // Example:  http://localhost:8080/book/author/1 will get all books by author 1.
    @RequestMapping(path = "/author/{author_id}", method = RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.OK)
    public List<Book> FindBookByAuthor(@PathVariable int author_id){
        return bookDao.getBookByAuthor(author_id);
    }

}
