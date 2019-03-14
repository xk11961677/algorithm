package com.alg.backtracking;

/**
 * n皇后问题
 * <p>
 * n*n 矩阵
 * <p>
 * 放置皇后分为 N个阶段， 每个阶段 N种放法， 每次尝试放置，判断是否满足皇后，满足则换下一阶段
 * <p>
 * 回溯思想 : 类似穷举，所有阶段放置完毕，重新回到原点，换另一种放法 （电影--蝴蝶效应）
 *
 * @author
 */
public class Queens {

    /**
     * 第N种放法
     */
    private int num = 0;

    /**
     * 皇后个数
     */
    private final int n = 8;

    /**
     * 每种皇后放置位置
     */
    public int[] queens = new int[n];

    public Queens() {
    }

    /**
     * 放置皇后放法
     *
     * @param row
     */
    public void putQueens(int row) {
        if (row == n) {
            print();
            return;
        }
        for (int column = 0; column < n; column++) {
            if (isOk(row, column)) {
                queens[row] = column;
                putQueens(row + 1);
            }
        }
    }

    /**
     * 判断列、左对角线、右对角线 是否有满足放置皇后条件
     *
     *
     * 判断是否在一条斜线上还有更加简便的做法，就是如果行互减的绝对值等于列互减的绝对值，那么就是在一条斜线上的。
     * if (Math.abs(row - i) == Math.abs(column - queens[i])) {
     *    return false;
     * }
     *
     * @param row
     * @param column
     * @return
     */
    public boolean isOk(int row, int column) {
        int leftup = column - 1;

        int rightup = column + 1;

        for (int i = row - 1; i >= 0; i--) {
            if (queens[i] == column) {
                return false;
            }

            if (leftup >= 0 && queens[i] == leftup) {
                return false;
            }

            if (rightup < n && queens[i] == rightup) {
                return false;
            }
            leftup--;
            rightup++;
        }
        return true;
    }

    /**
     * 打印
     */
    public void print() {
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                if (queens[row] == column) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println(++num);
    }

    public static void main(String[] args) {
        Queens queens = new Queens();

        queens.putQueens(0);
    }
}
