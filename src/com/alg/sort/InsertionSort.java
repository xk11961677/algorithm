package com.alg.sort;

/**
 * <p>
 * 首先，将数组中的数据分为两个区间，已排序区间 和 未排序区间。
 * 初始已排序区间只有一个元素，就是数组的第一个元素。
 * 插入算法的核心思想是: 取未排序区间中的元素，在已排序区间中找到合适的插入位置将其插入，并保证已排序区间数据一直有序。
 * 重复这个过程，直到未排序区间中元素为空，算法结束。
 * </p>
 *
 * <p>
 * 时间复杂度：O(n^2) 空间复杂度 O(1)
 * </p>
 *
 * <p>
 * 插入排序移动次数为  逆序度 值
 *
 * @author
 */
public class InsertionSort {

    public void insertionSort(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            int value = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (nums[j] > value) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = value;
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 0, 10, 4, 5, 7, 8, 6, 9};

        new InsertionSort().insertionSort(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "\t");
        }
    }
}
