package com.gaoce.whatever;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class 获取本机ip {

    public static void main(String[] args) {
                 // TODO Auto-generated method stub
//                InetAddress ia=null;
//                 try {
//                      ia=ia.getLocalHost();
//
//                        String localname=ia.getHostName();
//                      String localip=ia.getHostAddress();
//                     System.out.println("本机名称是："+ localname);
//                     System.out.println("本机的ip是 ："+localip);
//                     } catch (Exception e) {
//                       // TODO Auto-generated catch block
//                      e.printStackTrace();
//                  }
        String ipAddress = getIpAddress();
        System.out.println(ipAddress);

    }




    public static String getIpAddress() {
        try {
            Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
                if (netInterface.isLoopback() || netInterface.isVirtual() || !netInterface.isUp()) {
                    continue;
                } else {
                    Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                    while (addresses.hasMoreElements()) {
                        ip = addresses.nextElement();
                        if (ip != null && ip instanceof Inet4Address) {
                            return ip.getHostAddress();
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("IP地址获取失败" + e.toString());
        }
        return "";
    }


}
