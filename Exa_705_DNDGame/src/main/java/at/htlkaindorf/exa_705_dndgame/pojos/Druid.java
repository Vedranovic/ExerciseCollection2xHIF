package at.htlkaindorf.exa_705_dndgame.pojos;

import at.htlkaindorf.exa_705_dndgame.interfaces.SpecialAbility;

import java.util.Random;

public class Druid extends Character implements SpecialAbility {
    private Character poisonedTarget;
    private Random random;

    public Druid(String name, int strength, int magic, int health, int speed, String player) {
        super(name, strength, magic, health, speed, player);
        random = new Random();
    }

    @Override
    public String attack(Character opponent) {
        String output = "";

        if (random.nextDouble() < 0.4) {
            output += useSpecialAbility(opponent);
        } else {
            int damage = (int) ((magic * 1.3) + strength);
            output += String.format("%s casts a nature spell for %d damage.\n", name, damage);

            if (opponent.equals(poisonedTarget)) {
                opponent.health -= 5;
                output += String.format("%s suffers 5 poison damage!\n", opponent.name);
            }

            output += opponent.defend(damage);
        }

        return output;
    }

    @Override
    public String defend(int damage) {
        health -= damage;

        return String.format("%s takes %d damage.\n", name, damage);
    }

    @Override
    public String useSpecialAbility(Character opponent) {
        poisonedTarget = opponent;

        return String.format("%s poisons %s!\n", name, opponent.name);
    }

    @Override
    public String toString() {
        if (isAlive()) {
            return String.format("%s (%s): poison", name, getClass().getSimpleName());
        }

        return String.format("%s (%s): poison - DEAD", name, getClass().getSimpleName());
    }
}
