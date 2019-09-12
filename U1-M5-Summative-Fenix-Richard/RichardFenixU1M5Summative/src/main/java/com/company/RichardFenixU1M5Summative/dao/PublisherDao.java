package com.company.RichardFenixU1M5Summative.dao;

import com.company.RichardFenixU1M5Summative.dto.Publisher;

import java.util.List;

public interface PublisherDao {
    Publisher addPublisher(Publisher publisher);

    Publisher getPublisher(int id);

    List<Publisher> getAllPublisher();

    void updatePublisher(Publisher publisher);

    void deletePublisher(int id);

}
