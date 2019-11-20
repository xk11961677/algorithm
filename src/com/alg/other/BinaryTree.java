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
    static class Node {
        Node left;
        Node right;
        Node parent;
        int value;

        public Node(int value) {
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
    public static void printNode(Node n) {
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
    public static void depthOrder(Node n) {
        ArrayDeque<Node> stack = new ArrayDeque<Node>();
        stack.push(n);
        while (stack.isEmpty() == false) {
            Node no = stack.pop();
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
    public static void levelOrder(Node n) {
        ArrayDeque<Node> queue = new ArrayDeque<Node>();
        queue.add(n);
        while (queue.isEmpty() == false) {
            Node no = queue.remove();
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
        Node n = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
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
