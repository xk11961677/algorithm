package com.alg.other;

/**
 * 求公共子串
 *
 * @author
 */
public class PublicString {
    /**
     * 公共子串:位置开始下标  所有子串   最大子串  最小子串
     * i为短的字符串长度,不断减小,分别求两个字符串长度为i的所有子串进行比较
     *
     * @param str1
     * @param str2
     */
    public static void publicStr(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        int len1 = str1.length();
        int len2 = str2.length();
        String min;
        String max;
        String target;
        min = len1 <= len2 ? str1 : str2;
        max = len1 > len2 ? str1 : str2;
        //最外层：min子串的长度，从最大长度开始
        for (int i = min.length(); i >= 1; i--) {
            //遍历长度为i的min子串，从0开始
            for (int j = 0; j <= min.length() - i; j++) {
                target = min.substring(j, j + i);
                //遍历长度为i的max子串，判断是否与target子串相同，从0开始
                for (int k = 0; k <= max.length() - i; k++) {
                    if (max.substring(k, k + i).equals(target)) {
                        System.out.println(target);
                    }
                }
            }
        }
    }


//    public static int compute(char[] str1, char[] str2) {
//        int size1 = str1.length;
//        int size2 = str2.length;
//        if (size1 == 0 || size2 == 0) return 0;
//
//        // the start position of substring in original string
//        int start1 = -1;
//        int start2 = -1;
//        // the longest length of common substring
//        int longest = 0;
//
//        // record how many comparisons the solution did;
//        // it can be used to know which algorithm is better
//        int comparisons = 0;
//
//        for (int i = 0; i < size1; ++i) {
//            int m = i;
//            int n = 0;
//            int length = 0;
//            while (m < size1 && n < size2) {
//                ++comparisons;
//                if (str1[m] != str2[n]) {
//                    length = 0;
//                } else {
//                    ++length;
//                    if (longest < length) {
//                        longest = length;
//                        start1 = m - longest + 1;
//                        start2 = n - longest + 1;
//                    }
//                }
//
//                ++m;
//                ++n;
//            }
//        }
//
//        // shift string2 to find the longest common substring
//        for (int j = 1; j < size2; ++j) {
//            int m = 0;
//            int n = j;
//            int length = 0;
//            while (m < size1 && n < size2) {
//                ++comparisons;
//                if (str1[m] != str2[n]) {
//                    length = 0;
//                } else {
//                    ++length;
//                    if (longest < length) {
//                        longest = length;
//                        start1 = m - longest + 1;
//                        start2 = n - longest + 1;
//                    }
//                }
//
//                ++m;
//                ++n;
//            }
//        }
//        System.out.printf("from %d of str1 and %d of str2, compared for %d times\n", start1, start2, comparisons);
//        return longest;
//    }
//
//    public static int longestCommonSubstring(String str1, String str2) {
//        return compute(str1.toCharArray(), str2.toCharArray());
//    }

    /**
     * substring1:abcd
     * substring2:abaaaaa
     * 2	1	1	1	1	1	1	0
     * 1	1	0	0	0	0	0	0
     * 0	0	0	0	0	0	0	0
     * 0	0	0	0	0	0	0	0
     * 0	0	0	0	0	0	0	0
     * ab
     * 2
     *
     * @param str1
     * @param str2
     * @return
     */
    public static int computeQueue(char[] str1, char[] str2) {
        int substringLength1 = str1.length;
        int substringLength2 = str2.length;

        // 构造二维数组记录子问题A[i]和B[j]的LCS的长度
        int[][] opt = new int[substringLength1 + 1][substringLength2 + 1];

        // 从后向前，动态规划计算所有子问题。也可从前到后。
        for (int i = substringLength1 - 1; i >= 0; i--) {
            for (int j = substringLength2 - 1; j >= 0; j--) {
                if (str1[i] == str2[j]) {
                    opt[i][j] = opt[i + 1][j + 1] + 1;// 状态转移方程
                } else {
                    opt[i][j] = Math.max(opt[i + 1][j], opt[i][j + 1]);// 状态转移方程
                }
            }
        }
        System.out.println("substring1:" + new String(str1));
        System.out.println("substring2:" + new String(str2));


        for (int m = 0; m < opt.length; m++) {
            int[] arr = opt[m];
            for (int n = 0; n < arr.length; n++) {
                System.out.print(opt[m][n] + "\t");
            }
            System.out.println();
        }

        System.out.print("LCS:");

        int i = 0, j = 0;
        while (i < substringLength1 && j < substringLength2) {
            if (str1[i] == str2[j]) {
                System.out.print(str1[i]);
                i++;
                j++;
            } else if (opt[i + 1][j] >= opt[i][j + 1]) {
                i++;
            } else {
                j++;
            }
        }
        System.out.println();
        return opt[0][0];
    }

    public static int computeQueue(String str1, String str2) {
        return computeQueue(str1.toCharArray(), str2.toCharArray());
    }


    public static void main(String[] args) {
        String a = "abcd";
        String b = "abaaaaa";
//        publicStr(a, b);

//        int i = longestCommonSubstring(a, b);
//        System.out.println(i);

        int queue = computeQueue(a, b);
        System.out.println(queue);


    }
}
