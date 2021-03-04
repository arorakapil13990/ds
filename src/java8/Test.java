package java8;

import java.net.CookieHandler;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork",false,800,Type.MEAT),
                new Dish("beef",false,700,Type.MEAT),
                new Dish("chicken",false,400,Type.MEAT),
                new Dish("french fries",true,530,Type.OTHER),
                new Dish("rice",true,350,Type.OTHER),
                new Dish("season fruit",true,120,Type.OTHER),
                new Dish("pizza",true,550,Type.OTHER),
                new Dish("prawns",false,300,Type.FISH),
                new Dish("salmon",false,450,Type.FISH)

        );

      //  System.out.println(menu.stream().collect(Collectors.maxBy(Comparator.comparing(Dish::getCalories))).get());
        //System.out.println(menu.stream().collect(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))).get());
        //System.out.println(menu.stream().max(Comparator.comparingInt(Dish::getCalories)));

        //System.out.println(menu.stream().mapToInt(Dish::getCalories).sum());
       // System.out.println(menu.stream().map(Dish::getCalories).reduce(0,Integer::sum));
        //IntSummaryStatistics intSummaryStatistics = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        //System.out.println(intSummaryStatistics);

        System.out.println(menu.stream().collect(Collectors.reducing(0,Dish::getCalories,Integer::sum)));

        /*menu.stream()
                .filter(DishPredicate.isCalorieGreaterThan300())
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        menu.stream()
                .filter(DishPredicate.isCalorieGreaterThan300())
                .skip(2)
                .limit(3)
                .map(Dish::getName)
                .forEach(System.out::println);*/

    }
}
