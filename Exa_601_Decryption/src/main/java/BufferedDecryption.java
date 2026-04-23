import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BufferedDecryption {
    private static final Path dataPath = Path.of(System.getProperty("user.dir"),
            "src",
            "main",
            "java",
            "files",
            "data.txt");

    private static final Path bufferedEncryptedPath = Path.of(System.getProperty("user.dir"),
            "src",
            "main",
            "java",
            "files/output",
            "bufferedEncrypted.txt");

    public static void encryptData() {
        try {
            List<String> dataLines = Files.readAllLines(dataPath);
            List<String> encryptedLines = new ArrayList<>();

            for (String line : dataLines) {
                encryptedLines.add(CaesarCipher.encodeLine(line));
            }

            FileWriter fw = new FileWriter(bufferedEncryptedPath.toFile());
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
        Path bufferedDecryptedPath = Path.of(System.getProperty("user.dir"),
                "src",
                "main",
                "java",
                "files/output",
                "bufferedDecrypted.txt");

        try {
            List<String> dataLines = Files.readAllLines(bufferedEncryptedPath);
            List<String> decryptedLines = new ArrayList<>();

            for (String line : dataLines) {
                decryptedLines.add(CaesarCipher.decodeLine(line));
            }

            FileWriter fw = new FileWriter(bufferedDecryptedPath.toFile());
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
