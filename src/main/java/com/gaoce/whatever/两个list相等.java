package com.gaoce.whatever;

import org.apache.commons.collections.ListUtils;

import java.util.ArrayList;
import java.util.List;

public class 两个list相等 {


    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list1.add("1");
        list1.add("1");
        list2.add("1");
        boolean isequal = ListUtils.isEqualList(list1,list2);           //如果相等就返回true
        System.out.println(isequal);
    }
}
