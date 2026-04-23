package at.htlkaindorf.exa_702_homedevices.pojos;

public class Fridge extends Appliance {
    public Fridge(String name, int power, boolean isOn, long startTime) {
        super(name, power, isOn, startTime);
    }

    @Override
    public float getPowerUsedInKw() {
        float kw = (float) (power / 1000.0);

        return kw * startTime;
    }

    @Override
    public String toString() {
        return "Fridge - " + name + " - " + power + " Wh";
    }
}
