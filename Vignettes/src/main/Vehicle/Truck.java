package main.Vehicle;

import main.Vignette.Vignette;

public class Truck extends Vehicle {
    public Truck(String model, Vignette vignette) {
        super(model, vignette);
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.TRUCK;
    }
}
