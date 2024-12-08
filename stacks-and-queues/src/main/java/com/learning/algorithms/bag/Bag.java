package com.learning.algorithms.bag;

public interface Bag<T> extends Iterable<T> {
    void add(T element);
    void remove(T element);
    boolean isEmpty();
    int size();   
}
