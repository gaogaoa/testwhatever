package com.gaoce.whatever;

import com.alibaba.fastjson.JSON;
import com.gaoce.whatever.domain.Port;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class 时间预测 {


    public static void main(String[] args) {
        List<Port> dataList = new ArrayList<>();
        Port port = new Port();
        port.setIp("sdsds");
        dataList.add(port);
        List<Object> dataolist = new ArrayList<>();
//        BeanUtils.copyProperties(dataList,dataolist);
//        System.out.println(dataList);
//        System.out.println(dataolist);

        String s = JSON.toJSONString(dataList);
        dataolist = JSON.parseArray(s);
        System.out.println(dataolist);

    }

}
