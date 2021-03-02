package com.gaoce.whatever;

public class 六位数前边补0 {





    public static void main(String[] args) {
        String result = "";
        int num = 6;
        // 保留num的位数
        // 0 代表前面补充0
        // d 代表参数为正数型
        result = String.format("%0" + num + "d",1 );



        System.out.println(result);
    }
}
