package org.example.hw2;

public class MyArray {
    private static final int arrayDimension = 4;
    public static int arraySum(String[][] arr) throws MyArraySizeException,MyArrayDataException {
        if (arr.length!=arrayDimension){
            throw new MyArraySizeException();
        }
        for (String[] subArray:arr
             ) {
            if (subArray.length!=arrayDimension){
                throw new MyArraySizeException();
            }
        }
        int mySum = 0;
        int myInt = 0;
        for (int i = 0; i<arrayDimension; i++){
            for (int j = 0; j<arrayDimension; j++){
                   try {
                       myInt = Integer.parseInt(arr[i][j]);
                       mySum += myInt;
                       System.out.println(mySum);
                   }
                   catch (NumberFormatException e){
                        throw new MyArrayDataException(i,j);
                   }

            }
        }
        return mySum;
    }
}
