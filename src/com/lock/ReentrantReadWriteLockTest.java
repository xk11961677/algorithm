package com.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

public class ReentrantReadWriteLockTest {

    public static void printUpgrade(ReentrantReadWriteLock lock) {
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        readLock.lock();
        try {
            System.out.println("====>>printUpgrade :{}");
            ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
            writeLock.lock();
            System.out.println("====>>printUpgrade get write lock :{}");
            writeLock.unlock();
        } finally {
            readLock.unlock();
        }
    }

    public static void printDegrade(ReentrantReadWriteLock lock) {
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
        writeLock.lock();
        try {
            System.out.println("====>>printDegrade :{}");
            ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
            readLock.lock();
            System.out.println("====>>printDegrade get read lock :{}");
            readLock.unlock();
        } finally {
            writeLock.unlock();
        }
    }


    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
//        printUpgrade(lock);

        printDegrade(lock);
    }
}
