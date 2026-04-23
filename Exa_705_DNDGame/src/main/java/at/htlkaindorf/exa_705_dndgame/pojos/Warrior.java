package at.htlkaindorf.exa_705_dndgame.pojos;

import java.util.Random;

public class Warrior extends Character {
    private int armor;

    public Warrior(String name, int strength, int magic, int health, int speed, String player, int armor) {
        super(name, strength, magic, health, speed, player);
        this.armor = armor;
    }

    @Override
    public String attack(Character opponent) {
        String output = "";
        Random random = new Random();
        int randNum = random.nextInt(1, 6);

        if (randNum == 5) {
            output += useSpecialAbility(opponent);
        } else {
            int damage = (int) (strength * 1.2);
            output += String.format("%s strikes with a sword for %d damage.\n", name, damage);
            output += opponent.defend(damage);
        }

        return output;
    }

    @Override
    public String defend(int damage) {
        damage -= armor;
        health -= damage;

        return String.format("%s blocks with armor. Damage reduced to %d.\n", name, damage);
    }

    @Override
    public String useSpecialAbility(Character opponent) {
        armor += 5;

        return String.format("%s uses Shield Block! Armor increases to %d.\n", name, armor);
    }

    @Override
    public String toString() {
        if (isAlive()) {
            return String.format("%s (%s): armor = %d", name, getClass().getSimpleName(), armor);
        }

        return String.format("%s (%s): armor = %d - DEAD", name, getClass().getSimpleName(), armor);
    }
}
