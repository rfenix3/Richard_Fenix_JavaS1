package com.trilogyed.tasker.model;

import java.util.Objects;

public class Ad {
    private String advertisement;

    public String getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(String advertisement) {
        this.advertisement = advertisement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ad ad = (Ad) o;
        return getAdvertisement().equals(ad.getAdvertisement());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAdvertisement());
    }

    @Override
    public String toString() {
        return "Ad{" +
                "advertisement='" + advertisement + '\'' +
                '}';
    }
}
