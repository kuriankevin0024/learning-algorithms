package com.learning.algorithms;

public class _4_WeightedQuickUnionByRank implements UnionFind {

    private final int[] parent;
    private final int[] rank;
    private int count;


    public _4_WeightedQuickUnionByRank(int n) {
        parent = new int[n];
        rank = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        }
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
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
