package com.gaoce.whatever;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class 并发修改异常 {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("sdsd");
        list.add("sd");
        list.add("dsd");

        for (int i = 0; i <30 ; i++) {
            new Thread(()->{
                list.add("qwqwq");
                System.out.println(list);
            },"aaa").start();
        }
      Thread thread =   new Thread();
        thread.start();
    }
}
