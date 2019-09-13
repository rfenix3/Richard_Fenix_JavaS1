package com.company.RichardFenixU1M5Summative.controller;

import com.company.RichardFenixU1M5Summative.dao.AuthorDao;
import com.company.RichardFenixU1M5Summative.dto.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("author") // http://localhost:8080/author
public class AuthorWebServiceController {
    private final AuthorDao authorDao;

    @Autowired
    public AuthorWebServiceController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author addAuthorToDB(@RequestBody Author author) {
        return authorDao.addAuthor(author);
    }

    @DeleteMapping(path="/{author_id}")
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void  deleteAuthorFromDB(@PathVariable int author_id) {
        authorDao.deleteAuthor(author_id);
    }

    @GetMapping
    @ResponseStatus(value=HttpStatus.OK)
    public List<Author> getAuthorListfromDB() {
        return authorDao.getAllAuthor();
    }

    @GetMapping(path="/{author_id}")
    @ResponseStatus(value=HttpStatus.OK)
    public Author getAuthorFromDB(@PathVariable int author_id) {
        return authorDao.getAuthor(author_id);
    }

    @PutMapping
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void updateAuthorInDB(@RequestBody Author author){
        authorDao.updateAuthor(author);
    }

}
