package main.Vignette;

import main.Constants.Constants;

public class CarVignette extends Vignette {
    public CarVignette(VignetteType type) {
        super(VignetteKind.CAR, type);
    }

    //Calculating price for a car vignette
    @Override
    public int getPrice() {
        switch (getType()) {
            case MONTH:
                return Constants.WEEK_CAR_VIGNETTE_PRICE * 10;
            case YEAR:
                return Constants.WEEK_CAR_VIGNETTE_PRICE * 10 * 6;
            default:
                return Constants.WEEK_CAR_VIGNETTE_PRICE;
        }
    }

    //Method for installing a vignette
    @Override
    public void glueUp() {
        System.out.println("Took 5 seconds!");
    }

    @Override
    public VignetteKind getKind() {
        return VignetteKind.CAR;
    }
}
