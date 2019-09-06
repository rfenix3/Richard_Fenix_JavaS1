package com.company.QuoteAPI.dao;

import com.company.QuoteAPI.model.Quote;

import java.util.ArrayList;
import java.util.List;

public class QuoteDaoImplementation implements QuoteDao{

    private List<Quote> quoteList = new ArrayList<>();

    // Constructor will create quoteList if class is instantiated.
    // We create the list in DAO implementation file since we do not have a database.
    // This serves as in memory DAO.
    public QuoteDaoImplementation() {
        quoteList.add(new Quote("Walt Disney", "All our dreams can come true, if we have the courage to pursue them."));
        quoteList.add(new Quote("Albert Einstein", "Imagination is more important than knowledge."));
        quoteList.add(new Quote("Steve Jobs", "The most precious resource we all have is time."));
        quoteList.add(new Quote("Aristotle", "We are what we repeatedly do. Excellence, then, is not an act, but a habit."));
        quoteList.add(new Quote("Nelson Mandela", "I learned that courage is not the absence of fear, but the triumph over it."));

        quoteList.add(new Quote("Napoleon Bonaparte", "Victory is not always winning the battle... but rising every time you fall."));
        quoteList.add(new Quote("Ralph Waldo Emerson", "Every artist was first an amateur."));
        quoteList.add(new Quote("John Brunner", "It’s supposed to be automatic, but actually you have to push this button."));
        quoteList.add(new Quote("Elon Musk", "When something is important enough, you do it even if the odds are not in your favor."));
        quoteList.add(new Quote("Andy Grove", "Only the paranoid survive."));
    }

    @Override
    public Quote get(int id) {
        return quoteList.get(id);
    }

}
