package com.gaoce.whatever;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class 时间取整 {


    public static void main(String[] args) throws ParseException {

        Date wholeByTime = ProcessingTime.getWholeByTime(new Date(1604372064000l));
        System.out.println(wholeByTime);
        SimpleDateFormat yyyyMMddHHmm = new SimpleDateFormat("yyyyMMddHHmm");
        ;

        System.out.println(yyyyMMddHHmm.format(wholeByTime));

    }
}
