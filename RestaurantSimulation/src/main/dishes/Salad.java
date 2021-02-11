package main.dishes;

import main.constants.Constants;
import main.util.Randomizator;

public class Salad extends Dish {
    public Salad() {
        super(
                Constants.SALADS[Randomizator.randomNumInRange(
                        0,
                        Constants.SALADS.length
                )],
                Randomizator.randomNumInRange(300, 600)
        );
    }

    @Override
    public double getPrice() {
        return Constants.SALAD_PRICE;
    }
}
