package com.alg.dynamicprogramming;

/**
 * DP 方式求最长公共子序列
 * <p>
 * 因为 a[0...i] b[0...j] 中, a[i] b[j] lcss 由下面三个方程递推过来：max_lcss为最长子序列
 * <p>
 * (i-1,j-1,max_lcss)
 * (i-1,j,max_lcss)
 * (i,j-1,max_lcss)
 * <p>
 * 所以,状态转移方程式为:
 * 如果 a[i]  =  b[i] 时  max_lcss = max( max_lcss(i-1,j-1)+1, max_lcss(i-1,j), max_lcss(i,j-1) );
 * <p>
 * 如果 a[i] !=  b[i] 时  max_lcss = max( max_lcss(i-1,j-1), max_lcss(i-1,j), max_lcss(i,j-1) );
 *
 * @author
 */
@SuppressWarnings("all")
public class LCSubsequence {

    private char[] a = "mitcmu".toCharArray();

    private char[] b = "mtacnu".toCharArray();

    /**
     * 前两个for循环分别初始化二维数组 第0行 和 第0列 (初始化条件 最长公共子序列规则初始化:(相同+1,但不能超过某个字符串大小) )
     * 最后，根据DP公式填充表格，填到最后则为最大值
     *
     * @return
     */
    public int LCSS() {

        int column = a.length;

        int row = b.length;

        int[][] maxlcss = new int[row][column];

        for (int i = 0; i < column; i++) {
            if (a[i] == b[0]) {
                maxlcss[0][i] = 1;
            } else if (i != 0) {
                maxlcss[0][i] = maxlcss[0][i - 1];
            } else {
                maxlcss[0][i] = 0;
            }
        }
        for (int i = 0; i < row; i++) {
            if (a[0] == b[i]) {
                maxlcss[i][0] = 1;
            } else if (i != 0) {
                maxlcss[i][0] = maxlcss[i - 1][0];
            } else {
                maxlcss[i][0] = 0;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (b[i] == a[j]) {
                    maxlcss[i][j] = max(maxlcss[i - 1][j - 1] + 1, maxlcss[i - 1][j], maxlcss[i][j - 1]);
                } else {
                    maxlcss[i][j] = max(maxlcss[i - 1][j - 1], maxlcss[i - 1][j], maxlcss[i][j - 1]);
                }
            }
        }
        return maxlcss[row - 1][column - 1];
    }

    /**
     * 比较三个数大小
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int max(int a, int b, int c) {
        int max = Integer.MIN_VALUE;
        if (a > max) {
            max = a;
        }

        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        return max;
    }

    public static void main(String[] args) {
        LCSubsequence lcSubsequence = new LCSubsequence();
        int lcss = lcSubsequence.LCSS();
        System.out.println("最大公共子序列:{}" + lcss);
    }
}
