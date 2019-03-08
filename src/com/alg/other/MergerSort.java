package com.alg.other;

/**
 * 归并排序，时间复杂度 O(nlgN) , 空间复杂度 O(n)
 * 分治思想，递归实现   divide and conquer ,  recursion implement
 * @author
 *
 * TODO 需要学习其他人写的，然后优化代码
 */
public class MergerSort {


    public int[] MergerSort(int[] nums, int l, int r) {
        if (l == r) {
            return nums;
        }
        int m = (l + r) / 2;

        MergerSort(nums, l, m);

        MergerSort(nums, m + 1, r);

        return merge(nums, l, m, r);
    }

    /**
     *
     * 使用指针将 指针内的数组排序，并存储temp临时数组， 最后赋值给nums,但需要保留左指针，因为每次赋值开头都应该是左指针
     * 两个分支数组（每次已经有顺序）比较大小 ,右边的也需要从左往右，所以根据m计算出右数组头指针
     * @return
     */
    public int[] merge(int[] nums, int l, int m, int r) {
        int[] temp = new int[r - l + 1];
        /**
         * brute force attack
         */
        int tempL = l;

        int i = 0;

        int rl = m + 1;

        while (l <= m && rl <= r) {
            if (nums[rl] < nums[l]) {
                temp[i] = nums[rl++];
            } else {
                temp[i] = nums[l++];
            }
            i++;
        }

//        //判断哪个指针到底，则将另一个数组全部移动到temp
//        if (l > m) {
//            while (rl <= r) {
//                temp[i++] = nums[rl++];
//            }
//        }
//        if (rl > r) {
//            while (l <= m) {
//                temp[i++] = nums[l++];
//            }
//        }

        //判断哪个指针到底，则将另一个数组全部移动到temp
        while (rl <= r) {
            temp[i++] = nums[rl++];
        }
        while (l <= m) {
            temp[i++] = nums[l++];
        }

        for (int x = 0; x < temp.length; x++) {
            nums[x + tempL] = temp[x];
        }
        return nums;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 5, 3, 8, 9, 2, 6, 7, 0, 11, 10};
        MergerSort mergerSort = new MergerSort();
        int[] ret = mergerSort.MergerSort(nums, 0, nums.length - 1);
        print(ret);

    }

    /**
     * 打印
     * @param ret
     */
    public static void print(int[] ret) {
        for (int i = 0; i < ret.length; i++) {
            System.out.print(ret[i] + "\t");
        }
    }
}
