package com.learning.algorithms;

public class _6_QUWithPathCompressionTwoPass implements UnionFind {

    private final int[] parent;
    private int count;

    public _6_QUWithPathCompressionTwoPass(int n) {
        parent = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    @Override
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootX] = rootY;
            count--;
        }
    }

    @Override
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    @Override
    public int find(int i) {
        int root = i;
        while (root != parent[root]) {
            root = parent[root];
        }
        while (i != root) {
            int next = parent[i];
            parent[i] = root;
            i = next;
        }
        return root;
    }

    @Override
    public int count() {
        return count;
    }
}
