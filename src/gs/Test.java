package gs;

public class Test {


    public static double shortestDistance(String paragraph, String word1, String word2) {
        String[] wordsFromParagraph = paragraph.split("[,. ]");

        int wordIndex = 0;
        double wordOneLocation = 0;
        double wordTwoLocation = 0;
        double shortestDistance = paragraph.length();

        for (String word : wordsFromParagraph) {
            if (word.equalsIgnoreCase(word1)) {
                wordOneLocation = wordIndex + (word.length() / 2d);
            } else if (word.equalsIgnoreCase(word2)) {
                wordTwoLocation = wordIndex + (word.length() / 2d);
            }

            if (wordOneLocation > 0 && wordTwoLocation > 0) {
                double current = Math.abs(wordOneLocation - wordTwoLocation);
                if (current < shortestDistance) {
                    shortestDistance = current;
                }
            }

            wordIndex += word.length() + 1;
        }

        if (wordOneLocation == 0 || wordTwoLocation == 0) {
            return -1;
        }

        return Math.floor(shortestDistance);
    }

    public static boolean pass() {
        return  shortestDistance(document, "and", "graphic") == 6d
                && shortestDistance(document, "transfer", "it") == 14d
                && shortestDistance(document, "Design", "filler") == 25d;
    }

    public static void main(String[] args) {
        if (pass()) {
            System.out.println("Pass");
        } else {
            System.out.println("Some Fail");
        }

        System.out.println(shortestDistance("geeks for geeks contribute practice ","geeks","practice"));
        System.out.println(shortestDistance("Example we just made up ","we","just"));
    }

    private static final String document;
    static {
        StringBuffer sb = new StringBuffer();
        sb.append(
                "In publishing and graphic design, lorem ipsum is a filler text commonly used to demonstrate the graphic elements");
        sb.append(
                " lorem ipsum text has been used in typesetting since the 1960s or earlier, when it was popularized by advertisements");
        sb.append(
                " for Letraset transfer sheets. It was introduced to the Information Age in the mid-1980s by Aldus Corporation, which");

        document = sb.toString();
    }
}
