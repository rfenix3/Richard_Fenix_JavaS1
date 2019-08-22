package com.company;

public class Farmer extends Person{

    // Only name attribute is provided when creating Farmer class.
    // Other attributes are set to default values for a Farmer class.
    public Farmer(String name) {
        super(name);
        super.setStrength(75);
        super.setHealth(100);
        super.setStamina(75);
        super.setSpeed(10);
        super.setAttackPower(1);
    }

    // Creating methods that are unique to Farmer class.
    public void plow(){
        System.out.println("Farmer is plowing....");
    }

    public void harvest(){
        System.out.println("Farmer is harvesting...");
    }

    // Override to print Farmer attributes in readable format.
    public String toString() {
        return "Farmer{" +
                "name=" + super.getName() +
                " strength=" + super.getStrength() +
                " health=" + super.getHealth() +
                " stamina=" + super.getStamina() +
                " speed=" + super.getSpeed() +
                " attackPower=" + super.getAttackPower() +
                '}';
    }

}
