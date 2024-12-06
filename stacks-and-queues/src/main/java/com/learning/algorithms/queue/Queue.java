package com.learning.algorithms.queue;

public interface Queue<T> extends Iterable<T> {

    void enqueue(T element);
    T dequeue();
    boolean isEmpty();
    int size();
    T peek();
}
