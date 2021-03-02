package com.gaoce.whatever;

import java.text.SimpleDateFormat;
import java.util.Date;

public class 当前时间前三个月 {
    public static void main(String[] args) {
        try {



        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sdf.format(date);
        String[] item = time.split("-");
        int year  = Integer.parseInt(item[0]);
        int month = Integer.parseInt(item[1]);
        int day   = Integer.parseInt(item[2]);
        if((month - 3) <= 0){
            month = month + 12 - 3;
            year = year -1;
        }else {
            month = month - 3;
        }
        time = year + "-" + month + "-" + day+ " "+"00"+":"+"00"+":"+"00" ;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date parse = simpleDateFormat.parse(time);
            String format = simpleDateFormat.format(parse);
            System.out.println(
                    format
        );
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
