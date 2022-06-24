package Humanoid;

import HvG.Utils.Tools;

public class Humanoid {
    private final String ID;
    private final String Profession;
    private static int Health;
    private static int Strength;
    private static int Agility;
    private static int Endurance;


    public Humanoid() {
        ID = Tools.getAlphaNumericString(6);
        Profession = "";
    }

    public Humanoid(String profession,int health, int strength, int agility, int endurance) {
        ID = Tools.getAlphaNumericString(6);
        Profession = profession;
        Health = health;
        Strength = strength;
        Agility = agility;
        Endurance = endurance;
    }

    public String getID() {return ID;}

    public String getProfession() {return Profession;}

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
        return "Humanoid{" +
                "Health=" + Health +
                ", Strength=" + Strength +
                ", Agility=" + Agility +
                ", Endurance=" + Endurance +
                '}';
    }

}
