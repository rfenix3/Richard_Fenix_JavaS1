package com.company.CoffeeInventoryDaoRichardFenix.model;

import java.util.Objects;

public class Roaster {
    private int roaster_id;
    private String name;
    private String street;
    private String city;
    private String state;
    private String postal_code;
    private String phone;
    private String email;
    private String note;

    public int getRoaster_id() {
        return roaster_id;
    }

    public void setRoaster_id(int roaster_id) {
        this.roaster_id = roaster_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roaster roaster = (Roaster) o;
        return getRoaster_id() == roaster.getRoaster_id() &&
                getName().equals(roaster.getName()) &&
                getStreet().equals(roaster.getStreet()) &&
                getCity().equals(roaster.getCity()) &&
                getState().equals(roaster.getState()) &&
                getPostal_code().equals(roaster.getPostal_code()) &&
                getPhone().equals(roaster.getPhone()) &&
                getEmail().equals(roaster.getEmail()) &&
                Objects.equals(getNote(), roaster.getNote());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoaster_id(), getName(), getStreet(), getCity(), getState(), getPostal_code(), getPhone(), getEmail(), getNote());
    }
}
