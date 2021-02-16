package main.Vehicle;

import main.Vignette.Vignette;

public class Car extends Vehicle {
    public Car(String model, Vignette vignette) {
        super(model, vignette);
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.CAR;
    }
}
