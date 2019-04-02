package com.alg.leetcode.medium;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 *
 * @author
 */
public class CoinChange322 {


    public int coinChange(int[] coins, int amount) {
        if(amount == 0) {
            return 0;
        }
        int[] dp = new int[amount+1];
        for(int i=1; i<dp.length; i++) {
            dp[i] = 9999;
            for(int j=0; j<coins.length && i >= coins[j]; j++) {
               dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
            }
        }
        return dp[amount] == 9999 ? -1: dp[amount];
    }


    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        CoinChange322 coinChange322 = new CoinChange322();
        int nums = coinChange322.coinChange(coins,6);
        System.out.println("最少硬币个数:{}"+nums);
    }


    /*
    回溯法
    private int nums = Integer.MAX_VALUE;

    public void coinChange(int[] coins, int amount,int num) {
        if(amount == 0) {
            if(nums > num) {
                nums = num;
                System.out.println("次数:{}"+num);
                return ;
            }
        }

        for(int i=0; i<coins.length; i++) {
            if(amount-coins[i] >= 0) {
               coinChange(coins,amount-coins[i],num+1);
            }
        }
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        CoinChange322 coinChange322 = new CoinChange322();
        coinChange322.coinChange(coins,11,0);
        System.out.println("最少硬币个数:{}"+nums);
    }*/
}
