package com.alg.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * longest common subsequence length
 * <p>
 * 求两个字符串相似度?
 *
 * <p>如何量化两个字符串之间的相似程度呢？有一个非常著名的量化方法，那就是编辑距离（Edit Distance）。</p>
 *
 * <p>
 * 编辑距离: 指的就是，将一个字符串转化成另一个字符串，需要的最少编辑操作次数（比如增加一个字符、删除一个字符、替换一个字符）。
 * 编辑距离越大，说明两个字符串的相似程度越小；相反，编辑距离就越小，说明两个字符串的相似程度越大。对于两个完全相同的字符串来说，编辑距离就是 0。
 * </p>
 *
 * <p>
 * 根据所包含的编辑操作种类的不同，编辑距离有多种不同的计算方式，比较著名的有
 * 莱文斯坦距离（Levenshtein distance）: 莱文斯坦距离允许增加、删除、替换字符这三个编辑操作。
 * 莱文斯坦距离的大小，表示两个字符串差异的大小。
 * <br>
 * 最长公共子序列长度（Longest common subsequence length）: 最长公共子序列长度只允许增加、删除字符这两个编辑操作。
 * 表示两个字符串相似程度的大小。
 * </p>
 * <p>
 * 解题思路：
 *
 * @author
 */
@SuppressWarnings("all")
public class LCSubsequence {

    private char[] a = "mitcmu".toCharArray();

    private char[] b = "mtacnu".toCharArray();

    private int max = 0;

    /**
     * 最长子序列
     */
    private List<Integer> result = new ArrayList();


    public void LCSS(int i, int j, int maxLength) {
        if (i == a.length || j == b.length) {
            if (maxLength > max) {
                max = maxLength;
                Collections.sort(result);
                System.out.println(max + "\t a:  " + result);
            }
            return;
        }
        if (a[i] == b[j]) {
            if (!result.contains(i)) {
                result.add(i);
            }
            LCSS(i + 1, j + 1, maxLength + 1);
        } else {
            LCSS(i + 1, j, maxLength);
            LCSS(i, j + 1, maxLength);
        }
    }


    public static void main(String[] args) {
        LCSubsequence lcSubsequence = new LCSubsequence();
        lcSubsequence.LCSS(0, 0, 0);
    }

}
