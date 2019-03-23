package com.alg.other;

import java.util.Stack;

/**
 * 最小栈 (使用每次存储两个元素方式实现,每次入栈时比较下栈顶元素与入栈元素值，先将入栈元素存入，在存入最小值)
 * 出站需要pop两次， 第二次的才是顺序入栈的元素，top栈顶也是需要取第二个元素
 * 第一个元素则为最小值
 * 空间O(n)
 *
 * @author
 */
public class MinStack {

    private Stack<Integer> stack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            stack.push(x);
        } else {
            int temp = stack.peek();
            stack.push(x);
            if (temp < x) {
                stack.push(temp);
            } else {
                stack.push(x);
            }
        }
    }

    public void pop() {
        stack.pop();
        stack.pop();
    }

    public int top() {
        return stack.get(stack.size() - 2);
    }

    public int getMin() {
        return stack.peek();
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(10);
    }
}
