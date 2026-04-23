package at.htlkaindorf.exa_705_dndgame.pojos;

import java.util.Random;

public class Archer extends Character {
    private int accuracy;
    private Random random;

    public Archer(String name, int strength, int magic, int health, int speed, String player, int accuracy) {
        super(name, strength, magic, health, speed, player);
        this.accuracy = accuracy;
        random = new Random();
    }

    @Override
    public String attack(Character opponent) {
        String output = "";
        int randNum = random.nextInt(1, 5);

        if (randNum == 4) {
            output += useSpecialAbility(opponent);
        } else {
            output += String.format("%s shoots an arrow for %d damage\n", name, (accuracy / 2) + strength);
            output += opponent.defend((accuracy / 2) + strength);
        }

        return output;
    }

    @Override
    public String defend(int damage) {
        if (random.nextDouble() < 0.3) {
            return String.format("%s dodges the attack!\n", name);
        }

        health -= damage;
        return String.format("%s is hit and loses %d HP.\n", name, damage);
    }

    @Override
    public String useSpecialAbility(Character opponent) {
        accuracy += 10;

        return String.format("%s focuses: accuracy increases to %d\n", name, accuracy);
    }

    @Override
    public String toString() {
        if (isAlive()) {
            return String.format("%s (%s): accuracy = %d", name, getClass().getSimpleName(), accuracy);
        }

        return String.format("%s (%s): accuracy = %d - DEAD", name, getClass().getSimpleName(), accuracy);
    }
}
