import java.util.Arrays;
import java.util.Comparator;

public class Sort {

    static void sortInDictionaryFormat(String str) {

        String[] words = str.split(" ");
        String[] word = str.split(" ");
        int i, j;

        for (i = 0; i < words.length; i++) {
            for (j = i + 1; j < words.length; j++) {

                if (words[i].compareTo(words[j]) > 0) {

                    String temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;

                }
            }
        }

        //Comparator<String> comp = Comparator.naturalOrder();
         Comparator<String> comp = String::compareTo;
        //Comparator<String> comp = (o1, o2) -> o1.compareTo(o2);

        Arrays.stream(word).sorted(comp).forEach(System.out::println);
        System.out.println("0000000");
        Arrays.stream(words).forEach(System.out::println);

    }


    public static void main(String[] args) {
        sortInDictionaryFormat("a quick brown fox jump over a lazy dog");
    }
}
