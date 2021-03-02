package com.gaoce.whatever;

import com.gaoce.whatever.domain.Warning;

import java.text.SimpleDateFormat;
import java.util.Date;

public class 时间转换 {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        Long stime= date.getTime()-  300000;


        System.out.println(simpleDateFormat.format(new Date()));
        System.out.println(simpleDateFormat.format(stime));

    }
}
