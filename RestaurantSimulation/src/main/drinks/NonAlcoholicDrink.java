package main.drinks;

import main.constants.Constants;
import main.util.Randomizator;

public class NonAlcoholicDrink extends Drink {
    public NonAlcoholicDrink() {
        super(
                Constants.NON_ALCOHOL_NAMES[Randomizator.randomNumInRange(
                        0,
                        Constants.NON_ALCOHOL_NAMES.length
                )],
                Constants.NON_ALCOHOL_PRICE
        );
    }
}
