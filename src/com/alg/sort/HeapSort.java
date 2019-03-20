package com.alg.sort;

/**
 * 堆：1. 完全二叉树 2. 每个节点均大于或等于(小于或等于)子树的子节点
 * 堆排序: 建堆 + 排序
 * 堆化方式:
 * <p>从下往上: 从叶子节点开始</p>
 *
 * <p>从上往下: 从最后一个父节点开始 = 节点数/2</p
 *
 * @author
 */
public class HeapSort {

    /**
     * 注意：数组第一位空间没有使用,即0没有算堆中数据 ( root:i , left:2*i , right:2*i+1 )
     *
     * @param nums 数据
     * @param n    数据大小
     */
    public void buildHead(int[] nums, int n) {
        upToDownHeapify(nums, n);
        //sort();
    }


    /**
     * 自上向下堆化
     *
     * @param nums 数组数据
     * @param n    数据大小
     */
    public void upToDownHeapify(int[] nums, int n) {
        int i = n / 2;
        while (i >= 1) {
            heapify(nums, i, n);
            i--;
        }
    }

    /**
     * 从上自下比对，条件成立则swap (此条件是构建大顶堆)
     *
     * @param nums
     * @param i
     * @param n
     */
    @SuppressWarnings("all")
    public void heapify(int[] nums, int i, int n) {
        int target = i;

        int left = 2 * i;

        int right = 2 * i + 1;

        if (right <= n && nums[i] <= nums[right]) {
            //swap
            target = right;
        }
        if (left <= n && nums[target] <= nums[left]) {
            //swap
            target = left;
        }
        if (target > i) {
            //swap exec
            int temp = nums[i];
            nums[i] = nums[target];
            nums[target] = temp;

            heapify(nums, target, n);
        }
    }


    public static void main(String[] args) {
        int[] nums = {0, 7, 5, 19, 8, 4, 1, 20, 13, 16};
        HeapSort heapSort = new HeapSort();
        heapSort.buildHead(nums, nums.length - 1);
        heapSort.print(nums);
    }


    public void print(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            System.out.print(nums[i] + "\t");
        }
    }

}
