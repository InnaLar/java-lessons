package org.example.hw3_1;

public class ArrayObj<T extends Object> {

    private T[] arrayObj;

    public ArrayObj(final T[] arrayObj) {
        this.arrayObj = arrayObj;
    }

    public void swap(final int i, final int j) {
        if (i >= arrayObj.length || j >= arrayObj.length) {
               throw new MyArrayMethodException();
            }
        final T t;
        t = arrayObj[j];
        arrayObj[j] = arrayObj[i];
        arrayObj[i] = t;
    }
}
