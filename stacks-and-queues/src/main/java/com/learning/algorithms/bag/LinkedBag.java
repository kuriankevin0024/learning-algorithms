package com.learning.algorithms.bag;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

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

    public void remove(T element) {
        while (head != null && Objects.equals(head.data, element)) {
            head = head.next;
            size--;
        }

        if (head == null) {
            return;
        }
    
        Node<T> current = head;
        Node<T> prev = null;
        while (current != null) {
            if (Objects.equals(current.data, element)) {
                prev.next = current.next;
                size--;
                current = current.next;
            } else {
                prev = current;
                current = current.next;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
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
