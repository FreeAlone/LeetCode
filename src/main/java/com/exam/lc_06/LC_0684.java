package com.exam.lc_06;

import com.exam.util.LC_Utils;

public class LC_0684 {

    public static void main(String[] args) {
        int[][] edges1 = {{1,2}, {1,3}, {2,3}};
        int[][] edges2 = {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
        LC_0684 lc_0684 = new LC_0684();
        LC_Utils.printArr(lc_0684.findRedundantConnection(edges1));
        LC_Utils.printArr(lc_0684.findRedundantConnection(edges2));
    }

    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        int[] parent = init(len);
        for (int[] edge : edges) {
            if (find(parent, edge[0]) != find(parent, edge[1])) {
                union(parent, edge[0], edge[1]);
            } else {
                return edge;
            }
        }
        return new int[0];
    }

    public int[] init(int n) {
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        return parent;
    }

    public int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }

    public void union(int[] parent, int x, int y) {
        parent[find(parent, y)] = find(parent, x);
    }
}
