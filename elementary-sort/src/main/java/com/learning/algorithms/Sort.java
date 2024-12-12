package com.learning.algorithms;

public interface Sort<T extends Comparable<T>> {
    void sort(T[] a);

    default boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    default void exchange(T[] a, int i, int j) {
        T swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    default boolean isSorted(T[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])){
                return false;
            }
        }
        return true;
    }

    class Static {

        public static boolean less(Comparable v, Comparable w) {
            return v.compareTo(w) < 0;
        }

        public static void exchange(Comparable[] a, int i, int j) {
            Comparable swap = a[i];
            a[i] = a[j];
            a[j] = swap;
        }

        public static boolean isSorted(Comparable[] a) {
            for (int i = 1; i < a.length; i++) {
                if (less(a[i], a[i - 1])){
                    return false;
                }
            }
            return true;
        }
    }
}
