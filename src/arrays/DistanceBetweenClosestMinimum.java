package arrays;

public class DistanceBetweenClosestMinimum {

    public static void main(String[] args) {
        int a[] = {5, 1, 2, 3, 4, 1, 2, 1};

        int i, min = Integer.MAX_VALUE, dist = 0, minD = Integer.MAX_VALUE;

        for (i = 0; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }

        for (i = 0; i < a.length; i++) {
            if(i == 0  && a[0] == min){  // skip if zeroth index has smallest element
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
        if(dist < minD){
            minD = dist;
        }
        System.out.println(minD);
    }
}
