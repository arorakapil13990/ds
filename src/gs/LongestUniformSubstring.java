package gs;


// for the input: "abbbccda" the longest uniform substring is "bbb"
// (which starts at index 1 and is 3 characters long).
public class LongestUniformSubstring {

    public static void longestUniformSubstring(String str) {

        if (str.isEmpty()) {
            System.out.println("-1,0");
            return;
        }
        int startIndex;
        int endIndex = 0;
        int maxLength = 0;
        int startIndexOfRepeatingCharacter = 0;
        int endIndexOfRepeatingCharacter = 0;
        str = str.toUpperCase();
        int n = str.length();

        for (int i = 0; i < n; i++) {
            startIndex = i;
            while (i < n - 1 && str.charAt(i) == str.charAt(i + 1)) {
                i++;
                endIndex = i;
            }

            if (maxLength < (endIndex - startIndex) + 1) {
                startIndexOfRepeatingCharacter = startIndex;
                endIndexOfRepeatingCharacter = i;
                maxLength = (endIndex - startIndex) + 1;
            }
        }
        System.out.println(str + " " +maxLength + " "  + startIndexOfRepeatingCharacter + " " + endIndexOfRepeatingCharacter);
    }


    public static void main(String[] args) {
        longestUniformSubstring("abcdggggggg");
        longestUniformSubstring("");
        longestUniformSubstring("10000111");
        longestUniformSubstring("aabbbbbCdAA");
        longestUniformSubstring("aabb");
        longestUniformSubstring("abbCCCddBBBxx");

    }

}
