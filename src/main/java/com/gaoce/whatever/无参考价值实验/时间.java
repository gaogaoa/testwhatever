package com.gaoce.whatever.无参考价值实验;

import com.alibaba.fastjson.JSON;
import com.gaoce.whatever.domain.Warning;

import java.text.SimpleDateFormat;
import java.util.*;

public class 时间 {



    public static void main(String[] args) {
        List<Warning>  warningList = new ArrayList<>();
        Warning warning = new Warning();
        warning.setCreateTime(new Date(1606180626000l));
        Warning warning1 = new Warning();
        warning1.setCreateTime(new Date(1606180566000l));
        Warning warning2 = new Warning();
        warning2.setCreateTime(new Date(1606180506000l));
        Warning warning3 = new Warning();
        warning3.setCreateTime(new Date(1606180509000l));
        warningList.add(warning);
        warningList.add(warning1);
        warningList.add(warning2);
        warningList.add(warning3);
        List<Warning> warnings = pushId(warningList);
        System.out.println(JSON.toJSONString(warnings));
    }








    public static List<Warning> pushId(List<Warning>  warningList){

        SimpleDateFormat yyyyMMddHHmm = new SimpleDateFormat("yyyyMMddHHmm");
        Map<Integer,Integer> map = new HashMap<>();
        int num = 6;
        for (int i = 0; i < warningList.size(); i++) {
            String format = yyyyMMddHHmm.format(warningList.get(i).getCreateTime());
            int minutes = warningList.get(i).getCreateTime().getMinutes();
            if (map.containsKey(minutes)){
                Integer integer = map.get(minutes);
                map.put(minutes,integer+1);

            }else {
                map.put(minutes,0);
            }
            String serialnumber = String.format("%0" + num + "d", map.get(minutes) );
            String pushid = "dss"+format+serialnumber;
            warningList.get(i).setPushid(pushid);
        }
        return  warningList;
    }
}
