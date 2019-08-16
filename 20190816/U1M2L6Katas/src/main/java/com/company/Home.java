package com.company;

public class Home {

    // Apartment, Townhome, Condo, House
    private String type;

    // Forced Air or electicity.
    private String heatingType;

    // Brick or wood or stucco
    private String exterior;

    // Hardwood, carpet.
    private String flooring;

    private int yearBuilt;

    // Home feature availability
    private boolean hasBasement;

    // Door is open or locked
    private boolean doorLocked;

    // Security alarm on or off
    private boolean alarm;

    // Number of home features
    private int parking;
    private int bedrooms;

    // stories can be 1, 2, 3, etc.
    private int stories;

    // Home class has-a ...
    private Bathroom bathroom;
    private Basement basement;
    private Kitchen kitchen;
    private LivingRoom livingRoom;

    public Home(String type, String heatingType, String exterior, String flooring, int yearBuilt, boolean hasBasement, int parking, int bedrooms, int stories, Bathroom bathroom, Basement basement, Kitchen kitchen, LivingRoom livingRoom) {
        this.type = type;
        this.heatingType = heatingType;
        this.exterior = exterior;
        this.flooring = flooring;
        this.yearBuilt = yearBuilt;
        this.hasBasement = hasBasement;
        this.parking = parking;
        this.bedrooms = bedrooms;
        this.stories = stories;
        this.bathroom = bathroom;
        this.basement = basement;
        this.kitchen = kitchen;
        this.livingRoom = livingRoom;
        this.alarm = true;
        this.doorLocked = true;
    }

    public void openDoor(){
        if (doorLocked) {
            setDoorLocked(false);
        } else {
            setDoorLocked(true);
        }
    }

    public void turnOnAircon(){
        System.out.println("Turning on airconditioner.");
    }

    public boolean isAlarm() {
        return alarm;
    }

    public void setAlarm(boolean alarm) {
        this.alarm = alarm;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHeatingType() {
        return heatingType;
    }

    public void setHeatingType(String heatingType) {
        this.heatingType = heatingType;
    }

    public String getExterior() {
        return exterior;
    }

    public void setExterior(String exterior) {
        this.exterior = exterior;
    }

    public String getFlooring() {
        return flooring;
    }

    public void setFlooring(String flooring) {
        this.flooring = flooring;
    }

    public int getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(int yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public boolean isHasBasement() {
        return hasBasement;
    }

    public void setHasBasement(boolean hasBasement) {
        this.hasBasement = hasBasement;
    }

    public boolean isDoorLocked() {
        return doorLocked;
    }

    public void setDoorLocked(boolean doorLocked) {
        this.doorLocked = doorLocked;
    }

    public int getParking() {
        return parking;
    }

    public void setParking(int parking) {
        this.parking = parking;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getStories() {
        return stories;
    }

    public void setStories(int stories) {
        this.stories = stories;
    }

    public Bathroom getBathroom() {
        return bathroom;
    }

    public void setBathroom(Bathroom bathroom) {
        this.bathroom = bathroom;
    }

    public Basement getBasement() {
        return basement;
    }

    public void setBasement(Basement basement) {
        this.basement = basement;
    }

    public Kitchen getKitchen() {
        return kitchen;
    }

    public void setKitchen(Kitchen kitchen) {
        this.kitchen = kitchen;
    }

    public LivingRoom getLivingRoom() {
        return livingRoom;
    }

    public void setLivingRoom(LivingRoom livingRoom) {
        this.livingRoom = livingRoom;
    }
}
