package at.htlkaindorf.exa_702_homedevices.pojos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class IO_Access {
    public List<Appliance> readAllDevices() {
        Path path = Path.of(System.getProperty("user.dir"),
                "src",
                "main",
                "resources",
                "files",
                "data.csv");

        List<Appliance> appliances = new ArrayList<>();

        try {
            FileReader fr = new FileReader(path.toFile());
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();

            while ((line = br.readLine()) != null) {
                if (Appliance.parseLine(line) != null) {
                    appliances.add(Appliance.parseLine(line));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return appliances;
    }
}
