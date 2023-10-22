package org.example.hw3_1;

public class ArrayObj {

    public static <T> void swap(final T[] elements, final int i, final int j) {
        if (i >= elements.length || j >= elements.length) {
            throw new MyArrayMethodException();
        }
        final T t = elements[j];
        elements[j] = elements[i];
        elements[i] = t;
    }
}
