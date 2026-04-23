import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FilesListDecryption {
    private static final Path dataPath = Path.of(System.getProperty("user.dir"),
            "src",
            "main",
            "java",
            "files",
            "data.txt");

    private static final Path filesListEncryptedPath = Path.of(System.getProperty("user.dir"),
            "src",
            "main",
            "java",
            "files/output",
            "filesListEncrypted.txt");

    public static void encryptData() {
        try {
            List<String> lines = Files.readAllLines(dataPath);
            List<String> encryptedLines = new ArrayList<>();

            for (String line : lines) {
                encryptedLines.add(CaesarCipher.encodeLine(line));
            }

            FileWriter fw = new FileWriter(filesListEncryptedPath.toFile());
            BufferedWriter bw = new BufferedWriter(fw);

            for (String line : encryptedLines) {
                bw.write(line);
                bw.newLine();
            }

            bw.flush();
            fw.flush();
            bw.close();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void decryptData() {
        Path filesListDecryptedPath = Path.of(System.getProperty("user.dir"),
                "src",
                "main",
                "java",
                "files/output",
                "filesListDecrypted.txt");

        try {
            List<String> lines = Files.readAllLines(filesListEncryptedPath);
            List<String> decryptedLines = new ArrayList<>();

            for (String line : lines) {
                decryptedLines.add(CaesarCipher.decodeLine(line));
            }

            FileWriter fw = new FileWriter(filesListDecryptedPath.toFile());
            BufferedWriter bw = new BufferedWriter(fw);

            for (String line : decryptedLines) {
                bw.write(line);
                bw.newLine();
            }

            bw.flush();
            fw.flush();
            bw.close();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
