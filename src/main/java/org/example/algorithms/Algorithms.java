package org.example.algorithms;

public class Algorithms {

    //{-5,5,2, 5, 7, -1} ->int[2]= [5,7]
    public int[] findTwoMax(final int[] arr) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
           int min = Math.min(max1, max2);
            if (arr[i] > min) {
                if (min == max1) {
                    max1 = arr[i];
                } else {
                    max2 = arr[i];
                }
            }
        }
        return new int[]{max1, max2};
    }
}
