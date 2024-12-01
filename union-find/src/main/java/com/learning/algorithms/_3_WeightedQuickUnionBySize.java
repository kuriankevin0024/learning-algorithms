package com.learning.algorithms;

public class _3_WeightedQuickUnionBySize implements UnionFind {

    private final int[] parent;
    private final int[] size;
    private int count;


    public _3_WeightedQuickUnionBySize(int n) {
        parent = new int[n];
        size = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    @Override
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        }
        if (size[rootX] < size[rootY]) {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        } else {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }
        count--;
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
        return count;
    }
}
