package com.alg.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * @author
 */
public class MinimumTotal120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.get(triangle.size() - 1).size();
        int[][] triangleMatrix = new int[size][size];
        for(int i=0; i<size; i++) {
            for (int j=0; j<triangle.get(i).size(); j++) {
                triangleMatrix[i][j] = triangle.get(i).get(j);
            }
        }

        int[][] dpMatrix = new int[size][size];
        for(int m=0; m<size; m++) {
            dpMatrix[size-1][m] = triangle.get(size-1).get(m);
        }

        for(int i=size-2; i>=0; i--) {
            for(int j=triangle.get(i).size()-1; j>=0; j--) {
                dpMatrix[i][j] = Math.min(dpMatrix[i+1][j],dpMatrix[i+1][j+1]) + triangleMatrix[i][j];
            }
        }
        return dpMatrix[0][0];
    }

    public static void main(String[] args) {
        MinimumTotal120 minimumTotal120 = new MinimumTotal120();
        List<List<Integer>> lists = minimumTotal120.buildData();
        int i = minimumTotal120.minimumTotal(lists);
        System.out.println("最小路径和:{}"+i);
    }


    public List<List<Integer>> buildData() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        List<List<Integer>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        return list;
    }
}
