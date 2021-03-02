package com.gaoce.whatever.多线程;

import com.gaoce.whatever.main;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class juc工具类 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        for (int i = 0; i <6 ; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"得到一个信号量");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("释放信号量");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            }).start();
        }

    }
}
