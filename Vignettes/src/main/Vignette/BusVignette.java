package main.Vignette;

import main.Constants.Constants;

public class BusVignette extends Vignette {
    public BusVignette(VignetteType type) {
        super(VignetteKind.BUS, type);
    }

    //Calculating price for a bus vignette
    @Override
    public int getPrice() {
        switch (getType()) {
            case MONTH:
                return Constants.WEEK_BUS_VIGNETTE_PRICE * 10;
            case YEAR:
                return Constants.WEEK_BUS_VIGNETTE_PRICE * 10 * 6;
            default:
                return Constants.WEEK_BUS_VIGNETTE_PRICE;
        }
    }

    @Override
    public void glueUp() {
        System.out.println("Took 20 seconds!");
    }

    @Override
    public VignetteKind getKind() {
        return VignetteKind.BUS;
    }
}
