package pojos;

public class Truck extends Vehicle {
    private int numOfAxis;

    @Override
    public float getValue() {
        float currentPrice = newVehiclePrice;
        boolean canBeDeducted = true;
        float previousPrice = 0.0f;

        if (milesDriven < 1000) {
            currentPrice -= newVehiclePrice * 0.2f;
        } else {
            currentPrice -= newVehiclePrice * 0.2f;

            while (canBeDeducted) {
                if (currentPrice > 0) {
                    previousPrice = currentPrice;
                    currentPrice -= newVehiclePrice * 0.19f;
                } else {
                    currentPrice = previousPrice;
                    canBeDeducted = false;
                }
            }
        }

        return currentPrice;
    }

    @Override
    public void initVehicle(String line) {
        String [] parts = line.split(";");

        description = parts[0];
        horsePower = Integer.parseInt(parts[1]);
        newVehiclePrice = Float.parseFloat(parts[2]);
        milesDriven = Integer.parseInt((parts[3]));
        numOfAxis = Integer.parseInt(parts[6]);
    }

    public int getNumOfAxis() {
        return numOfAxis;
    }

    @Override
    public String toString() {
        return String.format("TRUCK (with %d seats): %s - %d HP - %.2f KW - %d (%.2f) EUR\n",
                numOfAxis,
                description,
                horsePower,
                horsePower * 1.36f,
                getKmFromMiles(milesDriven),
                getValue());
    }
}
