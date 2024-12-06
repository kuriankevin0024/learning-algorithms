package com.learning.algorithms.bag;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class ResizingArrayBag<T> implements Bag<T> {

    private int size = 0;
    private T[] bag;

    @SuppressWarnings("unchecked")
    public ResizingArrayBag() {
        bag = (T[]) new Object[1];
    }

    @Override
    public void add(T element) {
        if (size == bag.length) resize(2 * bag.length);
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
            if (!hasNext()) throw new NoSuchElementException("No more elements in the bag.");
            return bag[currentIndex++];
        }
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        T[] newBag = (T[]) new Object[newCapacity];
        System.arraycopy(bag, 0, newBag, 0, size);
        bag = newBag;
    }
}
