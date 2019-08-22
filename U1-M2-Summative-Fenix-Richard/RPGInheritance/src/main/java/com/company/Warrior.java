package com.company;

public class Warrior extends Person {
    // Create attribute not in parent class.
    private int shieldStrength;

    // Only name attribute is provided when creating Warrior class.
    // Other attributes are set to default values for a Warrior class.
    public Warrior(String name) {
        super(name);
        super.setStrength(75);
        super.setHealth(100);
        super.setStamina(100);
        super.setSpeed(50);
        super.setAttackPower(10);
        this.shieldStrength = 100;
    }

    // Create methods in Warrior class that is not in the parent class.
    public void decreaseShieldStrength(){
        System.out.println("Decreasing warrior's shield strength...");
    }

    public int getShieldStrength() {
        return shieldStrength;
    }

    public void setShieldStrength(int shieldStrength) {
        this.shieldStrength = shieldStrength;
    }

    // Override to print Warrior attributes in readable format.
    @Override
    public String toString() {
        return "Warrior{" +
                "name=" + super.getName() +
                " strength=" + super.getStrength() +
                " health=" + super.getHealth() +
                " stamina=" + super.getStamina() +
                " speed=" + super.getSpeed() +
                " attackPower=" + super.getAttackPower() +
                " shieldStrength=" + shieldStrength +
                '}';
    }
}
