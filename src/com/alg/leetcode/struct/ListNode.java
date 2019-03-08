package com.alg.leetcode.struct;

/**
 * 单链表结构实体
 *
 * @author
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public void print() {
        ListNode node = this;
        while (node != null) {
            System.out.print(node.val + "\t");
            node = node.next;
        }
        System.out.println();
    }
}
