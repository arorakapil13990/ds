package arrays;

// https://www.youtube.com/watch?v=Z5AEc12ieOs

public class CelebrityProblem {
    public static void main(String[] args) {
        int a[][] = {{0, 1, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};

        System.out.println(findCeleb(a));
        System.out.println(findCelebrity(a));
    }


    // Time Complexity O(n2)
    // Space Complexity O(n)
    static int findCeleb(int a[][]) {
        int i, j;
        int n = a.length;
        int in[] = new int[n]; // in[i]++ ----- how many knows i;
        int out[] = new int[n]; // out[i]++ ----- how many i knows

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {

                if (a[i][j] == 1) {  // i knows j
                    in[j]++;
                    out[i]++;
                }
            }
        }

        for (i = 0; i < n; i++) {
            if (in[i] == n - 1 && out[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    static int findCelebrity(int a[][]) {
        int i, c = 0, n = a.length;
        for (i = 1; i < n; i++) {
            if (a[c][i] == 1) {
                c = i; // i.e c knows i :: c cannot be celebrity
            }
            // this loop is for check celebrity is correct or not
            for (i = 0; i < n; i++) {
                if (i != c && (a[c][i] == 1 || a[i][c] == 0)) {
                    return -1;
                }
            }
        }
        return c;
    }
}
