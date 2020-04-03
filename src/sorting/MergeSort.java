package sorting;

import java.util.Arrays;

public class MergeSort {


    private void sort(int a[], int low, int high) {

        if (low < high) {
            int mid = (low + high) / 2;
            sort(a, low, mid);  // sort left
            sort(a, mid + 1, high); // sort right
            merge(a, low, mid, high); // finally merge
        }
    }

    private void merge(int a[], int low, int mid, int high) {

        int l1 = mid - low + 1;
        int l2 = high - mid;

        int n1[] = new int[l1];
        int n2[] = new int[l2];

        for (int i = 0; i < l1; i++)
            n1[i] = a[low + i];
        for (int j = 0; j < l2; j++)
            n2[j] = a[mid + 1 + j];

        int i = 0, j = 0;

        int k = low; // Initial index of merged sub-array array

        while (i < l1 && j < l2) {
            if (n1[i] <= n2[j]) {
                a[k] = n1[i];
                i++;
            } else {
                a[k] = n2[j];
                j++;
            }
            k++;
        }

        while (i < l1) {
            a[k] = n1[i];
            i++;
            k++;
        }

        while (j < l2) {
            a[k] = n2[j];
            j++;
            k++;
        }

    }

    public static void main(String[] args) {

        int a[] = {12, 11, 13, 5, 6, 7};

        MergeSort m = new MergeSort();
        m.sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
