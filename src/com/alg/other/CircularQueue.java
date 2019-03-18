package com.alg.other;

/**
 * 循环队列
 * (需要留出一个空间，来判断队列的队满和队空，所以需要浪费一个存储空间)
 * capacity =10 实际上装载9个数据， 因为tail指针指向的最后一个空内存地址,而不是最后一个数据的内存地址
 *
 * @author
 */
public class CircularQueue {

    private String[] items;

    private int head;

    private int tail;

    private int capacity;


    public CircularQueue(int capacity) {
        this.capacity = capacity;
        items = new String[capacity];
    }


    public boolean enqueue(String item) {
        if ((tail + 1) % capacity == head) {
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % capacity;
        return true;
    }


    public String dequeue() {
        if (head == tail) {
            return null;
        }
        String item = items[head];
        head = (head + 1) % capacity;
        return item;
    }

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(10);
        for (int i = 0; i < 10; i++) {
            circularQueue.enqueue(i + "");
        }
    }

}
