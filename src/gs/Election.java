package gs;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Election {


    public static int whoIsElected2(int n, int k) {
        List<Integer> list;
        list = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
        int i = -1;
        while (list.size() > 1) {
            list.remove((i + k) % list.size());
            i = (i + k) % (list.size() + 1) - 1;
        }
        return list.get(0);
    }


    public static void main(String[] args) {
        System.out.println(whoIsElected2(100, 2));
    }
}
