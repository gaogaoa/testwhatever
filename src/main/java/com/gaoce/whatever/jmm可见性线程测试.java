package com.gaoce.whatever;

import com.alibaba.fastjson.JSON;

public class jmm可见性线程测试 {
    public static void main(String[] args) {
        Host host = new Host();
        new Thread(()->{
            System.out.println(JSON.toJSONString(host));
        },"aa").start();


    }
}

class  Host{
    public Host(){};
    private int s = 0;
    public void getadd(){
       s=9;
    }

}
