package com.gaoce.whatever.无参考价值实验;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class list循环 {



    public static void main(String[] args) {
        List<String> list = new ArrayList();
        List<String> list1 = new ArrayList();
        list.add("1");;
        list.add("2");
        list1.add("1");
        list1.add("2");
        list1.add("3");
        for (String o : list) {
            list1.remove(o);
        }
        System.out.println(JSON.toJSONString(list1
         ));
    }
}
