package main.clients;

import main.Kind;
import main.Menu;
import main.Type;
import main.Waiter;
import main.constants.Constants;
import main.dishes.Dish;
import main.drinks.Drink;

public class Vegan extends Client {
    public Vegan() {
        super(Constants.VEGAN_MONEY);
    }

    @Override
    public void makeOrder(Waiter waiter, Menu menu) {
        waiter.assignClient(this);
        super.assignWaiter(waiter);
        double maxOrderPrice = (super.getMoney() * 90) / 100;
        boolean hasMoney = true;

        do {
            Dish dish = menu.getRandomDish(Type.FOOD, Kind.SALAD);
            if (dish.getPrice() < maxOrderPrice) {
                maxOrderPrice -= dish.getPrice();
                waiter.addToOrder(this, dish.getPrice());
                reduceMoney(dish.getPrice());
                menu.removeDish(dish, Kind.SALAD);
            } else {
                hasMoney = false;
            }

            Drink drink = menu.getRandomDrink(Type.DRINK, Kind.NON_ALCOHOL);
            if (drink.getPrice() < maxOrderPrice) {
                maxOrderPrice -= drink.getPrice();
                waiter.addToOrder(this, drink.getPrice());
                reduceMoney(drink.getPrice());
                menu.removeDrink(drink, Kind.NON_ALCOHOL);
            } else {
                hasMoney = false;
            }
        } while (hasMoney);
    }
}
