package org.example.hw4_1;

public class MyLinkedList<E> implements MyList<E> {

    private Node<E> first;

    public MyLinkedList() {
        first = null;
    }

    @Override
    public int size() {
        if (first == null) {
            return 0;
        }
        Node<E> next = first;
        int i = 1;
        while (next.next != null) {
            i++;
        }
        return i;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(final Object o) {
        Node<E> next = first;
        while (next != null) {
            if (next.item.equals(o)) {
                return true;
            }
            next = next.next;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean add(final E e) {
        if (first == null) {
            first = (Node<E>) new Node<Object>(e, null);
            return true;
        }
        Node<E> next = first;
        while (next.next != null) {
            next = next.next;
        }
        next.next = new Node<>(e, null);
        return true;
    }

    @Override
    public boolean remove(final Object o) {
        Node<E> next = first;
        Node<E> previous = first;
        while (next != null) {
            if (next.item.equals(o)) {
                if (previous.equals(first)) {
                   first = first.next;
                   } else {
                     previous.next = next.next;
                }
                return true;
            }
            previous = next;
            next = next.next;
        }
        return false;
    }

    @Override
    public void clear() {
        first = null;
    }

    @Override
    public E get(final int index) {
        if (index < 0) {
            return null;
        }
        Node<E> next = first;
        int i = 0;
        while (next != null) {
            if (index == i) {
                return next.item;
            }
            next = next.next;
            i++;
        }
        return null;
    }

    /*@Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node<E> next = first;
        while (next != null) {
            if (next.item instanceof String) {
                result.append(next.item.toString()).append(" ");
            }
            next = next.next;
        }
        return result.toString();
    }*/

    private static class Node<E> {

        E item;
        Node<E> next;

        Node(final E element, final Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }
}

