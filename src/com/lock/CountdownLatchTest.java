package com.lock;

import java.util.concurrent.CountDownLatch;

public class CountdownLatchTest {

    /**
     * Node.PROPAGATE 主要用于传播作用: 释放锁时会设置为 0 ,
     * 但还没执行到释放方法, 设置为-3后,释放方法执行完毕自会 for循环操作继续执行
     * 与ReentrantLock 中有用Thread.yield同理
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
        new Thread(new MyThread(latch, 3000)).start();
        new Thread(new MyThread(latch, 0)).start();

        try {
            Thread.sleep(10000);
            System.out.println("=========" + 1);
            latch.countDown();
            Thread.sleep(10000);
            System.out.println("=========" + 2);
            latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class MyThread implements Runnable {

        private CountDownLatch latch;
        private long sleepTime;

        MyThread(CountDownLatch latch, long sleepTime) {
            this.latch = latch;
            this.sleepTime = sleepTime;
        }


        @Override
        public void run() {
            try {
                if (sleepTime > 0) {
                    Thread.sleep(sleepTime);
                }
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
