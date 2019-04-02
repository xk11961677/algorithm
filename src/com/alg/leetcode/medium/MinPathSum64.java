package com.alg.leetcode.medium;

/**
 * 最短路径
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * @author
 */
public class MinPathSum64 {

    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];

        /**
         * 初始化第一行
         */
        for(int i=1; i<grid[0].length; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        /**
         * 初始化第一列
         */
        for(int i=1; i<grid.length; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for(int i=1; i<grid.length; i++) {
            for(int j=1; j<grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }


    public int[][] buildGrid(int m,int n, int[] data) {
        int[][] grid = new int[m][n];
        int l = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                grid[i][j] = data[l++];
            }
        }
        return grid;
    }

    public void print(int[][] grid) {
        for(int m=0; m<grid.length; m++) {
            for(int n=0; n<grid[0].length; n++) {
                System.out.print(grid[m][n]+"\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{1,3,1,1,5,1,4,2,1};

        MinPathSum64 minPathSum64 = new MinPathSum64();

        int[][] gird = minPathSum64.buildGrid(3, 3, data);

        minPathSum64.print(gird);

        int min = minPathSum64.minPathSum(gird);

        System.out.println("最小路径和:{} "+min);
    }

}
