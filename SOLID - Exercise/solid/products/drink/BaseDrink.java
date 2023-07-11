package solid.products.drink;

import solid.products.Product;

public abstract class BaseDrink implements Drink {
    private double milliliters;
    private double density;
    private double caloriesPer100Grams;

    public BaseDrink(double milliliters, double density, double caloriesPer100Grams) {
        this.milliliters = milliliters;
        this.density = density;
        this.caloriesPer100Grams = caloriesPer100Grams;
    }

    @Override
    public double getDensity() {
        return density;
    }

    @Override
    public double getCalories() {
        return (caloriesPer100Grams / 100) * (milliliters * density);
    }

    @Override
    public double getLiters() {
        return milliliters / 1000;
    }
}
