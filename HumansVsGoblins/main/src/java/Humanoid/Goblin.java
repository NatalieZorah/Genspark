package Humanoid;

public class Goblin extends Humanoid {
    private static int Health;
    private static int Strength;
    private static int Agility;
    private static int Endurance;

    public Goblin() {}
    public Goblin(int health, int strength, int agility, int endurance) {
        health *= .75;
        strength -= 2;
        agility += 2;
        endurance += 1;
        Health = health;
        Strength = strength;
        Agility = agility;
        Endurance = endurance;
    }

    public static int getHealth() {return Health;}
    public static void setHealth(int health) {Health = health;}

    public static int getStrength() {return Strength;}
    public static void setStrength(int strength) {Strength = strength;}

    public static int getAgility() {return Agility;}
    public static void setAgility(int agility) {Agility = agility;}

    public static int getEndurance() {return Endurance;}
    public static void setEndurance(int endurance) {Endurance = endurance;}

    @Override
    public String toString() {
        return "Goblin{" +
                "Health=" + Health +
                ", Strength=" + Strength +
                ", Agility=" + Agility +
                ", Endurance=" + Endurance +
                '}';
    }
}
