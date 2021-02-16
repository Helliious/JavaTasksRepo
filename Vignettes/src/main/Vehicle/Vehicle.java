package main.Vehicle;

import main.Vignette.Vignette;
import main.util.Validator;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Vehicle {


    private static int uniqueVehicleId = 0;
    private String model;
    private Vignette vignette;
    private final LocalDate yearOfManufacture;
    private final int vehicleNumber;

    Vehicle(String model,
            Vignette vignette) {
        if (Validator.isValidName(model)) {
            this.model = model;
        }
        if (vignette != null) {
            this.vignette = vignette;
        }
        long minDay = LocalDate.EPOCH.toEpochDay();
        long maxDay = LocalDate.now().toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        yearOfManufacture = LocalDate.ofEpochDay(randomDay);
        vehicleNumber = uniqueVehicleId++;
    }

    @Override
    public String toString() {
        return "Vehicle model: " + model +
                "\nVignette: " + vignette +
                "\nYear of manufacture: " + yearOfManufacture +
                "\nVehicle number: " + vehicleNumber + "\n";
    }

    public int getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVignette(Vignette vignette) {
        this.vignette = vignette;
    }

    public Vignette getVignette() {
        return vignette;
    }

    public abstract VehicleType getVehicleType();
}
