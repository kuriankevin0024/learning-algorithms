package com.learning.algorithms;

import java.util.HashSet;
import java.util.Set;

public class _2_QuickUnion implements UnionFind {

    private final int[] parent;

    public _2_QuickUnion(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    @Override
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        parent[rootX] = rootY;
    }

    @Override
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    @Override
    public int find(int i) {
        while (i != parent[i]) {
            i = parent[i];
        }
        return i;
    }

    @Override
    public int count() {
        Set<Integer> uniqueRoots = new HashSet<>();
        for (int i = 0; i < parent.length; i++) {
            uniqueRoots.add(find(i));
        }
        return uniqueRoots.size();
    }
}
