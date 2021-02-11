package main.dishes;

import main.constants.Constants;
import main.util.Randomizator;

public class MainDish extends Dish {
    public MainDish() {
        super(
                Constants.MAIN_DISHES[Randomizator.randomNumInRange(
                        0,
                        Constants.MAIN_DISHES.length
                )],
                Randomizator.randomNumInRange(400, 800)
        );
    }

    @Override
    public double getPrice() {
        return Constants.MAIN_PRICE;
    }
}
