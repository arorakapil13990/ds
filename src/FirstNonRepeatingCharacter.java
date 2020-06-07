import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FirstNonRepeatingCharacter {


    static void findFirstNonRepeatingCharacter(char[] st) {

        char[] ch = new char[256];
        int i, index = -1;

        for (i = 0; i < st.length; i++) {
            ch[st[i]]++;
        }
        //System.out.println(String.valueOf(ch));

        for (i = 0; i < st.length; i++) {
            if (ch[st[i]] == 1) {
                index = i;
                break;
            }
        }


        System.out.println(st[index]);
    }


    static void find(char[] st) {

        // linked hashmap
        List<Character> list = new LinkedList<>();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < st.length; i++) {
            Character ch = st[i];
            if (set.add(ch)) {
                list.add(ch);
            } else {
                list.remove(ch);
            }
        }
        System.out.println(list);
        System.out.println(list.get(0));
    }

    public static void main(String[] args) {
        //findFirstNonRepeatingCharacter(new char[]{'q', 'w', 'w', 'q', 'a', 'v'});
        find(new char[]{'q','k', 'w', 'w', 'q', 'a', 'v'});

    }
}
