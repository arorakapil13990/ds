package java8;

import java.net.CookieHandler;
import java.util.*;
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

        // highest calories

        System.out.println(menu.stream().mapToInt(Dish::getCalories).max().getAsInt());


        /*Map<CaloricLevel, List<Dish>> map = menu.stream().collect(
                Collectors.groupingBy(d -> {
                    if(d.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (d.getCalories() <=700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                })
        );
       // map.entrySet().stream().forEach(m -> System.out.println(m));
        //map.entrySet().stream().forEach(m -> System.out.println(m));*/


       /* Map<Type,Map<CaloricLevel,List<Dish>>> map = menu.stream().collect(
                Collectors.groupingBy(Dish::getType,Collectors.groupingBy(
                        d -> {
                            if(d.getCalories() <= 400) return CaloricLevel.DIET;
                            else if (d.getCalories() <=700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;
                        })
                )
        );
        map.entrySet().stream().forEach(System.out::println);*/

        /*Map<Type,Dish> map = menu.stream().collect(Collectors.groupingBy(Dish::getType,
                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)),Optional::get)));
        map.entrySet().stream().forEach(System.out::println);*/


        Map<Type,Set<CaloricLevel>> map = menu.stream().collect(Collectors.groupingBy(Dish::getType,
                Collectors.mapping(d ->{
                    if(d.getCalories() <=400) return CaloricLevel.DIET;
                    else if (d.getCalories() <=700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                },Collectors.toCollection(HashSet::new))));
        map.entrySet().stream().forEach(System.out::println);


      //  System.out.println(menu.stream().collect(Collectors.maxBy(Comparator.comparing(Dish::getCalories))).get());
        //System.out.println(menu.stream().collect(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))).get());
        //System.out.println(menu.stream().max(Comparator.comparingInt(Dish::getCalories)));

        //System.out.println(menu.stream().mapToInt(Dish::getCalories).sum());
       // System.out.println(menu.stream().map(Dish::getCalories).reduce(0,Integer::sum));
        //IntSummaryStatistics intSummaryStatistics = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        //System.out.println(intSummaryStatistics);

       // System.out.println(menu.stream().collect(Collectors.reducing(0,Dish::getCalories,Integer::sum)));

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
