package at.htlkaindorf.exa_702_homedevices.pojos;

public class Washer extends Appliance {
    private int drumSize;

    public Washer(String name, int power, boolean isOn, long startTime, int drumSize) {
        super(name, power, isOn, startTime);
        this.drumSize = drumSize;
    }

    @Override
    public float getPowerUsedInKw() {
        float kw = (float) (power / 1000.0);

        return kw * startTime;
    }

    @Override
    public String toString() {
        return "Washer - " + name + " - " + power + " Wh";
    }

    public int getDrumSize() {
        return drumSize;
    }
}
