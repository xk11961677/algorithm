package com.alg.leetcode.medium;

import com.sun.xml.internal.ws.encoding.MtomCodec;

/**
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * @author
 */
public class MaxProduct152 {

    /**
     * 状态定义: dp[i][0]  到第i个值时正最大值  dp[i][1] 到第i个值时负最小值 [包含 i]
     * 状态方程:
     *         dp[i][0] = a[i]>=0 ? dp[i-1][0] * a[i] : dp[i-1][1] * a[i];
     *         dp[i][1] = a[i]>=0 ? dp[i-1][1] * a[i] : dp[i-1][0] * a[i];
     *
     * 结果为: max{ dp[i][0] }
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];

        dp[0][1] = nums[0];

        int ret = dp[0][0];
        for(int i=1; i<nums.length; i++) {
            if(nums[i] >= 0) {
                dp[i][0] = Math.max(dp[i-1][0] * nums[i],nums[i]);
                dp[i][1] = Math.min(dp[i-1][1] * nums[i],nums[i]);
            }else {
                dp[i][0] = Math.max(dp[i-1][1] * nums[i],nums[i]);
                dp[i][1] = Math.min(dp[i-1][0] * nums[i],nums[i]);
            }
            ret = Math.max(ret,dp[i][0]);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,-5,-2,-4,3};

        MaxProduct152 maxProduct152 = new MaxProduct152();

        int maxProduct = maxProduct152.maxProduct(nums);

        System.out.println("最大乘机子序列:{}"+maxProduct);
    }
}
