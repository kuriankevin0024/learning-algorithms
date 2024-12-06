package com.learning.algorithms.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class ResizingArrayStack<T> implements Stack<T> {

    private int size = 0;
    private T[] stack;

    @SuppressWarnings("unchecked")
    public ResizingArrayStack() {
        stack = (T[]) new Object[1];
    }

    @Override
    public void push(T element) {
        if (size == stack.length) {
            resize(2 * stack.length);
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
        if (size > 0 && size == stack.length / 4) {
            resize(stack.length / 2);
        }
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

    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        T[] newStack = (T[]) new Object[capacity];
        System.arraycopy(stack, 0, newStack, 0, size);
        stack = newStack;
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
}
