package com.learning.algorithms;

import java.util.HashSet;
import java.util.Set;

public class _1_QuickFind implements UnionFind {

    private final int[] parent;

    public _1_QuickFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    @Override
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == rootX) {
                parent[i] = rootY;
            }
        }
    }

    @Override
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    @Override
    public int find(int i) {
        return parent[i];
    }

    @Override
    public int count() {
        Set<Integer> uniqueRoots = new HashSet<>();
        for (int i : parent) {
            uniqueRoots.add(i);
        }
        return uniqueRoots.size();
    }
}
