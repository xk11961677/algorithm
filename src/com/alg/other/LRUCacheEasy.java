package com.alg.other;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sky on 16/3/16.
 * 简单LRU设计
 */
public class LRUCacheEasy<K,V> {

    private static  int MAX_SIZE = 100;


    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private LinkedHashMap<K,V> list ;

    private ReentrantLock reentrantLock = new ReentrantLock();


    public LRUCacheEasy(int cacheSize) {
        MAX_SIZE = cacheSize;
        //根据cacheSize和加载因子计算hashmap的capactiy，+1确保当达到cacheSize上限时不会触发hashmap的扩容
        int capcity = (int)Math.ceil(MAX_SIZE/DEFAULT_LOAD_FACTOR)+1;

        list = new LinkedHashMap<K,V>(capcity,DEFAULT_LOAD_FACTOR,true){
            //LinkedHashMap自带的判断是否删除最老的元素方法，默认返回false，即不删除老数据
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return list.size()>MAX_SIZE;
            }
        };
    }


    public void put(K k ,V v) {
        try {
            reentrantLock.lock();
            list.put(k,v);
        }finally {
            reentrantLock.unlock();
        }

    }

    public V get(K k) {
        try {
            reentrantLock.lock();
            return list.get(k);
        }finally {
            reentrantLock.unlock();
        }
    }

    public void remove(K k) {
        try {
            reentrantLock.lock();
            list.remove(k);
        }finally {
            reentrantLock.unlock();
        }
    }


}
