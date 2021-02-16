package main;

import main.Vehicle.Bus;
import main.Vehicle.Car;
import main.Vehicle.Truck;
import main.Vehicle.Vehicle;
import main.Vignette.*;

import java.time.LocalDate;

public class Demo {
    public static void main(String[] args) {
        GasStation gaz = new GasStation();
        gaz.showVignettes();

        Driver peter = new Driver("Peter",
                2500,
                gaz);

        Vignette vignette1 = new CarVignette(VignetteType.WEEK);
        Vignette vignette2 = new BusVignette(VignetteType.MONTH);
        Vignette vignette3 = new TruckVignette(VignetteType.YEAR);

        LocalDate date = LocalDate.of(2020, 1, 26);
        vignette1.changeValidity(date, VignetteType.YEAR);

        Vehicle lada = new Car("Lada", vignette1);
        Vehicle schoolBus = new Bus("211", vignette2);
        Vehicle truck = new Truck("MARK", vignette3);

        peter.addVehicle(lada);
        peter.addVehicle(schoolBus);
        peter.addVehicle(truck);

        peter.showExpiredVignettes();
        System.out.println();
        peter.buyVignettes(VignetteType.MONTH);

        System.out.println("\n----------------------------------------------");
        System.out.println("\t\t\t\tGas Station");
        System.out.println("----------------------------------------------");
        System.out.println("Day Money Balance: " + gaz.getDayMoney() + "$");
        System.out.println("----------------------------------------------");
    }
}
