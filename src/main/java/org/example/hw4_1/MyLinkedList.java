package org.example.hw4_1;

// todo: implement
public class MyLinkedList<E> implements MyList<E> {

    Node<E> first;

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(final Object o) {
        return false;
    }

    @Override
    public boolean add(final E e) {
        return false;
    }

    @Override
    public boolean remove(final Object o) {
        return false;
    }

    @Override
    public void clear() {
        // TODO document why this method is empty
    }

    @Override
    public E get(final int index) {
        return null;
    }

    private static class Node<E> {

        E item;
        Node<E> next;

        Node(final E element, final Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }
}
