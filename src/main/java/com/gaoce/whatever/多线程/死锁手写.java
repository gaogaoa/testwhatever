package com.gaoce.whatever.多线程;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 死锁手写 {
    public static void main(String[] args) {
        String locka = "sd";
        String lockb = "wqw";
       new Thread(new dielock(locka,lockb),"aaa").start();
       new Thread(new dielock(lockb,locka),"bbb").start();

    }
}
class dielock implements Runnable{
    private String locka ;
    private String lockb;
    public dielock( String locka,String lockb){
        this.locka =locka;
        this.lockb = lockb;
    }

    @Override
    public void run() {
        synchronized (locka){

            System.out.println("有a想要b");
            synchronized (lockb){
                System.out.println("有b想要a");
            }
        }
    }
}