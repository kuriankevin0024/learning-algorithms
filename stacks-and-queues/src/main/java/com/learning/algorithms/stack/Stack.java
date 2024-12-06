package com.learning.algorithms.stack;

public interface Stack<T> extends Iterable<T> {

    void push(T element);
    T pop();
    boolean isEmpty();
    int size();
    T peek();
}
