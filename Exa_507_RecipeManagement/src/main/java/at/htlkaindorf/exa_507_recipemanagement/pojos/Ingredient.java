package at.htlkaindorf.exa_507_recipemanagement.pojos;

import java.util.Objects;

public class Ingredient implements Comparable<Ingredient> {
    private String name;
    private String unit;
    private int amount;

    public Ingredient(String name, String unit, int amount) {
        this.name = name;
        this.unit = unit;
        this.amount = amount;
    }

    @Override
    public int compareTo(Ingredient o) {
        if (this.unit.equals(o.unit)) {
            return this.amount - o.amount;
        }

        return o.unit.compareTo(this.unit);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public int getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }
}
