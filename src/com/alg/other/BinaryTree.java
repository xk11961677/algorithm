package com.alg.other;


import java.util.ArrayDeque;

/**
 * 二叉树, 前序遍历 中序遍历 后续遍历 广度遍历 深度遍历
 *
 * @author
 */
public class BinaryTree {

    /**
     * 节点类
     */
    static class node {
        node left;
        node right;
        node parent;
        int value;

        public node(int value) {
            this.value = value;
        }
    }

    /**
     * 中序遍历 左中右
     * 前序遍历 中左右
     * 后序遍历 左右中
     *
     * @param n
     */
    public static void printNode(node n) {
        if (n.left != null) {
            printNode(n.left);
        }
        if (n.right != null) {
            printNode(n.right);
        }
        System.out.print(n.value + "\t");
    }


    /**
     * 深度遍历,使用  栈
     *
     * @param n
     */
    public static void depthOrder(node n) {
        ArrayDeque<node> stack = new ArrayDeque<node>();
        stack.push(n);
        while (stack.isEmpty() == false) {
            node no = stack.pop();
            System.out.print(no.value + "\t");
            if (no.right != null) {
                stack.push(no.right);
            }
            if (no.left != null) {
                stack.push(no.left);
            }
        }
        System.out.println("\n");
    }


    /**
     * 广度遍历,使用  队列
     *
     * @param n
     */
    public static void levelOrder(node n) {
        ArrayDeque<node> queue = new ArrayDeque<node>();
        queue.add(n);
        while (queue.isEmpty() == false) {
            node no = queue.remove();
            System.out.print(no.value + "\t");
            if (no.left != null) {
                queue.add(no.left);
            }
            if (no.right != null) {
                queue.add(no.right);
            }
        }
        System.out.println("\n");
    }


    public static void main(String[] args) {
        node n = new node(0);
        node n1 = new node(1);
        node n2 = new node(2);
        node n3 = new node(3);
        node n4 = new node(4);
        node n5 = new node(5);
        node n6 = new node(6);
        node n7 = new node(7);
        node n8 = new node(8);
        node n9 = new node(9);
        n.parent = null;
        n.left = n1;
        n.right = n2;

        n1.parent = n;
        n1.left = n3;
        n1.right = n4;

        n2.parent = n;
        n2.left = n5;
        n2.right = n6;

        n3.parent = n1;
        n3.left = n7;
        n3.right = n8;

        n4.parent = n1;
        n4.left = n9;

        //printNode(n);
        depthOrder(n);
        levelOrder(n);

    }
}
