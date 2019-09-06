package com.company.WordAPI.dao;

import com.company.WordAPI.model.Definition;

import java.util.ArrayList;
import java.util.List;

public class WordDao {

    private List<Definition> wordList = new ArrayList<>();

    // Constructor will create wordList when class is instantiated.
    // We create the list in DAO implementation file since we do not have a database.
    // This serves as in memory DAO.
    public WordDao() {
        wordList.add(new Definition("vicinal", "Adjacent, local"));
        wordList.add(new Definition("Degust", "To carefully and thoughtfully savor food"));
        wordList.add(new Definition("Bravura", "A bold, brilliant display or performance"));
        wordList.add(new Definition("constellate", "To gather together in a cluster"));
        wordList.add(new Definition("bafflegab", "Messy, wordy jargon"));

        wordList.add(new Definition("verdant", "Bright green in hue"));
        wordList.add(new Definition("abecedarian", "Of or relating to the alphabet; Arranged in alphabetical order"));
        wordList.add(new Definition("mondegreen", "A word or phrase that results from misheard language"));
        wordList.add(new Definition("boffo", "Wildly successful or popular; Outstanding"));
        wordList.add(new Definition("diaphanous", "Translucent; Very delicate"));
    }

    public Definition get(int id){
        return wordList.get(id);
    }
}
