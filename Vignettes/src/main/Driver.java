package main;

import main.Vehicle.Vehicle;
import main.Vignette.Vignette;
import main.Vignette.VignetteKind;
import main.Vignette.VignetteType;
import main.util.Validator;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Driver {
    private String name;
    private final HashMap<Integer, Vehicle> vehicles;
    private int money;
    private GasStation gasStation;

    Driver(String name,
           int money,
           GasStation gasStation) {
        if (Validator.isValidName(name)) {
            this.name = name;
        }
        vehicles = new HashMap<>();
        if (money > 0) {
            this.money = money;
        }
        if (gasStation != null) {
            this.gasStation = gasStation;
        }
    }

    void addVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.getVehicleNumber(), vehicle);
    }

    //Method for buying vignettes for all vehicles of the current driver
    void buyVignettes(VignetteType vignetteType) {
        for (Map.Entry<Integer, Vehicle> v : vehicles.entrySet()) {
            Vignette vignette;
            System.out.println("Buying " + v.getValue().getVehicleType() + " vignette...");
            //Checking vehicle type
            switch (v.getValue().getVehicleType()) {
                case CAR:
                    vignette = gasStation.sellVignette(vignetteType, VignetteKind.CAR);
                    break;
                case BUS:
                    vignette = gasStation.sellVignette(vignetteType, VignetteKind.BUS);
                    break;
                default:
                    vignette = gasStation.sellVignette(vignetteType, VignetteKind.TRUCK);
                    break;
            }

            //Calculating money balance and installing all new vignettes
            if (money < vignette.getPrice()) {
                System.out.println("Not enough money dude! Work more!");
                gasStation.returnVignette(vignette);
            } else {
                System.out.println("Vignette bought!");
                System.out.println("Installing " + vignette.getKind() + " vignette...");
                vignette.glueUp();
                money -= vignette.getPrice();
                v.getValue().setVignette(vignette);
            }
            System.out.println();
        }
    }

    //Method for buying a single vignette for a single vehicle
    void buyVignetteForVehicle(int vehicleNumber,
                               VignetteType vignetteType,
                               VignetteKind vignetteKind) {
        Vignette vignette = gasStation.sellVignette(vignetteType, vignetteKind);
        if (money < vignette.getPrice()) {
            System.out.println("Not enough money dude! Work more!");
            gasStation.returnVignette(vignette);
        } else {
            vignette.glueUp();
            money -= vignette.getPrice();
            vehicles.get(vehicleNumber).setVignette(vignette);
        }
    }

    //Method showing all expired vignettes
    void showExpiredVignettes() {
        LocalDate date = LocalDate.now();
        System.out.println("\n----------------------------------------------");
        System.out.println("Hi " + name + " here are your expired vehicles:");
        //Iterating on map entries and checking if current vignette is expired
        //If current vignette is expired -> show to the console
        for (Map.Entry<Integer, Vehicle> v : vehicles.entrySet()) {
            if (v.getValue().getVignette().getExpireDate().compareTo(date) < 0) {
                System.out.println("----------------------------------------------");
                System.out.print(v.getValue());
            }
        }
        System.out.println("----------------------------------------------");
    }
}
