package main.drinks;

import main.constants.Constants;
import main.util.Randomizator;

public class AlcoholicDrink extends Drink {
    public AlcoholicDrink() {
        super(
                Constants.ALCOHOL_NAMES[Randomizator.randomNumInRange(
                        0,
                        Constants.ALCOHOL_NAMES.length
                )],
                Constants.ALCOHOL_PRICE
        );
    }
}
