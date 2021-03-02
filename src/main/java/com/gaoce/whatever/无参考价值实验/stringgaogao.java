package com.gaoce.whatever.无参考价值实验;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.text.NumberFormat;

public class stringgaogao {

    public static void main(String[] args) {

//        String test = "gaochengrui";
//        String test1 ="gaochengrui";
//        String test2 ="Gaochengrui";
//        String test3 = "gaogaogao";
//        String test4 = "  gaogaogao  ";
//        String address="上海^上海市@闵行区#吴中路";
//        String s = "{'价格':'_66k_'}";

        // 长度
//        int length = test.length();
//        System.out.println(length);
//        System.out.println("==================================");

//        boolean equals = test1.equals(test);
//        System.out.println(equals);


//        boolean b = test2.equalsIgnoreCase(test);
//        System.out.println("==================================");
//        System.out.println(b);
//        System.out.println(test2.toLowerCase());
//        System.out.println(test.toUpperCase());
//        System.out.println(test.concat(test2));
//        System.out.println(test3.lastIndexOf("g"));
//        System.out.println(test4.trim());
//        String[] split = address.split("\\^|#|@",3);
//        for (String s : split) {
//            System.out.println(s);
//        }
//        System.out.println(test.contains("gao1"));
//        System.out.println(test.replace("g", "f"));
        String a = "{\"num\":5.0}";
       // cn.hutool.json.JSONObject jsonObject = new cn.hutool.json.JSONObject(a);

      //  System.out.println(jsonObject);


        com.alibaba.fastjson.JSONObject jsonObject1 = com.alibaba.fastjson.JSONObject.parseObject(a);
        //System.out.println(jsonObject1);
//        Integer chapterCount = 10;//总课数
//        Integer learnCount = 6;//所上课数
//
//// 创建一个数值格式化对象
//        NumberFormat numberFormat = NumberFormat.getInstance();
//// 设置精确到小数点后2位
//        numberFormat.setMaximumFractionDigits(2);
//        String result = numberFormat.format((float)  learnCount/ (float)chapterCount* 100);//所占百分比
//      //  System.out.println(result);
//        double w = -5;
//        double e = -9;
//        if (w>e){
//            System.out.println(Math.abs(w));
//        }


        a.startsWith("{");
       // System.out.println(  a.startsWith("{"));
        int nowstate = 3;
        int action = 3;
        boolean state = nowstate == action;

        System.out.println(state);
    }


}
