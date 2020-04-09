package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FormBiggestNumber {

    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("54");
        l.add("546");
        l.add("548");
        l.add("60");

        Collections.sort(l, new Comparator<String>() {
            @Override
            public int compare(String X, String Y) {
                String XY = X + Y;
                String YX = Y + X;
                return XY.compareTo(YX) > 0 ? -1 : 1;
            }
        });
        l.stream().forEach(System.out::print);
    }
}
