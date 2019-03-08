package com.alg.leetcode.medium;

import java.util.*;


/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author
 */
public class ThreeSum15 {

    /**
     * brute force attack
     * 第一种:
     * 1: 排序   int[] nums = new int[]{-1, 0, 1, 2, -1, -4};  -4 -1 -1 0 1 2
     * 2: c = -(a+b)  且 c 的指针在m指针后边即成立
     * 3: 使用set存储list 去重
     * <p>
     * 第二种
     * 1: 排序
     * 2: 三层for循环，使用set去重
     *
     * @param nums
     * @return
     */
    /*public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int n = 0; n < nums.length; n++) {
            map.put(nums[n], n);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int m = (i + 1); m < nums.length; m++) {
                int c = -(nums[i] + nums[m]);
                if (map.containsKey(c) && map.get(c) > m) {
                    set.add(Arrays.asList(nums[i], nums[m], c));
                }
            }
        }
        return new ArrayList<>(set);
    }*/

    /**
     * 指针法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            /**
             * 三个正数相加不可能等于0
             */
            if (nums[i] > 0) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int m = i + 1;
            int n = nums.length - 1;
            int target = 0 - nums[i];
            while (m < n) {
                if (target == nums[m] + nums[n]) {
                    lists.add(Arrays.asList(nums[i], nums[m], nums[n]));
                    while (m < n && nums[n] == nums[n - 1]) {
                        n--;
                    }
                    while (m < n && nums[m] == nums[m + 1]) {
                        m++;
                    }
                    m++;
                    n--;
                } else if (target > nums[m] + nums[n]) {
                    m++;
                } else {
                    n--;
                }
            }
        }
        return lists;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = new ThreeSum15().threeSum(nums);
        print(lists);

    }

    public static void print(List<List<Integer>> lists) {
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);
            for (int m = 0; m < list.size(); m++) {
                System.out.print(list.get(m) + "\t");
            }
            System.out.println();
        }
    }
}
