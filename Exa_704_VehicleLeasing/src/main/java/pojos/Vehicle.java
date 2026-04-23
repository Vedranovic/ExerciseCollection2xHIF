package pojos;

import interfaces.Deseriazable;
import interfaces.Driveable;

public abstract class Vehicle implements Comparable<Vehicle>, Driveable, Deseriazable {
    protected String description;
    protected int horsePower;
    protected float newVehiclePrice;
    protected int milesDriven;

    public Vehicle(String description, int horsePower, float newVehiclePrice, int milesDriven) {
        this.description = description;
        this.horsePower = horsePower;
        this.newVehiclePrice = newVehiclePrice;
        this.milesDriven = milesDriven;
    }

    public Vehicle() {
    }

    protected int getKmFromMiles(int miles) {
        return (int) (miles / 0.6214);
    }

    @Override
    public int compareTo(Vehicle o) {
        int typeComparison = this.getClass().getSimpleName().compareTo(o.getClass().getSimpleName());

        if (typeComparison == 0) {
            return this.description.compareTo(o.description);
        }

        return typeComparison;
    }

    public String getDescription() {
        return description;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public float getNewVehiclePrice() {
        return newVehiclePrice;
    }

    public int getMilesDriven() {
        return milesDriven;
    }
}
