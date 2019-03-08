package com.alg.other;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by sky on 16/3/14.
 * 普通树
 */
public class Tree {

    static class node{
        int value;
        ArrayList<node> children = new ArrayList<node>();
    }



    /**
     * 广度遍历,使用 队列
     * @param n
     */
    public static void  levelOrder(node n) {
        ArrayDeque<node>  queue = new ArrayDeque<node>();
        queue.add(n);
        while(queue.isEmpty()==false) {
            node no = queue.remove();
            System.out.print(no.value+"\t");
            if(no.children.size()>0) {
                ArrayList<node> children = no.children;
                for (int i=0;i<children.size();i++){
                    queue.add(children.get(i));
                }
            }
        }
        System.out.println("\n");
    }

    /**
     * 深度遍历,使用 栈
     * @param n
     */
    public static void  deathOrder(node n) {
        ArrayDeque<node>  stack = new ArrayDeque<node>();
        stack.push(n);
        while(stack.isEmpty()==false) {
            node no = stack.pop();
            System.out.print(no.value+"\t");
            if(no.children.size()>0) {
                ArrayList<node> children = no.children;
                for (int i=children.size()-1; i>=0 ;i--){
                    stack.push(children.get(i));
                }
            }
        }
        System.out.println("\n");
    }



    public static void main(String[] args) {
        node root = new node();
        root.value = 0;
        node n1 = new node();
        n1.value = 1;
        node n2 = new node();
        n2.value = 2;
        node n3 = new node();
        n3.value = 3;
        node n4 = new node();
        n4.value = 4;
        node n5 = new node();
        n5.value = 5;
        node n6 = new node();
        n6.value = 6;
        node n7 = new node();
        n7.value = 7;
        node n8 = new node();
        n8.value = 8;
        node n9 = new node();
        n9.value = 9;
        node n10 = new node();
        n10.value = 10;
        root.children.add(n1);
        root.children.add(n2);
        root.children.add(n3);
        n1.children.add(n4);
        n1.children.add(n5);
        n2.children.add(n6);
        n3.children.add(n7);
        n4.children.add(n8);
        n5.children.add(n9);
        n9.children.add(n10);

        levelOrder(root);

        deathOrder(root);
    }







}
