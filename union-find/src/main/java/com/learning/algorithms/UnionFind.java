package com.learning.algorithms;

/**
 * The UnionFind interface provides methods for performing
 * union and find operations on a collection of elements,
 * effectively managing disjoint sets.
 */
public interface UnionFind {

    /**
     * Merges the sets containing elements {@code x} and {@code y}.
     * If the elements are already in the same set, no action is taken.
     *
     * @param x the identifier of the first element
     * @param y the identifier of the second element
     */
    void union(int x, int y);

    /**
     * Determines whether elements {@code x} and {@code y} are in the same set.
     *
     * @param x the identifier of the first element
     * @param y the identifier of the second element
     * @return {@code true} if {@code x} and {@code y} are in the same set;
     *         {@code false} otherwise
     */
    boolean connected(int x, int y);

    /**
     * Finds and returns the root identifier of the set containing element {@code i}.
     * This method can be used to determine the set to which an element belongs.
     *
     * @param i the identifier of the element
     * @return the root identifier of the set containing {@code i}
     */
    int find(int i);

    /**
     * Returns the total number of distinct sets currently managed by the Union-Find structure.
     *
     * @return the number of disjoint sets
     */
    int count();
}
