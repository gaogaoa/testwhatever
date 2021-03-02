package com.gaoce.whatever;

import java.util.*;

public class arraylist源码 {


    public static void main(String[] args) {

        List list =new ArrayList();
        list.add("gao");
        list.add("li");
        list.add(5,"sdsd");
        System.out.println(list);
        Set set =new HashSet();
        Set set1 = new LinkedHashSet();

        set.add("sd");

    }

    private static void xxx(int index, byte element){

        byte[]  srcBytes = new byte[]{2,5,0,0};
         byte[] destBytes = new byte[4];
        System.arraycopy(srcBytes, index, destBytes, index+1, destBytes.length-index);
        destBytes[index] = element;

        for(int i = 0;i< destBytes.length;i++){
            System.out.print("-> " + destBytes[i]);
        }
        for (byte destByte : destBytes) {
            if (true){
                final  String i= "2";
                String sds = "sds";
                i.equals(sds);
                System.out.println("哈哈");
            }
        }
    }
}
