package org.example.hw4_1;

import java.util.Arrays;

public class MyArrayList<E> implements MyList<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private int arrSize;
    private int capacity;
    private Object[] elementData;

    public MyArrayList() {
        arrSize = 0;
        capacity = DEFAULT_CAPACITY;
        elementData = new Object[capacity];
    }

    @Override
    public int size() {
        return arrSize;
    }

    @Override
    public boolean isEmpty() {
        return arrSize == 0;
    }

    @Override
    public boolean contains(final Object o) {
        if (o == null) {
            return false;
        }
        for (Object elem : elementData) {
            if (elem.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(final E e) {
        if (arrSize == capacity) {
            capacity = (int) (1.5 * capacity);
            Object[] arrToExpend = new Object[capacity];
            System.arraycopy(elementData, 0, arrToExpend, 0, arrSize);
            arrToExpend[arrSize] = e;
            elementData = arrToExpend;
        } else {
            elementData[arrSize] = e;
        }
        arrSize++;
        return true;
    }

    @Override
    public boolean remove(final Object o) {
        for (int i = 0; i < elementData.length; i++) {
                if (elementData[i].equals(o)) {
                    System.arraycopy(elementData, i + 1, elementData, i, elementData.length - i - 1);
                    Arrays.fill((Object[]) elementData[arrSize - 1], null);
                    arrSize--;
                    return true;
                }
            }
        return false;
        }

    @Override
    public void clear() {
        Arrays.fill(elementData, null);
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(final int index) {
        if (elementData[index] != null) {

            return (E) elementData[index];

        }
        return null;
    }

    /*@Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Object o:elementData
             ) {
            if (o instanceof String) {
            result.append(o.toString()).append(" ");
            }
        }
        return result.toString();
    }*/
}
