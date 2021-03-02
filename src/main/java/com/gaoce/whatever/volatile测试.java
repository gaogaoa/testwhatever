package com.gaoce.whatever;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.sql.SQLOutput;

public class volatile测试 {
    public static void main(String[] args) {
        for (int i = 0; i < 10000000; i++) {
            new Thread(()->{
                Testone getone = Testone.getone();
                if (getone==null){
                    System.out.println("sds");
                }
            },i+"").start();
        }
    }

}
class Testone{

    private Testone (){

    };
    private volatile static Testone testone = null;
    public static  Testone getone(){
        if (testone==null){
            synchronized (Testone.class){
                if (testone==null){
                    testone =new Testone();
                    //分配地址
                    //初始化
                    //连接对象和引用(此时对象的引用不在为null)
                }
            }
        }
        return testone;
    }
}