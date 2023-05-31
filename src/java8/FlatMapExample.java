package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapExample {

    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(1, 2, 3);
        List<Integer> l1 = Arrays.asList(3, 4);

        /*List<int[]> list = l.stream().flatMap(i -> l1.stream().map(j -> new int[]{i,j})).collect(Collectors.toList());

        list.forEach(i -> System.out.println(Arrays.toString(i)));*/

        List<int[]> list = l.stream().flatMap(i -> l1.stream().filter(j -> (i+j)% 3 == 0).map(j-> new int[]{i,j})).collect(Collectors.toList());

        list.forEach(i -> System.out.println(Arrays.toString(i)));


        /*l.stream().flatMap(i -> l1.stream().map(j -> new int[]{i, j}))
                .forEach(a -> System.out.println(Arrays.toString(a)));

        int[] array = { 1, 2, 3, 4, 5 };
//https://www.techiedelight.com/difference-stream-of-arrays-stream-java/#:~:text=of()%20is%20just%20a%20wrapper%20over%20the%20Arrays.&text=For%20example%20if%20we%20pass,stream()%20returns%20an%20IntStream%20.
        Arrays.stream(array).forEach(System.out::println);
        Stream.of(array).forEach(System.out::println);*/
    }
}
