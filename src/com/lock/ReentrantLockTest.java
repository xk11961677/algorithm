package com.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    public static void main(String[] args) throws Exception {
        ReentrantLock lock = new ReentrantLock();
        MyThread myThreadFirst = new MyThread(lock);
        MyThread myThreadSecond = new MyThread(lock);
        myThreadFirst.start();
        myThreadSecond.start();

        myThreadFirst.join();
        myThreadSecond.join();
//        lock.unlock();

//        Condition condition = lock.newCondition();
//        condition.await(); //
//        condition.signal(); //从条件队列里取出，放到同步锁队列中, 如果waitStatus >0 或者设置signal失败直接唤醒线程,由等待方法处理()
    }

    public static class MyThread extends Thread {
        ReentrantLock lock;

        private MyThread(ReentrantLock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            lock.lock();
            try{
                Thread.sleep(100000);
            }catch (Exception e) {

            }finally {
                lock.unlock();
            }
        }
    }
}
