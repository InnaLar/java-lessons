package org.example.hw2;

public class MyArray {

    private static final int ARRAY_DIMENSION = 4;

    public static int arraySum(final String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr.length != ARRAY_DIMENSION) {
            throw new MyArraySizeException();
        }
        for (String[] subArray : arr
        ) {
            if (subArray.length != ARRAY_DIMENSION) {
                throw new MyArraySizeException();
            }
        }
        int mySum = 0;
        int myInt = 0;
        for (int i = 0; i < ARRAY_DIMENSION; i++) {
            for (int j = 0; j < ARRAY_DIMENSION; j++) {
                try {
                    myInt = Integer.parseInt(arr[i][j]);
                    mySum += myInt;
                    System.out.println(mySum);

                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }

            }
        }
        return mySum;
    }
}
