package main;

import main.dishes.Dessert;
import main.dishes.Dish;
import main.dishes.MainDish;
import main.dishes.Salad;
import main.drinks.AlcoholicDrink;
import main.drinks.Drink;
import main.drinks.NonAlcoholicDrink;
import main.util.Randomizator;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    HashMap<Type, HashMap<Kind, HashMap<Dish, Integer>>> dishes;
    HashMap<Type, HashMap<Kind, HashMap<Drink, Integer>>> drinks;

    Menu() {
        dishes = new HashMap<>();
        drinks = new HashMap<>();
    }

    void generateMenu() {
        for (int i = 0; i < 10; i++) {
            Dish salad = new Salad();
            Dish main = new MainDish();
            Dish dessert = new Dessert();
            addDish(salad, Kind.SALAD);
            addDish(main, Kind.MAIN_DISH);
            addDish(dessert, Kind.DESSERT);
        }
        for (int i = 0; i < 20; i++) {
            Drink alcohol = new AlcoholicDrink();
            Drink nonAlcohol = new NonAlcoholicDrink();
            addDrink(alcohol, Kind.ALCOHOL);
            addDrink(nonAlcohol, Kind.NON_ALCOHOL);
        }
    }

    void addDish(Dish dish, Kind kind) {
        if (!dishes.containsKey(Type.FOOD)) {
            dishes.put(Type.FOOD, new HashMap<>());
        }
        if (!dishes.get(Type.FOOD).containsKey(kind)) {
            dishes.get(Type.FOOD).put(kind, new HashMap<>());
        }
        if (!dishes.get(Type.FOOD).get(kind).containsKey(dish)) {
            dishes.get(Type.FOOD).get(kind).put(dish, 1);
        }
        dishes.get(Type.FOOD).get(kind).put(dish, dishes.get(Type.FOOD).get(kind).get(dish) + 1);
    }

    void addDrink(Drink drink, Kind kind) {
        if (!drinks.containsKey(Type.DRINK)) {
            drinks.put(Type.DRINK, new HashMap<>());
        }
        if (!drinks.get(Type.DRINK).containsKey(kind)) {
            drinks.get(Type.DRINK).put(kind, new HashMap<>());
        }
        if (!drinks.get(Type.DRINK).get(kind).containsKey(drink)) {
            drinks.get(Type.DRINK).get(kind).put(drink, 1);
        }
        drinks.get(Type.DRINK).get(kind).put(drink, drinks.get(Type.DRINK).get(kind).get(drink) + 1);
    }

    public void removeDish(Dish dish, Kind kind) {
        if (dishes.containsKey(Type.FOOD)) {
            if (dishes.get(Type.FOOD).containsKey(kind)) {
                if (dishes.get(Type.FOOD).get(kind).containsKey(dish) &&
                        dishes.get(Type.FOOD).get(kind).get(dish) > 0) {
                    dishes.get(Type.FOOD).get(kind).put(dish, dishes.get(Type.FOOD).get(kind).get(dish) - 1);
                }
            }
        } else {
            System.out.println("No such dish in the menu!");
        }
    }

    public void removeDrink(Drink drink, Kind kind) {
        if (drinks.containsKey(Type.DRINK)) {
            if (drinks.get(Type.DRINK).containsKey(kind)) {
                if (drinks.get(Type.DRINK).get(kind).containsKey(drink) &&
                        drinks.get(Type.DRINK).get(kind).get(drink) > 0) {
                    drinks.get(Type.DRINK).get(kind).put(drink, drinks.get(Type.DRINK).get(kind).get(drink) - 1);
                }
            }
        } else {
            System.out.println("No such drink in the menu!");
        }
    }

    public Dish getRandomDish(Type type, Kind kind) {
        int dishIdx = Randomizator.randomNumInRange(0, dishes.get(type).get(kind).size());
        int currIdx = 0;
        for (Dish d : dishes.get(type).get(kind).keySet()) {
            if (currIdx == dishIdx) {
                return d;
            }
            currIdx++;
        }
        return null;
    }

    public Drink getRandomDrink(Type type, Kind kind) {
        int drinkIdx = Randomizator.randomNumInRange(0, drinks.get(type).get(kind).size());
        int currIdx = 0;
        for (Drink d : drinks.get(type).get(kind).keySet()) {
            if (currIdx == drinkIdx) {
                return d;
            }
            currIdx++;
        }
        return null;
    }

    void showMenu() {
        for (Map.Entry<Kind, HashMap<Dish, Integer>> d : dishes.get(Type.FOOD).entrySet()) {
            for (Map.Entry<Dish, Integer> dish : d.getValue().entrySet()) {
                System.out.println(dish.getKey().getName() + " : " + dish.getValue());
            }
        }
        for (Map.Entry<Kind, HashMap<Drink, Integer>> d : drinks.get(Type.DRINK).entrySet()) {
            for (Map.Entry<Drink, Integer> drink : d.getValue().entrySet()) {
                System.out.println(drink.getKey().getName() + " : " + drink.getValue());
            }
        }
    }
}
