package com.company.RichardFenixU1M5Summative.controller;

import com.company.RichardFenixU1M5Summative.dao.PublisherDao;
import com.company.RichardFenixU1M5Summative.dto.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("publisher") // http://localhost:8080/publisher
public class PublisherWebServiceController {
    private final PublisherDao publisherDao;

    @Autowired
    public PublisherWebServiceController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher addPublisherToDB(@RequestBody Publisher publisher) {
        return publisherDao.addPublisher(publisher);
    }

    @DeleteMapping(path="/{publisher_id}")
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void  deletePublisherFromDB(@PathVariable int publisher_id) {
        publisherDao.deletePublisher(publisher_id);
    }

    @GetMapping
    @ResponseStatus(value=HttpStatus.OK)
    public List<Publisher> getPublisherListfromDB() {
        return publisherDao.getAllPublisher();
    }

    @GetMapping(path="/{publisher_id}")
    @ResponseStatus(value=HttpStatus.OK)
    public Publisher getPublisherFromDB(@PathVariable int publisher_id) {
        return publisherDao.getPublisher(publisher_id);
    }

    @PutMapping
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void updatePublisherInDB(@RequestBody Publisher publisher){
        publisherDao.updatePublisher(publisher);
    }

}
