package org.example.hw2;

public class MyApp {

    public static void main(final String[] args) {
        //String[][] intArr = {{"1","2","3","4"},{"5","6","7","8"},{"9","10","11","12"},{"13","14","15","16"}};
        //String[][] intArr = {{"1","1","1","1"},{"1","1","1","1"},{"1","1","1","1"},{"1","1","1","1"}};
        final String[][] intArr = {{"1", "2", "3", "4"},
                                   {"1", "2", "3", "4"},
                                   {"1", "2", "3", "4"},
                                   {"5", "6", "7", "ss"}};
        int arrSum = 0;
        try {
            arrSum = MyArray.arraySum(intArr);
        } catch (MyArraySizeException e) {
            System.out.println("Размерность массива не 4X4");
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        } finally {
            System.out.printf("Сумма = %d", arrSum);
        }

    }
}
