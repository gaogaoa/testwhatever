package com.gaoce.whatever.多线程;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class 老板 implements Callable {

    private CountDownLatch downLatch;

    public 老板(CountDownLatch downLatch)
    {
        this.downLatch = downLatch;
    }

    @Override
    public String call() throws Exception {
        System.out.println("老板正在等所有的工人干完活......");
        try
        {
            this.downLatch.await();
        }
        catch (InterruptedException e)
        {
        }
        System.out.println("工人活都干完了，老板开始检查了！");
        return null;
    }
}
