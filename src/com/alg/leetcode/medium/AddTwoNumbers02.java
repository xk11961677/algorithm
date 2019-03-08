package com.alg.leetcode.medium;

import com.alg.leetcode.struct.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 *
 * @author
 */
public class AddTwoNumbers02 {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //使用哨兵方式
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int prev = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = prev + x + y;
            ListNode node = new ListNode(sum % 10);
            curr.next = node;
            curr = node;
            prev = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (prev == 1) {
            curr.next = new ListNode(1);
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode listNode2 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode4;
        listNode4.next = listNode3;

        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode4_1 = new ListNode(4);
        listNode5.next = listNode6;
        listNode6.next = listNode4_1;

        /************************************************/


        ListNode listNode = new AddTwoNumbers02().addTwoNumbers(listNode2, listNode5);

        listNode.print();
    }

}
