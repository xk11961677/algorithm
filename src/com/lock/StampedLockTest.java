package com.lock;

import java.util.concurrent.locks.StampedLock;

public class StampedLockTest {
    /** 是否可以冲入 begin ***/
    public static void print(StampedLock lock) {
        long l = lock.writeLock();
        try {
            System.out.println("====>>print :{}" + l);
            printOther(lock);
        } finally {
            lock.unlock(l);
        }
    }

    public static void printOther(StampedLock lock) {
        System.out.println("====>>printOther :{} 是否可以重入 ");
        long l = lock.writeLock();
        try {
            System.out.println("====>>printOther :{}" + l);
        } finally {
            lock.unlock(l);
        }
    }
    /** 是否可以冲入 end ***/


    public static void printUpgrade(StampedLock lock) {
        long l = lock.readLock();
        try {
            System.out.println("====>>printUpgrade :{}" + l);
            long l1 = lock.writeLock();
            System.out.println("====>>printUpgrade get write lock :{}" + l1);
            lock.unlock(l1);
        } finally {
            lock.unlock(l);
        }
    }

    public static void main(String[] args) {
        StampedLock lock = new StampedLock();
//
//        print(lock);
        printUpgrade(lock);
    }
}
