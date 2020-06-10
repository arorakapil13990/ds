package arrays;

// https://www.geeksforgeeks.org/distance-two-closest-minimum/?ref=lbp

import java.util.Arrays;

public class DistanceBetweenClosestMinimum {

    // correct
    static void minDist() {
        int a[] = {10,20,10,20,20,20,10};

        int min = Arrays.stream(a).min().getAsInt();
        System.out.println("Minimum :: "+ min);
        int i, minD = Integer.MAX_VALUE, lastIndex = -1, currentIndex = -1;

        for (i = 0; i < a.length; i++) {

            if (a[i] == min) {

                if (lastIndex == -1) {
                    lastIndex = i;
                    continue;
                }
                currentIndex = i;
                minD = Math.min(minD, currentIndex - lastIndex);
                lastIndex = currentIndex;
            }
        }

        System.out.println(minD);
    }



    public static void main(String[] args) {
      /*  //int a[] = {5, 1, 2, 3, 4, 1, 2, 1};
        int a[] = {10,20,10,20,20,20,10};

        int i, min = Integer.MAX_VALUE, dist = 0, minD = Integer.MAX_VALUE;

        for (i = 0; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }

        System.out.println("Minimum :: "+ min);
        for (i = 0; i < a.length; i++) {
            if (i == 0 && a[0] == min) {  // skip if zeroth index has smallest element
                continue;
            }
            if (a[i] == min) {
                if (dist == 0) {
                    dist = i;
                } else if ((i - dist) < minD) {
                    minD = i - dist;
                    dist = i;
                }
            }
        }

        // check if only single instance of minimum is present
        if (dist < minD) {
            minD = dist;
        }
        System.out.println(minD);*/
        minDist();
    }
}
