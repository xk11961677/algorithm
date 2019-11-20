package com.alg.other;

/**
 * @author
 */
public class Group {
    /**
     * 算法描述：
     * <p>
     * 算法说明：当n大于2时，n个数的全组合一共有(2^n)-1种。
     * 当对n个元素进行全组合的时候，可以用一个n位的二进制数表示取法。
     * 1表示在该位取，0表示不取。例如，对ABC三个元素进行全组合，  100表示取A，010表示取B，001表示取C，101表示取AC  110表示取AB，011表示取BC，111表示取ABC
     * 注意到表示取法的二进制数其实就是从1到7的十进制数
     * 推广到对n个元素进行全排列，取法就是从1到2^n-1的所有二进制形式
     * 要取得2^n，只需将0xFFFFFFFF左移32-n位，再右移回来就可以了。
     *
     * @param args
     */
    public static void main(String[] args) {
        String str[] = {"A", "B", "C", "D", "E"};
        int nCnt = str.length;
//              int nBit = (0xFFFFFFFF >>> (32 - nCnt));
        int nBit = 1 << nCnt;
        for (int i = 1; i <= nBit; i++) {
            for (int j = 0; j < nCnt; j++) {
                if ((1 << j & i) != 0) {
                    System.out.print(str[j]);
                }
            }
            System.out.println("");
        }
    }
}
