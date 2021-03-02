package com.gaoce.whatever;


import com.alibaba.fastjson.JSON;
import com.gaoce.whatever.domain.HostVariance;
import com.sun.javafx.collections.MappingChange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class map测试 {
    public static void main(String[] args) {
        Map<String, List> newaddmap = new HashMap<>();
        List<HostVariance> lsit = new ArrayList();
        HostVariance hostVariance1 = new HostVariance();
        hostVariance1.setIp("dfsdfsd");

        HostVariance hostVariance2 = new HostVariance();
        hostVariance2.setIp("dfsdfsd");
        HostVariance hostVariance3 = new HostVariance();
        hostVariance3.setIp("33333");

        HostVariance hostVariance4 = new HostVariance();
        hostVariance4.setIp("22222");

        HostVariance hostVariance5 = new HostVariance();
        hostVariance5.setIp("dfsdfsd");

        HostVariance hostVariance6 = new HostVariance();
        hostVariance6.setIp("dfsdfsd");

        lsit.add(hostVariance1);
        lsit.add(hostVariance2);
        lsit.add(hostVariance3);
        lsit.add(hostVariance4);
        lsit.add(hostVariance5);
        lsit.add(hostVariance6);

        for (HostVariance hostVariance : lsit) {

            if (newaddmap.containsKey(hostVariance.getIp())){
                List jsonArray = newaddmap.get(hostVariance.getIp());
                jsonArray.add(hostVariance);
            }else {
                List jsonArray = new ArrayList();
                jsonArray.add(hostVariance);
                newaddmap.put(hostVariance.getIp(),jsonArray);
            }
        }
      //System.out.println(JSON.toJSONString(newaddmap));
        Map map = new HashMap();
        System.out.println( map.containsKey("s"));

    }
}
