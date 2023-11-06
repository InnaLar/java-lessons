package org.example.algorithms;

public class Algorithms {

    //{-5,5,2, 5, 7, -1} ->int[2]= [5,7]
    public int[] findTwoMax(final int[] arr) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int elem: arr
             ) {
            int min = Math.min(max1, max2);
            if (elem > min) {
                if (min == max1) {
                    max1 = elem;
                } else {
                    max2 = elem;
                }
            }
        }
        return new int[]{max1, max2};
    }
}
