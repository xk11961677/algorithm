package com.alg.leetcode.easy;

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
public class ReverseList206 {

    public class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    /**
     * 递归法---(从最后一个开始反转, 每层递归根据head[入参] , 返回值headNode开始反转 [最后节点时，不会走: 步骤1(即从4那个节点开始反转代码)] )
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode headNode = reverseList(head.next);
        //步骤1
        head.next.next = head;
        head.next = null;
        return headNode;
    }


    /**
     * 遍历法 申请 prev 指针 与 当前指针 cur
     * @param head
     * @return
     */
    public ListNode iterator(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;

        }
        return prev;
    }


    public static void main(String[] args) {
        ReverseList206 clazz = new ReverseList206();
        ListNode listNode = clazz.headCreate(null, 1);
        clazz.printList(listNode);

        ListNode reverseAfterList = clazz.reverseList(listNode);
        clazz.printList(reverseAfterList);

        ListNode sourceLlistNode = clazz.iterator(reverseAfterList);
        clazz.printList(sourceLlistNode);

        ListNode listNodeByTailCreate = clazz.tailCreate(null, null, 1);
        clazz.printList(listNodeByTailCreate);

    }

    /**
     * 创建单链表---头插法(创建的元素总是头部，并将上一个元素添加为next指针)
     * @param val
     * @return
     */
    public ListNode headCreate(ListNode dummy, int val) {
        if(val > 5) {
            return dummy;
        }
        ListNode listNode = new ListNode(val++);
        listNode.next = dummy;
        dummy = listNode;
        dummy = headCreate(dummy,val);
        return dummy;
    }

    /**
     * 创建链表---尾插法(创建头部元素,并每次记录最后一个节点指针[需要下移指针tail])
     * @param dummy
     * @param tail
     * @param val
     * @return
     */
    public ListNode tailCreate(ListNode dummy, ListNode tail, int val) {
        if(val > 5) {
            return dummy;
        }
        ListNode listNode = new ListNode(val++);
        if(dummy == null) {
            dummy = listNode;
            tail = listNode;
        }else {
            tail.next = listNode;
            tail  = listNode;
        }
        tail = tailCreate(dummy,tail,val);
        return tail;
    }

    /**
     * 打印链表
     * @param node
     */
    public void printList(ListNode node) {
        if(node == null) {
            throw new IllegalArgumentException();
        }
        while(node != null) {
            System.out.print(node.val+"\t");
            node = node.next;
        }
        System.out.println();
    }


}
