package com.gaoce.whatever;

import com.googlecode.ipv6.IPv6Address;
import com.googlecode.ipv6.IPv6Network;

public class IpConversionUtil {

    /**
     * 将IP转化为Long型
     * @param ipaddr
     * @return
     */
    private static Long setIP(String ipaddr) {
        String ip[] = ipaddr.split("\\.");
        Long ipLong = 256 * 256 * 256 * Long.parseLong(ip[0])
                + 256 * 256 * Long.parseLong(ip[1])
                + 256 * Long.parseLong(ip[2])
                + Long.parseLong(ip[3]);
        return ipLong;
    }
/**
     * 将Long型转化为IP
     * @param ipaddr
     * @return
     */
    private static String getIP(Long ipaddr) {
        long y = ipaddr % 256;
        long m = (ipaddr - y) / (256 * 256 * 256);
        long n = (ipaddr - 256 * 256 *256 * m - y) / (256 * 256);
        long x = (ipaddr - 256 * 256 *256 * m - 256 * 256 *n - y) / 256;
        return m + "." + n + "." + x + "." + y;
    }

    /**
     * 掩码位转 掩码

     * @return
     */
    private static String getnetMask (String mask) {
        int inetMask = Integer.parseInt(mask);
//子网掩码为1占了几个字节
        int num1 = inetMask / 8;
        //子网掩码的补位位数
        int num2 = inetMask%8;
        int array[] = new int[4];
        for (int i = 0; i < num1; i++) {
            array[i] = 255;
        }
        for (int i = num1; i < 4; i++) {
            array[i] = 0;
        }
        for (int i = 0; i < num2; num2--) {
            array[num1] += Math.pow(2, 8-num2);
        }
        String netMask =  array[0] + "." + array[1] + "." + array[2] + "." + array[3];
        //System.out.println("子网掩码:"+netMask);
        return netMask;
    }

