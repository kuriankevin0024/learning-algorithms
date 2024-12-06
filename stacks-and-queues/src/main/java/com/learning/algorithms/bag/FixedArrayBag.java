package com.learning.algorithms.bag;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class FixedArrayBag<T> implements Bag<T> {

    private int size = 0;
    private final T[] bag;

    @SuppressWarnings("unchecked")
    public FixedArrayBag(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive.");
        }
        bag = (T[]) new Object[capacity];
    }

    @Override
    public void add(T element) {
        if (size == bag.length) {
            throw new IllegalStateException("Bag is full.");
        }
        bag[size++] = element;
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
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the bag.");
            }
            return bag[currentIndex++];
        }
    }

    public int getRemainingCapacity() {
        return bag.length - size;
    }
}