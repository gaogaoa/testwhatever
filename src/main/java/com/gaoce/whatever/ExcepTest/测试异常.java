package com.gaoce.whatever.ExcepTest;

import java.util.ArrayList;
import java.util.List;

public class 测试异常 {

    public static void main(String[] args) {


        try {

            String s = "ssds";
            List list = new ArrayList();
            //list.get(1);
            try {
                list.get(1);
            }catch (Exception e ){
                System.out.println("list错误");
                e.printStackTrace();
            }
        }catch (Exception e){
            System.out.println("总错误");
            e.printStackTrace();

        }
    }
}
