package com.alg.leetcode.easy;

/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * @author
 */
public class MajorityElement169 {

    /**
     * 用到的算法是：摩尔投票算法
     * 算法在局部变量中定义一个序列元素(maj)和一个计数器(count)，
     * <p>
     * 初始化的情况下计数器为0.
     * 算法依次扫描序列中的元素，
     * 当处理元素x的时候，
     * 如果计数器为0，那么将x赋值给value，然后将计数器count设置为1，
     * 如果计数器不为0，那么将序列元素value和x比较，如果相等，那么计数器加1，
     * 如果不等，那么计数器减1。
     * 最后存储的序列元素(maj)，就是这个序列中最多的元素。
     *
     * 其他算法:
     *  1.遍历将每一个出现次数存入map中,最后获取出现次数最多的则为结果
     *  2.排序 数组长度/2 则为结果
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int maj = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                count++;
                maj = nums[i];
            } else if (maj == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return maj;
    }


    public static void main(String[] args) {
        MajorityElement169 majorityElement = new MajorityElement169();
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        int i = majorityElement.majorityElement(nums);
        System.out.println(i);
    }

}
