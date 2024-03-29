package gs;

import java.util.*;
import java.util.stream.Collectors;

public class BestAverageGrade {

    public static Double bestAvgGrade(String[][] scores) {

        Map<String, List<Integer>> avgScoreListMap = new HashMap<>();

        Arrays.stream(scores).forEach(s -> {
            List<Integer> studentScores = avgScoreListMap.get(s[0]);
            if (studentScores == null) {
                studentScores = new ArrayList<>();
            }
            studentScores.add(Integer.parseInt(s[1]));
            avgScoreListMap.put(s[0], studentScores);
        });



        // convert map of list of integer to double
        Map<String, Double> map = avgScoreListMap.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        e -> e.getKey(),
                        e -> e.getValue().stream().mapToInt(s -> s).average().getAsDouble()
                ));
        
        // map.values().stream().reduce(Double::max).get()
        //System.out.println(map.values().stream().max(Double::compareTo));
        return map.values().stream().mapToDouble(s -> s).max().getAsDouble();
    }

    public static void main(String[] args) {
        String[][] s1 = {{"Rohan", "59"}, {"Sachin", "102"}, {"Ishan", "40"}, {"Sachin", "18"}};
        String[][] s2 = new String[][]{{"Bobby", "87"},
                {"Charles", "100"},
                {"Eric", "64"},
                {"Charles", "22"}};
        printBestAvg(s1);
        System.out.println(bestAvgGrade(s1));
        System.out.println(bestAvgGrade(s2));
    }

 private static void printBestAvg(String[][] s){

        Map<String, List<Integer>> map = new HashMap<>();

        Arrays.stream(s).forEach(arr -> {
            List<Integer> list = map.get(arr[0]);
            if(list == null){
                list = new ArrayList<>();
            }
            list.add(Integer.parseInt(arr[1]));
            map.put(arr[0],list);
        });

        Map<String , Double> doubleMap = map.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(),
                e -> e.getValue().stream().mapToInt(v -> v).average().getAsDouble()));

     System.out.println(doubleMap.values().stream().max(Double::compareTo).get());
 }
}
