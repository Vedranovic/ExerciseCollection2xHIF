public class CaesarCipher {
    public static final int SHIFT = 11;

    public static String encodeLine(String line) {
        String encodedLine = "";

        for (int i = 0; i < line.length(); i++) {
            char letter = line.charAt(i);

            letter = (char) ((letter + SHIFT) % 256);

            encodedLine += letter;
        }

        return encodedLine;
    }

    public static String decodeLine(String line) {
        String decodedLine = "";

        for (int i = 0; i < line.length(); i++) {
            char letter = line.charAt(i);

            letter -= SHIFT;

            decodedLine += letter;
        }

        return decodedLine;
    }

    public static void main(String[] args) {
        BufferedDecryption.encryptData();
        BufferedDecryption.decryptData();
        FilesStringDecryption.encryptData();
        FilesStringDecryption.decryptData();
        FilesListDecryption.encryptData();
        FilesListDecryption.decryptData();
    }
}
