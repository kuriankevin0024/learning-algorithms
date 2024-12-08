package com.learning.algorithms.bag;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public final class ResizingArrayBag<T> implements Bag<T> {

    private int size = 0;
    private T[] bag;

    @SuppressWarnings("unchecked")
    public ResizingArrayBag() {
        bag = (T[]) new Object[1];
    }

    @Override
    public void add(T element) {
        if (size == bag.length) {
            resize(bag.length * 2);
        }
        bag[size++] = element;
    }

    public void remove(T element) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(bag[i], element)) {
                for (int j = i; j < size - 1; j++) {
                    bag[j] = bag[j + 1];
                }
                bag[--size] = null;
                if (size > 0 && size == bag.length / 4) {
                    resize(bag.length / 2);
                }
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

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        T[] newBag = (T[]) new Object[newCapacity];
        System.arraycopy(bag, 0, newBag, 0, size);
        bag = newBag;
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
}
