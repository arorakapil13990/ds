package java8;

import java.util.function.Predicate;

public class DishPredicate {

    public static Predicate<Dish> isCalorieGreaterThan300() {
        return d -> d.getCalories() > 300;
    }
}
