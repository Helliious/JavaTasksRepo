package main.Vignette;

import main.Constants.Constants;

public class TruckVignette extends Vignette {
    public TruckVignette(VignetteType type) {
        super(VignetteKind.TRUCK, type);
    }

    //Calculating price for a truck vignette
    @Override
    public int getPrice() {
        switch (getType()) {
            case MONTH:
                return Constants.WEEK_TRUCK_VIGNETTE_PRICE * 10;
            case YEAR:
                return Constants.WEEK_TRUCK_VIGNETTE_PRICE * 10 * 6;
            default:
                return Constants.WEEK_TRUCK_VIGNETTE_PRICE;
        }
    }

    @Override
    public void glueUp() {
        System.out.println("Took 10 seconds!");
    }

    @Override
    public VignetteKind getKind() {
        return VignetteKind.TRUCK;
    }
}
