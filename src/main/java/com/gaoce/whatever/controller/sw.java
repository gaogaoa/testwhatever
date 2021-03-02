package com.gaoce.whatever.controller;

public class sw {

    public static void main(String[] args) {
        String vlaue = "未知的设备";
        int i = processingStatus(vlaue);
        System.out.println(i);
    }

    public static int processingStatus( String vlaue ) {
        switch(vlaue){
            case "正常": return 0;
            case "网络不可达或SNMP团体字异常": return 1;
            case "网络协议异常": return 2;
            case "未知的设备": return 3;
            case "未知的用户": return 4;
            case "SNMP无写权限": return 5;
            case "配置错误": return 8;
            case "端口DOWN": return 9;
            case "错包": return 10;
            case "设备间端口不匹配": return 11;
            case "流量出大于入": return 16;
            case "流量出少于入": return 17;
            case "流量突变": return 18;
            case "GTC": return 24;
            case "G-D链路数不匹配": return 25;
        }
        return -1;
    }
}
