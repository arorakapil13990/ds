package gs;

public class DistanceBetweenTwoWords {

    // correct
    public static double distance(String paragraph, String wordOne, String wordTwo) {
        String[] wordsFromParagraph = paragraph.split("[,. ]");

        int wordIndex = 0;
        double wordOneLocation = 0;
        double wordTwoLocation = 0;
        double shortestDistance = paragraph.length();

        for (String word : wordsFromParagraph) {
            if (word.equalsIgnoreCase(wordOne)) {
                wordOneLocation = wordIndex + (word.length() / 2d);
            } else if (word.equalsIgnoreCase(wordTwo)) {
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

    public static double shortestDistance(String document, String word1, String word2) {
        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();
        document = document.toLowerCase();

        int shortestDist = Integer.MAX_VALUE;
        String[] words = document.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                for (int j = 0; j < words.length; j++) {
                    if (words[j].equals(word2)) {
                        int start = Math.min(i, j);
                        int end = Math.max(i, j);
                        int dist = end - start; // no of spaces
                        dist += (word1.length() + word2.length()) / 2;
                        for (int k = start + 1; k < end; k++) {
                            dist += words[k].length();
                        }
                        shortestDist = Math.min(shortestDist, dist);
                    }
                }
            }
        }
        System.out.println("word1 = " + word1 + ", word2 = " + word2 + ", shortestDist = " + shortestDist);
        return shortestDist;
    }

    public static boolean pass() {
        return distance(document, "and", "graphic") == 6d
                && distance(document, "transfer", "it") == 14d
                && distance(document, "Design", "filler") == 25d;
    }
/*

    public static boolean pass() {
        return distance(document, "geeks", "practice") == 18d;

        */
/*return shortestDistance(document, "and", "graphic") == 6d
                && shortestDistance(document, "transfer", "it") == 14d
                && shortestDistance(document, "Design", "filler") == 25d;*//*

    }
*/


    public static void main(String[] args) {
        if (pass()) {
            System.out.println("Pass");
        } else {
            System.out.println("Some Fail");
        }
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
        // document = "geeks for geeks contribute practice";

    }
}
