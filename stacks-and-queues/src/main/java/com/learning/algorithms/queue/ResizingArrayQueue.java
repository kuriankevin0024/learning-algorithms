package com.learning.algorithms.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class ResizingArrayQueue<T> implements Queue<T> {

    private int size = 0;
    private int front = 0;
    private int rear = 0;
    private T[] queue;

    @SuppressWarnings("unchecked")
    public ResizingArrayQueue() {
        queue = (T[]) new Object[1];
    }

    @Override
    public void enqueue(T element) {
        if (size == queue.length) resize(2 * queue.length);
        queue[rear++] = element;
        if (rear == queue.length) rear = 0;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        T element = queue[front];
        queue[front] = null;
        front++;
        if (front == queue.length) front = 0;
        size--;
        if (size > 0 && size == queue.length / 4) resize(queue.length / 2);
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
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        return queue[front];
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        T[] newQueue = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[(front + i) % queue.length];
        }
        queue = newQueue;
        front = 0;
        rear = size;
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
            if (!hasNext()) throw new NoSuchElementException("No more elements in the queue.");
            T element = queue[(front + currentIndex) % queue.length];
            currentIndex++;
            return element;
        }
    }
}