    public static String getIP4NetworkAddrFir(String ipaddr,String mask){
        if (mask.equals("32")){
            return ipaddr;
        }
        String s = getnetMask(mask);
        Long ipNetworkAddr = setIP(ipaddr)&setIP(s);
        Long ipBroadcastAddr = ((ipNetworkAddr^setIP(s))^0xffffffffL);
        if (ipNetworkAddr+1>ipBroadcastAddr-1){
            return  getIP(ipBroadcastAddr-1);
        }else {
            return getIP(ipNetworkAddr+1);
        }
        //开始

        //结束
        // getIP(ipBroadcastAddr-1);

    }
    public static String getIP4NetworkAddrLast(String ipaddr,String mask){
        if (mask.equals("32") ){
            return ipaddr;
        }
        String s = getnetMask(mask);
        Long ipNetworkAddr = setIP(ipaddr)&setIP(s);
        Long ipBroadcastAddr = ((ipNetworkAddr^setIP(s))^0xffffffffL);
        //return   getIP(ipBroadcastAddr-1);\
        //开始ip小于结束ip
        if (ipNetworkAddr+1<ipBroadcastAddr-1){
            return  getIP(ipBroadcastAddr-1);
        }else {
            return getIP(ipNetworkAddr+1);
        }
    }

//    public static String getIP4NetworkAddrFir(String ip,String net){
//
//        String netMask = getnetMask(net);
//
//        String lowAddr = "";
//        int ipArray[] = new int[4];
//        int netMaskArray[] = new int[4];
//        if(4 != ip.split("\\.").length || "" == netMask){
//            System.out.println(ip.split("\\.").length);
//        }
//        String ipinfo = ip;
//        for (int i = 0; i <4; i++) {
//            ipArray[i] = Integer.parseInt(ipinfo.split("\\.")[i]);
//            String ipAddr= ipinfo.replaceAll("\n", "");
//            ipArray[i] = Integer.parseInt(ipAddr.split("\\.")[i]);
//            netMaskArray[i] = Integer.parseInt(netMask.split("\\.")[i]);
//            if(ipArray[i] > 255 || ipArray[i] < 0 || netMaskArray[i] > 255 || netMaskArray[i] < 0){
//                System.out.println("------");
//            }
//            ipArray[i] = ipArray[i]&netMaskArray[i];
//        }
//        //构造最小地址
//        for (int i = 0; i < 4; i++){
//            if(i == 3){
//                ipArray[i] = ipArray[i] + 1;
//            }
//            if ("" == lowAddr){
//                lowAddr +=ipArray[i];
//            } else{
//                lowAddr += "." + ipArray[i];
//            }
//        }
//        System.out.println("开始IP（getWay）:"+lowAddr);
//        return lowAddr;
//    }
//
//
//    public  static  int gethostmun(String net){
//        String netMask = getnetMask(net);
//        int hostNumber = 0;
//        int netMaskArray1[] = new int[4];
//        for (int i = 0; i < 4 ; i++) {
//            netMaskArray1[i] = Integer.parseInt(netMask.split("\\.")[i]);
//            if(netMaskArray1[i] < 255){
//                hostNumber =  (int) (Math.pow(256,3-i) * (256 - netMaskArray1[i]));
//            }
//        }
//        System.out.println("IP可用数量(包含广播):"+hostNumber);
//
//        return hostNumber;
//    }
//
//    public static String getIP4NetworkAddrfirLast(String ipaddr,String mask){
//        int hostNumber = gethostmun(mask);
//        String lowAddr = getIP4NetworkAddrFir(ipaddr, mask);
//        int lowAddrArray[] = new int[4];
//        for (int i = 0; i < 4; i++) {
//            lowAddrArray[i] = Integer.parseInt(lowAddr.split("\\.")[i]);
//            if(i == 3){
//                lowAddrArray[i] = lowAddrArray[i] - 1;
//            }
//        }
//        lowAddrArray[3] = lowAddrArray[3] + (hostNumber - 1);
//        if(lowAddrArray[3] >255){
//            int k = lowAddrArray[3] / 256;
//            lowAddrArray[3] = lowAddrArray[3] % 256;
//            lowAddrArray[2] = lowAddrArray[2] + k;
//        }
//        if(lowAddrArray[2] > 255){
//            int  j = lowAddrArray[2] / 256;
//            lowAddrArray[2] = lowAddrArray[2] % 256;
//            lowAddrArray[1] = lowAddrArray[1] + j;
//            if(lowAddrArray[1] > 255){
//                int  k = lowAddrArray[1] / 256;
//                lowAddrArray[1] = lowAddrArray[1] % 256;
//                lowAddrArray[0] = lowAddrArray[0] + k;
//            }
//        }
//        String highAddr = "";
//        for(int i = 0; i < 4; i++){
//            if(i == 3){
//                lowAddrArray[i] = lowAddrArray[i] - 1;
//            }
//            if("" == highAddr){
//                highAddr = lowAddrArray[i]+"";
//            }else{
//                highAddr += "." + lowAddrArray[i];
//            }
//        }
//        System.out.println("结束IP:"+highAddr);
//        return highAddr;
//    }
    public static String getIP6NetworkAddrFir(String ipaddr){
       // String t = "1200::abcd/24";
        IPv6Network network = IPv6Network.fromString(ipaddr);
        IPv6Address first = network.getFirst();
        return first.toString();
    }
    public static String getIP6NetworkAddrfirLast(String ipaddr){
        IPv6Network network = IPv6Network.fromString(ipaddr);
        return network.getLast().toString();
    }

    public static void main(String[] args) {
        String ipNetworkAddrFir = getIP4NetworkAddrFir("45.21.1.2", "31");
        String ip4NetworkAddrLast = getIP4NetworkAddrLast("45.21.1.2", "31");
        //String addrfirLast = getIP4NetworkAddrfirLast("1.1.1.1", "32");
        System.out.println(ipNetworkAddrFir+"==>"+ip4NetworkAddrLast);
//        String ip6NetworkAddrFir = getIP6NetworkAddrFir("1200::abcd/24");
//        String networkAddrfirLast = getIP6NetworkAddrfirLast("1200::abcd/24");
//        System.out.println(ip6NetworkAddrFir+"=>"+networkAddrfirLast);
    }

}
