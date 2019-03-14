package com.alg.backtracking;

/**
 * 0-1 背包问题有很多变体，这里介绍一种比较基础的。
 * <p>
 * 有一个背包，背包总的承载重量是 Wkg。现在我们有 n 个物品，
 * 每个物品的重量不等,并且不可分割。现在期望选择几件物品，装载到背包中。
 * 在不超过背包所能装载重量的前提下，如何让背包中物品的总重量最大？
 * </p>
 * <p>
 * <p>
 * 解题思路：
 * 分为 n 各阶段， 每个阶段均有 装包或不装包  ， 计算下一个阶段后是否超过背包总重量，如果超过则剩下阶段则不需要处理(即 剪枝)
 *
 * @author
 */
public class Backpack {

    /**
     * 物品数量
     */
    private int n = 5;
    /**
     * 背包总重量限额
     */
    private int w = 9;

    /**
     * 每个物品对应重量
     */
    private int[] items = new int[]{1, 2, 3, 4, 5};

    /**
     * 可放入的最大重量
     */
    private int max = Integer.MIN_VALUE;

    private int[] result = new int[5];

    /**
     * @param i  当前处理到物品下标值
     * @param cw 当前背包重量
     */
    public void process(int i, int cw) {
        if (cw == w || i == (n - 1)) {
            if (cw > max) {
                max = cw;
                print();
            }
            return;
        }
        /**
         * 当前背包不放入
         */
        result[i] = 0;
        process(i + 1, cw);


        if (w >= (cw + items[i])) {
            /**
             * 当前背包放入
             */
            result[i] = 1;
            process(i + 1, cw + items[i]);
        }
    }


    public static void main(String[] args) {
        Backpack backpack = new Backpack();

        backpack.process(0, 0);

        System.out.println("可放入最大总重量:{}" + backpack.max);
    }

    private void print() {
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + "\t");
        }
        System.out.println();
    }
}
