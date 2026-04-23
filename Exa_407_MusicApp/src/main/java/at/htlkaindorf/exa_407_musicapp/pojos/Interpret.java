package at.htlkaindorf.exa_407_musicapp.pojos;

import java.util.Objects;

public class Interpret {
    private long interpretId;
    private String name;

    public Interpret(long interpretId, String name) {
        this.interpretId = interpretId;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Interpret interpret = (Interpret) o;
        return Objects.equals(name, interpret.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }
}
