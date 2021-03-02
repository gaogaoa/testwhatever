package com.gaoce.whatever.controller;

import javafx.scene.input.InputMethodTextRun;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

public class sd {
    public static void main(String[] args) {

//        double[] i = {10000,10001,7001,6999};
//        Random random = new Random();
//        int r = random.nextInt(i.length);
//        double a = i[r];
//       ;
//        System.out.println( BigDecimal.valueOf(a));



//
//        Calendar beforeTime = Calendar.getInstance();
//       // beforeTime.add(Calendar.MINUTE, -5);// 5分钟之前的时间
//       // beforeTime.setTime();
//        Date beforeD = beforeTime.getTime();
//        String before5 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(beforeD);  // 前五分钟时间
//        System.out.println(before5);


       List<BigDecimal> ibpslist =new ArrayList<>();
       ibpslist.add(null);
       ibpslist.add(null);
       ibpslist.add(null);
       ibpslist.add(null);
       ibpslist.add(null);
       ibpslist.add(null);
       ibpslist.add(null);
       // System.out.println("======"+ibpslist);
        for (int i = 0; i < ibpslist.size(); i++) {
            //BigDecimal bigDecimal = new BigDecimal();
            if (ibpslist.get(i)!=null){
                BigDecimal bigDecimal=  ibpslist.get(i);
                System.out.println("sdsds"+bigDecimal);
            }else {
                System.out.println("Sdsdsddfjklfghlskdghlskhglsdkh");
            }

        }
//ibpslist.add(1);

       // System.out.println("最大值: " + Collections.max(ibpslist));
    }
}
