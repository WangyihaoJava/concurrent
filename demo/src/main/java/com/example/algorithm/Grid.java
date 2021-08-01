package com.example.algorithm;

/**
 * @author wangyihao
 * @ClassName: Grid
 * @Description:
 * @date 2021/7/30 16:30
 */
public class Grid {
    public static void main(String[] args) {


        /**
         * class Solution {
         *     public int maxValue(int[][] grid) {
         *
         *     }
         * }
         *
         */


        int[][]grid = {
                {1,3,1,},{1,5,1},{4,2,1}
        };

        int m = grid.length, n = grid[0].length;
        for (int j = 1; j < n; j++) { // 初始化第一行
            grid[0][j] += grid[0][j - 1];
        }
        for (int i = 1; i < m; i++) { // 初始化第一列
            grid[i][0] += grid[i - 1][0];
        }
        /**
         * 依次生成的顺序
         * 1 3 1    1 4 5      1 4 5
         * 1 5 1    2 5 1      2 9 10
         * 4 2 1    6 2 1      6 11 12
         *
         * i-1就是当前位置上面一个的位置
         * j-1就是当前位置左边一个的位置
         */
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int i1 = grid[i][j - 1];
                int i2 = grid[i - 1][j];
                grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        System.out.println(grid[m - 1][n - 1]);

    }
}
