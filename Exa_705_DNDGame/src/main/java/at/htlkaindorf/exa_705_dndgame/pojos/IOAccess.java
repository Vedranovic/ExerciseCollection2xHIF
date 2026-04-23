package at.htlkaindorf.exa_705_dndgame.pojos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class IOAccess {
    public static List<Character> loadCharacters() {
        Path path = Path.of(System.getProperty("user.dir"),
                "src",
                "main",
                "resources",
                "files",
                "705data.csv"
        );

        List<Character> characters = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(path);
            lines.removeFirst();

            for (String line : lines) {
                characters.add(Character.fromCSV(line));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return characters;
    }
}
