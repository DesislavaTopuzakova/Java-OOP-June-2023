package solid.products.food;

import solid.products.Product;
import solid.products.drink.Drink;

public abstract class BaseFood implements Food {

    private double grams;
    private double caloriesPer100Grams;

    public BaseFood(double grams, double caloriesPer100Grams) {
        this.grams = grams;
        this.caloriesPer100Grams = caloriesPer100Grams;
    }
    @Override
    public double getCalories() {
        return (caloriesPer100Grams / 100) * grams;
    }

    @Override
    public double getKilograms() {
        return this.grams / 1000;
    }

}
