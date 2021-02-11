package main.dishes;

import java.util.Objects;

public abstract class Dish {
    private final String name;
    private final double grams;

    Dish(String name, double grams) {
        this.name = name;
        this.grams = grams;
    }

    public String getName() {
        return name;
    }

    public abstract double getPrice();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return Double.compare(dish.grams, grams) == 0 && Objects.equals(name, dish.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, grams);
    }
}
