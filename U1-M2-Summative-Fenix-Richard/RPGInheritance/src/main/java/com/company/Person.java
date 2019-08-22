package com.company;

public class Person {
    private String name;
    private int strength;
    private int health;
    private int stamina;
    private int speed;
    private int attackPower;

    /* Default constructor is not needed as subclasses are expected to provide INITIAL attribute values.
    public Person(String name, int strength, int health, int stamina, int speed, int attackPower) {
        this.name = name;
        this.strength = strength;
        this.health = health;
        this.stamina = stamina;
        this.speed = speed;
        this.attackPower = attackPower;
    }
     */

    // Constructor for creating a person class with just using the name. Subclasses to provide the default values;
    public Person(String name) {
        this.name = name;
    }

    public void run(){
        System.out.println("Person is running (method from base class Person)...");
    }

    public void attack(){
        System.out.println("Attack...");
    }

    public void heal(){
        System.out.println("Heal...");
    }

    public void decreaseHealth(){
        System.out.println("Increase Health...");
    }

    public void increaseStamina(){
        System.out.println("Increase Stamina...");
    }

    public void decreaseStamina(){
        System.out.println("Decrease Stamina...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    // Override to print Person attributes in readable format.
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", strength=" + strength +
                ", health=" + health +
                ", stamina=" + stamina +
                ", speed=" + speed +
                ", attackPower=" + attackPower +
                '}';
    }
}
