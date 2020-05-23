package sapient.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8MapExample {

    public static void main(String[] args) {

        List<Integer> numbers1 = Arrays.asList(1, 2);
        List<Integer> numbers2 = Arrays.asList(3, 4, 5);

        // find pairs

        List<int[]> array = numbers1.stream().
                flatMap(i -> numbers2.stream()
                        .map(j -> new int[]{i, j}))
                .collect(Collectors.toList());


        for (int i = 0; i < array.size(); i++) {
            System.out.println(Arrays.toString(array.get(i)));
        }


    }
}
