package com.gaoce.whatever;

import java.util.concurrent.Callable;

public class 线程 implements Callable<Integer> {

    private int number;

    public 线程(int number) {
        this.number = number;
    }

    //计算阶乘
    public Integer call() throws Exception {
        Integer result = 1;
        if (number == 0 || number == 1)
            result = 1;
        else {
            for (int i = 2; i <= number; i++) {
                result *= i;
                //为了演示效果，休眠20ms
                Thread.sleep(20);
            }
        }
        System.out.printf("线程:%s," + number + "!= %d\n", Thread.currentThread().getName(), result);
        return result;
    }
}
