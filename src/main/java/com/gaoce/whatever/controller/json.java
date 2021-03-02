package com.gaoce.whatever.controller;

import com.alibaba.fastjson.JSON;
import com.gaoce.whatever.domain.PortLog;

import java.math.BigDecimal;

public class json {

    public static void main(String[] args) {
        DeviceHost deviceHost =new DeviceHost();
        PortLog portLog = new PortLog();
        portLog.setDiscards(new BigDecimal(1));
        portLog.setDiscards(new BigDecimal(1));
        String s = JSON.toJSONString(deviceHost);
        System.out.println(s
        );
    }
}
