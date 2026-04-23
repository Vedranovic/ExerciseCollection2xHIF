package at.htlkaindorf.exa_705_dndgame.pojos;

import at.htlkaindorf.exa_705_dndgame.interfaces.SpecialAbility;

public abstract class Character implements Comparable<Character>, SpecialAbility {
    protected String name;
    protected int strength;
    protected int magic;
    protected int health;
    protected int speed;
    protected String player;

    public Character(String name, int strength, int magic, int health, int speed, String player) {
        this.name = name;
        this.strength = strength;
        this.magic = magic;
        this.health = health;
        this.speed = speed;
        this.player = player;
    }

    public abstract String attack(Character opponent);

    public abstract String defend(int damage);

    public static Character fromCSV(String line) {
        String[] parts = line.split(";");
        String player = parts[0];
        String type = parts[1];
        String name = parts[2];
        int strength = Integer.parseInt(parts[3]);
        int magic = Integer.parseInt(parts[4]);
        int health = Integer.parseInt(parts[5]);
        int speed = Integer.parseInt(parts[6]);
        int extra = Integer.parseInt(parts[7]);

        switch (type) {
            case "Warrior" -> {
                return new Warrior(name, strength, magic, health, speed, player, extra);
            }
            case "Archer" -> {
                return new Archer(name, strength, magic, health, speed, player, extra);
            }
            case "Druid" -> {
                return new Druid(name, strength, magic, health, speed, player);
            }
            case "Mage" -> {
                return new Mage(name, strength, magic, health, speed, player, extra);
            }
            default -> {
                return null;
            }
        }
    }

    public double getHealthStatus() {
        return (double) health / 100;
    }

    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public int compareTo(Character o) {
        return this.health - o.health;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getMagic() {
        return magic;
    }

    public int getSpeed() {
        return speed;
    }

    public String getPlayer() {
        return player;
    }
}
