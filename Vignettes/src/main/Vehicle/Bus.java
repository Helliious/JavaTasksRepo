package main.Vehicle;

import main.Vignette.Vignette;

public class Bus extends Vehicle {
    public Bus(String model, Vignette vignette) {
        super(model, vignette);
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.BUS;
    }
}
