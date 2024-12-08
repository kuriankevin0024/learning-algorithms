package com.learning.algorithms.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class FixedArrayQueue<T> implements Queue<T> {

    private int size = 0;
    private int head = 0;
    private int tail = 0;
    private final T[] queue;

    @SuppressWarnings("unchecked")
    public FixedArrayQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        queue = (T[]) new Object[capacity];
    }

    @Override
    public void enqueue(T element) {
        if (size == queue.length) {
            throw new IllegalStateException("Queue is full");
        }
        queue[tail] = element;
        tail = (tail + 1) % queue.length;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T element = queue[head];
        queue[head] = null;
        head = (head + 1) % queue.length;
        size--;
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
            throw new NoSuchElementException("Queue is empty");}
        return queue[head];
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the queue.");
            }
            T element = queue[(head + currentIndex) % queue.length];
            currentIndex++;
            return element;
        }
    }

    public int getRemainingCapacity() {
        return queue.length - size;
    }
}
