package main.clients;

import main.Kind;
import main.Menu;
import main.Type;
import main.Waiter;
import main.constants.Constants;
import main.dishes.Dish;
import main.drinks.Drink;
import main.util.Randomizator;

public class Student extends Client {
    public Student() {
        super(Constants.STUDENT_MONEY);
    }

    @Override
    public void makeOrder(Waiter waiter, Menu menu) {
        waiter.assignClient(this);
        super.assignWaiter(waiter);
        double maxOrderPrice = (super.getMoney() * 90) / 100;
        boolean hasMoney = true;

        do {
            Kind kind;
            int randomKind = Randomizator.randomNumInRange(0, 3);
            if (randomKind == 0) {
                kind = Kind.SALAD;
            } else if (randomKind == 1) {
                kind = Kind.MAIN_DISH;
            } else {
                kind = Kind.DESSERT;
            }

            Dish dish = menu.getRandomDish(Type.FOOD, kind);
            if (dish.getPrice() < maxOrderPrice) {
                maxOrderPrice -= dish.getPrice();
                waiter.addToOrder(this, dish.getPrice());
                reduceMoney(dish.getPrice());
                menu.removeDish(dish, kind);
            } else {
                hasMoney = false;
            }

            kind = Randomizator.randomNumInRange(0, 2) == 0 ? Kind.ALCOHOL : Kind.NON_ALCOHOL;
            Drink drink = menu.getRandomDrink(Type.DRINK, kind);
            if (drink.getPrice() < maxOrderPrice) {
                maxOrderPrice -= drink.getPrice();
                waiter.addToOrder(this, drink.getPrice());
                reduceMoney(drink.getPrice());
                menu.removeDrink(drink, kind);
            } else {
                hasMoney = false;
            }
        } while (hasMoney);
    }
}
