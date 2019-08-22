package com.company;

public class App {
    public static void main(String[] args) {

        System.out.println("========= Test Run ==========");

        System.out.println("\n--- Test: Show attributes and methods of a warrior. ---");

        Warrior rich = new Warrior("Richard");
        System.out.println(rich);
        rich.run();
        rich.decreaseShieldStrength();

        System.out.println("\n--- Test: Show attributes and methods of a farmer. ---");

        Farmer neil = new Farmer("Neil");
        System.out.println(neil);
        neil.plow();

        System.out.println("\n--- Test: Show attributes and methods of a constable. ---");

        Constable dee = new Constable("Darlene");
        System.out.println(dee);
        dee.arrest();
    }
}
