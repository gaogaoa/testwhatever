package com.gaoce.whatever;

import java.util.List;

public class javabean初始化 {

    public static void main(String[] args) {

        baen baen = new baen();
        if (baen.getArrlist().size()==0){

            System.out.println("sdsd");
        }

    }
}
class baen{

    List<Integer> arrlist;

    public List<Integer> getArrlist() {
        return arrlist;
    }

    public void setArrlist(List<Integer> arrlist) {
        this.arrlist = arrlist;
    }
}