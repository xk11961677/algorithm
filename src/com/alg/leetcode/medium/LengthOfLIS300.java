package com.alg.leetcode.medium;

import java.util.Arrays;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * <p>
 * 1.brute force attack 、backtracking  O(2^n)
 * 2.dynamic programming O(n^2)
 * 3.贪心+二分 O(NlogN)
 *
 * @author
 */
@SuppressWarnings("all")
public class LengthOfLIS300 {

    private int maxLength = Integer.MIN_VALUE;

    /**
     * 申请个LIS空间：res 大小为1， 默认装载 第1个元素
     * <p>
     * 开始从第2个元素loop i
     * <p>
     * 如果当前元素比 res 所有元素大,增大空间并添加到最后边
     * 否则：查找第一个比 此值 大的元素 替换
     * 注意： res 不是 最长上升子序列 ,而是 最长上升子序列大小
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {

        int[] res = new int[0];

        for (int i = 0; i < nums.length; i++) {
            int index = binarySearch(res, res.length - 1, nums[i]);
            if (res.length == index) {
                res = Arrays.copyOf(res, index + 1);
                res[index] = nums[i];
            } else {
                res[index] = nums[i];
            }
        }
        maxLength = res.length;
        return maxLength;
    }

    /**
     * 查找第1个比s大的
     *
     * @param res
     * @param right
     * @param s
     * @return
     */
    public int binarySearch(int[] res, int right, int s) {
        int left = 0;
        int mid = 0;
        while (left <= right) {
            //防止 (right+left)时int溢出,所以不使用 (right+left)/2
            mid = left + ((right - left) >> 1);
            if (res[mid] >= s) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * dynamic programming
     * 两步走: [状态设计,状态转移方程式] 3 考虑边界
     * <p>
     * dp[i] 以第i个元素结尾的LIS长度 (考虑：这个元素是最小值，那么 dp[i] =1 )
     * <p>
     * dp[i] = max{dp[j]+1,dp[i]} ( 1<=i<n , 0<=j<i , a[j] < a[i])
     *
     * @param nums
     * @return
     */
    /*public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 1;

        int[] dp = new int[nums.length];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        maxLength = res;
        return maxLength;
    }*/

    /**
     * 调用方法: lengthOfLis(nums, 0, -1, 0);
     * backtracking
     *
     * @param nums
     * @param i
     * @param prev
     * @param max
     */
    /*public void lengthOfLis(int[] nums, int i, int prev, int max) {
        if (i == nums.length) {
            if (max > maxLength) {
                maxLength = max;
            }
            prev = -1;
            return;
        }
        lengthOfLis(nums, i + 1, -1, max);
        if (prev == -1) {
            lengthOfLis(nums, i + 1, i + 1, max + 1);
        } else if (nums[i] > nums[prev]) {
            lengthOfLis(nums, i + 1, i + 1, max + 1);
        }
    }*/
    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 1, 101, 18, 20};
        LengthOfLIS300 lengthOfLIS300 = new LengthOfLIS300();
        int i = lengthOfLIS300.lengthOfLIS(nums);
        System.out.println(i);
    }
}
