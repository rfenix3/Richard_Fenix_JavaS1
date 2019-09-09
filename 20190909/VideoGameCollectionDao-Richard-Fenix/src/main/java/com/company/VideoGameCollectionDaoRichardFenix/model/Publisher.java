package com.company.VideoGameCollectionDaoRichardFenix.model;

import java.util.Objects;

public class Publisher {
    private int publisher_id;
    private String name;
    private String website;

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return publisher_id == publisher.publisher_id &&
                name.equals(publisher.name) &&
                Objects.equals(website, publisher.website);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publisher_id, name, website);
    }
}
