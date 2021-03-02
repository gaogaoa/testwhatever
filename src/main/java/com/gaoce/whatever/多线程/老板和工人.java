package com.gaoce.whatever.多线程;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class 老板和工人 {
    public static void main(String[] args) {
        try {

        ExecutorService executor = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(20);
//        Future 张三 = executor.submit(new 工人(latch, "张三"));
//        Future 张1 = executor.submit(new 工人(latch, "张1"));
//        Future 张2 = executor.submit(new 工人(latch, "张2"));
        List<Future> futureList = new ArrayList<>();
            executor.submit(new 老板(latch));
        for (int i = 0; i <20 ; i++) {
            Future future = executor.submit(new 工人(latch, String.valueOf(i)));
            futureList.add(future);
        }
 //       System.out.println("所有线程已结束");
//        for (int i = 0; i <futureList.size() ; i++) {
//            System.out.println(futureList.get(i).get());
//        }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
