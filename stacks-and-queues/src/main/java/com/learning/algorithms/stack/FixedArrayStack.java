package com.learning.algorithms.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class FixedArrayStack<T> implements Stack<T> {

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
    public void push(T element) {
        if (size == stack.length) {
            throw new IllegalStateException("Stack is full");
        }
        stack[size++] = element;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        T element = stack[--size];
        stack[size] = null;
        return element;
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
        private int currentIndex = size;

        @Override
        public boolean hasNext() {
            return currentIndex > 0;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the stack.");
            }
            return stack[--currentIndex];
        }
    }

    public int getRemainingCapacity() {
        return stack.length - size;
    }
}
