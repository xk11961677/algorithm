package com.alg.other;

/**
 * Created by sky on 16/3/13.
 * 斐波那契数列
 */
public class Fibonacci {
    /**
     * 1	1	2	3	5	8	13	21	34	55	89
     * @param i
     * @return
     */
    public static int fibo(int i) {
        if(i==1 || i==2) {
            return 1;
        }
        return fibo(i-1)+fibo(i-2);
    }

    public static void main(String[] args) {
        for(int j=1; j<=11 ;j++) {
            System.out.print( fibo(j) +"\t");
        }

    }
}
