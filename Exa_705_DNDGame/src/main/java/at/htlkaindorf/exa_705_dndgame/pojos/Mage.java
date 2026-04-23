package at.htlkaindorf.exa_705_dndgame.pojos;

import java.util.Random;

public class Mage extends Character {
    private int mana;

    public Mage(String name, int strength, int magic, int health, int speed, String player, int mana) {
        super(name, strength, magic, health, speed, player);
        this.mana = mana;
    }

    public String regenerateMana(int amount) {
        mana += amount;

        return String.format("\n%s regenerates 5 mana (now: %d)\n\n", name, mana);
    }

    @Override
    public String attack(Character opponent) {
        String output = "";
        Random random = new Random();

        if (random.nextDouble() < 0.3 && mana > 19) {
            output += useSpecialAbility(opponent);
            output += regenerateMana(5);

            return output;
        } else if (mana > 10) {
            output += String.format("%s casts a fireball for %d damage.\n", name, magic * 2);
            output += opponent.defend(magic * 2);
            mana -= 10;
        } else {
            output += String.format("%s doesn’t have enough mana.\n", name);
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
        health += 30;

        return String.format("%s uses Heal and restores 30 HP. Mana left: %d.\n", name, mana);
    }

    @Override
    public String toString() {
        if (isAlive()) {
            return String.format("%s (%s): mana = %d", name, getClass().getSimpleName(), mana);
        }

        return String.format("%s (%s): mana = %d - DEAD", name, getClass().getSimpleName(), mana);
    }
}
