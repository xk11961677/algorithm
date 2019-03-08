package com.alg.other;

/**
 * Created by sky on 16/3/13.
 * 快速排序算法
 */
public class QuikSort {


    /**
     * 冒泡算法先排个序
     * 两值互换3种方式
     * @param target
     */
    public static void bubbleSort(int [] target) {
        for(int i=0; i<target.length ;i++) {
            for (int j=i;j<target.length ;j++) {
                if(target[i]>target[j]) {
//                    int temp = target[i];
//                    target[i] = target[j];
//                    target[j] = temp;

//                    target[i] = target[i]^target[j];
//                    target[j] = target[i]^target[j];
//                    target[i] = target[i]^target[j];

                    target[i] = target[i]+target[j];
                    target[j] = target[i]-target[j];
                    target[i] = target[i]-target[j];
                }
            }
        }
        for (int s:target ) {
            System.out.print(s+"\t");
        }
    }

    /**
     * 快速排序算法
     * @param a
     * @param start
     * @param end
     */
    public static void quickSort(int a[], int start, int end) {
        int i, j;
        i = start;
        j = end;
        if ((a == null) || (a.length == 0))
            return;

        while (i < j) {//查找基准点下标
            while (i < j && a[i] <= a[j])
                // 以数组start下标的数据为key，右侧扫描
                j--;
            if (i < j) { // 右侧扫描，找出第一个比key小的，交换位置
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
            while (i < j && a[i] < a[j])
                // 左侧扫描（此时a[j]中存储着key值）
                i++;
            if (i < j) { // 找出第一个比key大的，交换位置
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        if (i - start > 1) { // 递归调用，把key前面的完成排序
            quickSort(a, 0, i - 1);
        }
        if (end - j > 1) {
            quickSort(a, j + 1, end); // 递归调用，把key后面的完成排序
        }
    }

    public static int reverse(int x) {
        if((x >0 && x <10) || (x<0 && x > -10)) {
            return x;
        }
        int revetedNumber = 0;
        while(x/10 > 0) {
            revetedNumber = revetedNumber*10 + x%10;
            x /= 10;
        }
        return revetedNumber;
    }

    public static void main(String[] args) {
//        int[] target = new int[]{1,2,3,0,10,4,5,7,8,6,9};
//        bubbleSort(target);
//        quickSort(target,0,target.length-1);
//        for (int t : target) {
//            System.out.print(t+"\t");
//        }
        System.out.println(reverse(123));
    }

}
