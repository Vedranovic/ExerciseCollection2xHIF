package at.htlkaindorf.exa_407_musicapp.pojos;

import at.htlkaindorf.exa_407_musicapp.exceptions.TooManyInterpretsException;

import java.time.LocalDate;
import java.util.Arrays;

public class Song {
    private Interpret[] interprets;
    private String title;
    private int numOfInterprets;
    private float length;
    private LocalDate releaseDate;

    public Song(String name, float length, LocalDate releaseDate) {
        this.interprets = new Interpret[4];
        this.title = name;
        this.numOfInterprets = 0;
        this.length = length;
        this.releaseDate = releaseDate;
    }

    public void clearInterprets() {
        Arrays.fill(interprets, null);
    }

    public void addingInterpret(Interpret interpret) {
        if (numOfInterprets > 3) {
            throw new TooManyInterpretsException("There can only be a maximum of four interprets!");
        }

        interprets[numOfInterprets] = interpret;
        numOfInterprets++;
    }

    public String getInterpretStr() {
        StringBuilder output = new StringBuilder();

        try {
            for (Interpret interpret : interprets) {
                if (interpret != null) {
                    String[] tokens = interpret.getName().split(", ");

                    for (int i = 0; i < tokens.length; i++) {
                        output.append(tokens[i]).append(" | ");
                    }
                }
            }

            return output.substring(0, output.length() - 3);
        } catch (StringIndexOutOfBoundsException sioobe) {
            return "";
        }
    }

    public Interpret[] getInterprets() {
        return interprets;
    }

    public String getTitle() {
        return title;
    }

    public float getLength() {
        return length;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }
}
