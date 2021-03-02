package com.gaoce.whatever.多线程;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class 工人 implements Callable {

    //抗特当蓝翅
    private CountDownLatch downLatch;
    private String name;

    public 工人(CountDownLatch downLatch, String name ){
        this.downLatch = downLatch;
        this.name = name;
    };

    @Override
    public String call() throws Exception {
        System.out.println("我开始了");
        TimeUnit.SECONDS.sleep(new Random().nextInt(10));
        this.downLatch.countDown();
        System.out.println("我是"+name+"我完事了");
        return "我完事了";
    }
}
