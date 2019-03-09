package com.alg.sort;

/**
 * 冒泡排序只会操作相邻的两个数据。
 * 每次冒泡操作都会对相邻的两个元素进行比较，看是否满足大小关系要求,如果不满足就让它俩互换。
 * 一次冒泡会让至少一个元素移动到它应该在的位置，重复 n 次，就完成了 n 个数据的排序工作。
 *
 * <p>
 * 时间复杂度：O(n^2) 空间复杂度 O(1)
 * </p>
 *
 * <p>
 * 有序元素对：a[i] <= a[j], 如果 i < j。
 * 有序度公式: [ n*(n-1)/2 ]
 * 满有序度:  [1,2,3,4,5,6]  满有序度 = 15
 * 逆序元素对: a[i] > a[j] ,如果 i<j
 * 逆序度公式: 逆序度 = 满有序度 - 有序度
 * </p>
 *
 * <p>
 * 冒泡排序交换次数为  逆序度 值
 *
 * @author
 */
public class BubbleSort {

    /**
     * @param nums
     */
    public void bubbleSort(int[] nums) {
        int m = 0;
        for (int i = 0; i < nums.length; i++) {
            boolean flag = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = true;
                    m++;
                }
            }
            if (!flag) {
                System.out.println("逆序度: " + m);
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 0, 10, 4, 5, 7, 8, 6, 9};

        new BubbleSort().bubbleSort(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "\t");
        }
    }
}
