package at.htlkaindorf.exa_702_homedevices.pojos;

public abstract class Appliance implements Comparable<Appliance> {
    protected String name;
    protected int power;
    protected boolean isOn = false;
    protected long startTime;

    public Appliance(String name, int power, boolean isOn, long startTime) {
        this.name = name;
        this.power = power;
        this.isOn = isOn;
        this.startTime = startTime;
    }

    public void switchOn() {
        startTime = System.currentTimeMillis();
        isOn = true;
    }

    public void switchOn(Appliance... appliances) {
        for (Appliance appliance : appliances) {
            appliance.switchOn();
        }
    }

    public void switchOff() {
        isOn = false;
    }

    public long getOnTimeInSeconds() {
        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }

    public abstract float getPowerUsedInKw();

    public static Appliance parseLine(String line) {
        String [] parts = line.split(",");
        String power = parts[2];

        switch (parts[0]) {
            case "Washer" -> {
                String drumSize = parts[3];
                return new Washer(parts[1], Integer.parseInt(power), false, 0, Integer.parseInt(drumSize));
            }
            case "Lamp" -> {
                String brightness = parts[4];
                return new Lamp(parts[1], Integer.parseInt(power), false, 0, Integer.parseInt(brightness));
            }
            case "Fridge" -> {
                return new Fridge(parts[1], Integer.parseInt(power), false, 0);
            }
            default -> {
                return null;
            }
        }
    }

    public boolean isOn() {
        return isOn;
    }

    public long getStartTime() {
        return startTime;
    }

    @Override
    public int compareTo(Appliance o) {
        return this.power - o.power;
    }

    public String getName() {
        return name;
    }
}
