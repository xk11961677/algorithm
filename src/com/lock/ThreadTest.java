package com.lock;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.*;

public class ThreadTest {



    public static void main(String[] args) throws Exception {
        boolean flag = false;
        Thread threadSecond = new Thread(new ThreadSecond(flag));

        Thread threadFirst = new Thread(new ThreadFirst(flag));

        threadSecond.start();
        threadFirst.start();

        Thread.sleep(1000000);
        new Object();

        ExecutorCompletionService completionService = new ExecutorCompletionService(Executors.newFixedThreadPool(3));

        Future future = completionService.submit(() -> {
            System.out.println("A");
            return null;
        });

        future.get();
        completionService.take();
    }


    static class ThreadSecond implements Runnable {

        private boolean flag;

        ThreadSecond(boolean flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
            while (true) {
                if (flag) {
                    break;
                }
            }
            System.out.println("ThreadSecond end ");
        }
    }


    static class ThreadFirst implements Runnable {

        private boolean flag;

        ThreadFirst(boolean flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
            stop();
            flag = true;
        }

        public void stop() {
            try {
                System.out.println("begin");
                File file = new File("/Users/sky/logs/rocketmqlogs/namesrv_default.log");
                FileInputStream fis = new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(fis);
                byte[] bytes = new byte[1];
                int temp;
                while ((temp = bis.read(bytes)) != -1) {
                    new String(bytes, 0, temp);
                }
                System.out.println();
                System.out.println("end");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
