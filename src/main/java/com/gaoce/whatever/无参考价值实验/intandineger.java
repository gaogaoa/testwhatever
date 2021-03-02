package com.gaoce.whatever.无参考价值实验;

import java.util.*;

public class intandineger {


//sdsd 圣诞快乐,
    public static void main(String[] args) {
//        List lsds= new ArrayList();
//        lsds.add(null);
//        lsds.add(null);
//        lsds.add(null);
//        lsds.add(null);
//        lsds.add(null);
//        System.out.println(lsds.size());
        //Java为了提高性能提供了和String类一样的对象池机制，当然Java的八种基本类型的包装类（Packaging Type）也有对象池机制。-128<=i1<=127
      //  Integer i1=400;
      //  Integer i2=400;
//        //System.out.println(i1.equals(i2));
//        ArrayList<Object> objects = new ArrayList<>();
//        objects.add(1);
//
//
//        //int1 == integer1，Integer是int的封装类，当Integer与int进行==比较时，Integer就会拆箱成一个int类型，所以还是相当于两个int类型进行比较，这里的Integer,不管是直接赋值，还是new创建的对象，只要跟int比较就会拆箱为int类型，所以就是相等的。
//        Integer i =new Integer(1000);
//        Integer i1 =1000;
//      //  System.out.println(i==i1);
//        System.out.println(getType(objects.get(0)));


        List<Integer> sd = new ArrayList<>();
        sd.add(2);
        sd.add(1);
        sd.add(3);
        sd.add(5);
       List<Integer> sdds= new LinkedList<>();
        Map map = new HashMap();
        System.out.println(sd);




    }


    private static String getType(Object a) {
        return a.getClass().toString();

    }
}
