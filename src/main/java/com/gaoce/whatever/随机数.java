package com.gaoce.whatever;

import java.util.Date;
import java.util.Random;

public class 随机数 {


    public static void main(String[] args) {
//        Random rand = new Random();
//         int randINT = rand.nextInt(99);
//        System.out.println(randINT);
        Date date = new Date();
        int minutes = date.getMinutes();
        System.out.println(minutes);

    }
}
