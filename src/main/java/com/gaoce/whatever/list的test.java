package com.gaoce.whatever;

import java.util.ArrayList;
import java.util.List;

public class list的test {
    public static void main(String[] args) {
                 List<String> list = new ArrayList<>();
                 List<String> list1 = new ArrayList<>();
                 for (int i = 0; i < 1000; i++) {
                         list.add("test" + i);
                         list1.add("test" + (i));
                     }
                 System.out.println(checkDiffrent1(list, list1));
             }

             /**
      * 方法2：利用List的 retainAll的方法进行判断
    */
             private static boolean checkDiffrent1(List<String> list, List<String> list1) {
                 long st = System.nanoTime();
                 System.out.println("消耗时间为：" + (System.nanoTime() - st));
                 return !list.retainAll(list1);
             }


}
