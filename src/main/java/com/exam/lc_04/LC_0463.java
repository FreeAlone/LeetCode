package com.exam.lc_04;

public class LC_0463 {

    public static void main(String[] args) {
        int[][] grid1 = {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
        };
        int[][] grid2 = {{1}};
        int[][] grid3 = {{1, 0}};
        LC_0463 lc_0463 = new LC_0463();
        System.out.println(lc_0463.islandPerimeter(grid1));
        System.out.println(lc_0463.islandPerimeter(grid2));
        System.out.println(lc_0463.islandPerimeter(grid3));
    }

    public int islandPerimeter(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    sum += getPerimeter(grid, i ,j);
                }
            }
        }
        return sum;
    }

    private int getPerimeter(int[][] grid, int i, int j) {
        int perimeter = 4;
        if (j > 0 && j < grid[i].length && grid[i][j-1] == 1) {
            perimeter--;
        }
        if (j >= 0 && j < grid[i].length - 1 && grid[i][j+1] == 1) {
            perimeter--;
        }
        if (i > 0 && i < grid.length && grid[i - 1][j] == 1) {
            perimeter--;
        }
        if (i >= 0 && i < grid.length - 1 && grid[i + 1][j] == 1) {
            perimeter--;
        }
        return perimeter;
    }
}
