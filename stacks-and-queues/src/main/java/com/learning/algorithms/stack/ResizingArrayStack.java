package com.learning.algorithms.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayStack<T> implements Stack<T> {

    private int size = 0;
    private T[] stack;

    @SuppressWarnings("unchecked")
    public ResizingArrayStack() {
        stack = (T[]) new Object[1];
    }

    @Override
    public void push(T item) {
        if (size == stack.length) {
            resize(2 * stack.length);
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
        if (size > 0 && size == stack.length / 4) {
            resize(stack.length / 2);
        }
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

    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        T[] copy = (T[]) new Object[capacity];
        // for better performance us arraycopy
        // System.arraycopy(stack, 0, copy, 0, size);
        for (int i = 0; i < stack.length; i++) {
            copy[i] = stack[i];
        }
        stack = copy;
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
}
