package com.alg.other;

/**
 * 计算硬币组合
 */
public class Coin {

    /**
     * 计算1元 2元 5元 有多少组合值为 100元
     */
    private static void calculate(int value) {
        int i , j, k ;
        int n = 0;

        for (i=0 ; i <(value/5) ;i++) {
            for (j =0 ; j<=(value-5*i)/2  ; j++) {
                for (k = 0 ; k <= (value-5*i-2*j) ; k++) {
                    if (value == (k + 5*i + 2*j)) {
                        n++;
                       // System.out.println("i "+i +"\t j = "+j+"\t k="+k);
                    }
                }
            }
        }
        System.out.println(n);
    }


    /////
    // 设1分个数为x，2分个数为y，5分的硬币个数为z，则1*x+2*y+5*z=10；
    // x + 2y + 5z = 10; -> 5z = 10 - x - 2y;    即：
    // z        x对应可能的取值
    // 0        10 8 6 4 2 0（6个）
    // 1        5 3 1（3个）
    // 2        0（1个）
    // 总共个数为6+3+1=10.
    // 因此，按照规律，本题目组合总数为10以内的偶数+5以内的奇数+0以内的偶数
    // 某个偶数m以内的偶数个数（包括0）可以表示为m/2+1=(m+2)/2
    // 某个奇数m以内的奇数个数也可以表示为(m+2)/2
    //
    // 简单来说 z 进行0, 1, 2, ... , targetNumber/2循环进行(m+2)/2累计
    //
    // 简单来说 x 进行 0, 5, 10, ... , 5*i, ..., targetNumber循环进行 (m+2)/2累计
    ////
    // @param targetNumber
    // @return
    ///
    public static int caculateWay2(int targetNumber) {
        int count = 0;
        long currentTime1 = System.currentTimeMillis();
//        for (int x = 0; x <= targetNumber; x += 5) {
//            count += (x + 2)/2;
//        }
        for (int z = 0; z <= targetNumber/5; z++) {
            count += ((targetNumber - 5*z) + 2)/2;
        }
        long currentTime2 = System.currentTimeMillis();
        System.out.println("Time taked: " + (currentTime2 - currentTime1));
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        calculate(100);
        caculateWay2(100);
    }
}
