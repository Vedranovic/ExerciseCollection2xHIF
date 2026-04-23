package at.htlkaindorf.exa_702_homedevices.pojos;

import at.htlkaindorf.exa_702_homedevices.interfaces.SmartControllable;

public class Lamp extends Appliance implements SmartControllable {
    private int brightness = 0;
    private boolean connected = false;

    public Lamp(String name, int power, boolean isOn, long startTime, int brightness) {
        super(name, power, isOn, startTime);
        this.brightness = brightness;
    }

    public void setBrightness(int brightness) {
        if (brightness >= 0 && brightness <= 100) {
            this.brightness = brightness;
        }
    }

    @Override
    public float getPowerUsedInKw() {
        float kw = (float) (power / 1000.0);

        return kw * startTime;
    }

    @Override
    public void connectToApp() {
        connected = true;
    }

    @Override
    public void disconnectedFromApp() {
        connected = false;
    }

    @Override
    public boolean isConnected() {
        return connected;
    }

    @Override
    public String toString() {
        return "Lamp - " + name + " - " + power + " Wh";
    }
}
