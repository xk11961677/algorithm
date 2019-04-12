package com.alg.other;

/**
 * 全排列  permutation
 * <p>
 * 规则:
 * 定位 1 , 求 2 3 全排列
 * 定位 2 , 求 1 3 全排列
 * 定位 3 , 求 2 1 全排列
 * <p>
 * loop 需要定位次数
 *
 * @author
 */
public class Permutation {

    /**
     * @param nums
     * @param first
     * @param end
     */
    public void permutation(int[] nums, int first, int end) {
        if (first == end) {
            for (int j = 0; j < nums.length; j++) {
                System.out.print(nums[j] + "\t");
            }
            System.out.println();
            return;
        }

        for (int i = first; i <= end; i++) {
            swap(nums, i, first);

            permutation(nums, first + 1, end);

            swap(nums, i, first);
        }

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Permutation permutation = new Permutation();
        permutation.permutation(nums, 0, nums.length-1);
    }
}
