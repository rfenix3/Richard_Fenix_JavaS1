package com.company;

public class Constable extends Person{
    private String jurisdiction;

    // Only name attribute is provided when creating Constable class.
    // Other attributes are set to default values for a Constable class.
    public Constable(String name) {
        super(name);
        super.setStrength(60);
        super.setHealth(100);
        super.setStamina(60);
        super.setSpeed(20);
        super.setAttackPower(5);
        // Include jurisdiction attribute in the constructor
        this.jurisdiction = jurisdiction;
    }

    // Create methods unique to Constable class that is not in the parent class.
    public void arrest(){
        System.out.println("Constable arresting...");
    }

    // Create getter and setter for jurisdiction attribute.
    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    // Override to print Constable attributes in readable format.
    public String toString() {
        return "Constable{" +
                "name=" + super.getName() +
                " strength=" + super.getStrength() +
                " health=" + super.getHealth() +
                " stamina=" + super.getStamina() +
                " speed=" + super.getSpeed() +
                " attackPower=" + super.getAttackPower() +
                " jurisdiction=" + jurisdiction +
                '}';
    }
}
