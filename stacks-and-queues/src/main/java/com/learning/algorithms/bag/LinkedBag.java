package com.learning.algorithms.bag;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class LinkedBag<T> implements Bag<T> {

    private int size = 0;
    private Node<T> head = null;

    private static class Node<T> {
        final T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.next = head;
        head = newNode;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new BagIterator();
    }

    private class BagIterator implements Iterator<T> {
        private Node<T> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the bag.");
            }
            T data = current.data;
            current = current.next;
            return data;
        }
    }
}
