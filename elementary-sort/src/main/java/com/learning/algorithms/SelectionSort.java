package com.learning.algorithms;

public class SelectionSort {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i; j < N; j++) {
                if (Sort.Static.less(a[j], a[min])) {
                    min = j;
                }
            }
            Sort.Static.exchange(a, i, min);
        }
    }
}
