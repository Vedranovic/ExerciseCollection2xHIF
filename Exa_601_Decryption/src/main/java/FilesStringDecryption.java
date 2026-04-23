import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesStringDecryption {
    private static final Path dataPath = Path.of(System.getProperty("user.dir"),
            "src",
            "main",
            "java",
            "files",
            "data.txt");

    private static final Path filesStringEncryptedPath = Path.of(System.getProperty("user.dir"),
            "src",
            "main",
            "java",
            "files/output",
            "filesStringEncrypted.txt");

    public static void encryptData() {
        try {
            String allLines = Files.readString(dataPath);
            String encryptedData = CaesarCipher.encodeLine(allLines);

            FileWriter fw = new FileWriter(filesStringEncryptedPath.toFile());
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(encryptedData);
            bw.flush();
            fw.flush();
            bw.close();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void decryptData() {
        Path filesStringDecryptedPath = Path.of(System.getProperty("user.dir"),
                "src",
                "main",
                "java",
                "files/output",
                "filesStringDecrypted.txt");

        try {
            String allLines = Files.readString(filesStringEncryptedPath);
            String decryptedData = CaesarCipher.decodeLine(allLines);

            FileWriter fw = new FileWriter(filesStringDecryptedPath.toFile());
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(decryptedData);
            bw.flush();
            fw.flush();
            bw.close();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
