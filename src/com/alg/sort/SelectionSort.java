package com.alg.sort;

/**
 * <p>
 * 选择排序算法的实现思路有点类似插入排序，也分已排序区间和未排序区间。
 * 但是选择排序每次会从未排序区间中找到最小的元素，将其放到已排序区间的末尾。
 * <p>
 * 和冒泡区别：  冒泡只比对相邻两个元素，而选择排序每次比对 未排序区间所有，记录最小的下标互换
 *
 * </p>
 *
 * <p>
 * 时间复杂度：O(n^2) 空间复杂度 O(1)
 * </p>
 *
 * @author
 */
public class SelectionSort {


    public void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            if (min > i) {
                int temp = nums[min];
                nums[min] = nums[i];
                nums[i] = temp;
            }

        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 0, 10, 4, 5, 7, 8, 6, 9};

        new SelectionSort().selectionSort(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "\t");
        }
    }
}
