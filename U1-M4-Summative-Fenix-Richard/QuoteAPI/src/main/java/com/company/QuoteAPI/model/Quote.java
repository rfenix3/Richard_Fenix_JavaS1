package com.company.QuoteAPI.model;

import javax.validation.constraints.NotEmpty;

public class Quote {
    @NotEmpty( message="You must supply an author for the quote.")
    private String author;
    @NotEmpty( message="You must supply a quote for the quote.")
    private String quote;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
