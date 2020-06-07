package gs;

public class Panagram {

    /*public static boolean isPanagram(String sentence) {
        boolean[] mark = new boolean[26];

        sentence = sentence.toUpperCase();


        for (int i = 0; i < sentence.length(); i++) {
            Character ch = sentence.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                mark[ch - 'A'] = true;
            }

        }

        for (int i = 0; i < 26; i++) {
            if (!mark[i]) {
                return false;
            }
        }

        return true;
    }
*/

    public static boolean isPanagram(String sentence) {
        boolean[] mark = new boolean[26];

        sentence = sentence.toUpperCase();


        for (int i = 0; i < sentence.length(); i++) {
            int ch = sentence.charAt(i);
            if (ch >= 65 && ch <= 90) {
                mark[ch - 65] = true;
            }

        }

        for (int i = 0; i < 26; i++) {
            if (!mark[i]) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        //String sentence = "The quick brown fox jumps over the lazy dog";
        String sentence = "The quick brown fox jumps over the dog";
        System.out.println(isPanagram(sentence));
    }
}
