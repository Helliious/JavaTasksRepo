package main.dishes;

import main.constants.Constants;
import main.util.Randomizator;

public class Dessert extends Dish {
    public Dessert() {
        super(
                Constants.DESSERTS[Randomizator.randomNumInRange(
                        0,
                        Constants.DESSERTS.length
                )],
                Randomizator.randomNumInRange(200, 300)
        );
    }

    @Override
    public double getPrice() {
        return Constants.DESERT_PRICE;
    }
}
