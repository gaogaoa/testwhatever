package com.gaoce.whatever;

import com.alibaba.fastjson.JSON;
import com.gaoce.whatever.domain.DeviceHost;

import java.util.ArrayList;
import java.util.List;

public class 测试list的foreach {

    public static void main(String[] args) {

        List<DeviceHost> hostList =new ArrayList<>();
        DeviceHost deviceHost = new DeviceHost();
        deviceHost.setIp("111");
        hostList.add(deviceHost);
        hostList.stream().forEach(host->{
            host.setCity("2332");

        });
        System.out.println(JSON.toJSONString(hostList));
    }
}
