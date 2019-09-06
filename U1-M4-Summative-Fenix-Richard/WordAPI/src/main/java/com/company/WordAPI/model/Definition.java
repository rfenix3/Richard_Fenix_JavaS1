package com.company.WordAPI.model;

import javax.validation.constraints.NotEmpty;

public class Definition {
    @NotEmpty( message="You must supply an word for the word-definition.")
    private String word;
    @NotEmpty( message="You must supply a definition for the word-definition.")
    private String definition;

    public Definition(String word, String definition) {
        this.word = word;
        this.definition = definition;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
