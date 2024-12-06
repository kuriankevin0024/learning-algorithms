package com.learning.algorithms.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FixedArrayStack<T> implements Stack<T> {

    private int size = 0;
    private final T[] stack;

    @SuppressWarnings("unchecked")
    public FixedArrayStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        stack = (T[]) new Object[capacity];
    }

    @Override
    public void push(T item) {
        if (size == stack.length) {
            throw new IllegalStateException("Stack is full");
        }
        stack[size++] = item;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        T item = stack[--size];
        stack[size] = null;
        return item;
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
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return stack[size - 1];
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {
        private int current = size;

        @Override
        public boolean hasNext() {
            return current > 0;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return stack[--current];
        }
    }

    public int remainingCapacity() {
        return stack.length - size;
    }
}
