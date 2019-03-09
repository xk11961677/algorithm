package com.alg.sort;

/**
 * 快排的思想是这样的：如果要排序数组中下标从 p 到 r 之间的一组数据，选择 p 到 r 之间的任意一个数据作为 pivot（分区点）。
 * <p>
 * 遍历 p 到 r 之间的数据，将小于 pivot 的放到左边，将大于 pivot 的放到右边，将 pivot 放到中间。
 * 经过这一步骤之后，数组 p 到 r 之间的数据就被分成了三个部分，前面 p 到 q-1 之间都是小于 pivot 的，
 * 中间是 pivot，后面的 q+1 到 r 之间是大于 pivot 的。
 *
 *
 * </p>
 *
 * <p>
 * 根据分治、递归的处理思想，可以用递归排序下标从 p 到 q-1 之间的数据和下标从 q+1 到 r 之间的数据，
 * 直到区间缩小为 1，就说明所有的数据都有序了。
 * </p>
 *
 * <p>
 * 递推公式：
 * quick_sort(p…r) = quick_sort(p…q-1) + quick_sort(q+1, r)
 * <p>
 * 终止条件：
 * p >= r
 *
 * @author
 */
public class QuickSort {


    public void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public void quickSort(int[] nums, int p, int r) {
        /**
         * 注意边界条件
         */
        if (p >= r) {
            return;
        }

        int q = partition(nums, p, r);

        /**
         * 注意 基准值下标 q 已经排好序
         */
        quickSort(nums, p, q-1);

        quickSort(nums, q + 1, r);

    }

    /**
     * <p>
     * 这里的处理有点类似选择排序。我们通过游标 i 把 A[p…r-1] 分成两部分。
     * A[p…i-1] 的元素都是小于 pivot 的，我们暂且叫它“已处理区间”，A[i…r-1] 是“未处理区间”。
     * 每次都从未处理的区间 A[i…r-1] 中取一个元素 A[j]，与 pivot 对比，如果小于 pivot，
     * 则将其加入到已处理区间的尾部，也就是 A[i] 的位置。
     * </p>
     * <p>
     * partition(A, p, r) {
     *   pivot := A[r]
     *   i := p
     *   for j := p to r-1 do {
     *     if A[j] < pivot {
     *       swap A[i] with A[j]
     *       i := i+1
     *     }
     *   }
     *   swap A[i] with A[r]
     *   return i
     * }
     */
    public int partition(int[] nums, int p, int r) {
        int pivot = nums[r];
        int i = p;
        for(int j=p; j < r; j++) {
            if(nums[j] < pivot) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
        }
        int temp = nums[r];
        nums[r] = nums[i];
        nums[i] = temp;
        return i;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 5, 3, 8, 9, 2, 6, 7, 0, 11, 10};

        QuickSort quickSort = new QuickSort();

        quickSort.quickSort(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "\t");
        }
    }


    /**
     * 另一种分区方式
     * private static void quickSort(int[] a, int head, int tail) {
     *
     *     int low = head;
     *     int high = tail;
     *     int pivot = a[low];
     *     if (low < high) {
     *
     *         while (low<high) {
     *             while (low < high && pivot <= a[high]) high--;
     *             a[low] = a[high];
     *             while (low < high && pivot >= a[low]) low++;
     *             a[high]=a[low];
     *         }
     *         a[low] = pivot;
     *
     *         if(low>head+1) quickSort(a,head,low-1);
     *         if(high<tail-1) quickSort(a,high+1,tail);
     *     }
     *
     * }
     */
}
