package com.gaoce.whatever;

import com.googlecode.ipv6.IPv6Address;
import com.googlecode.ipv6.IPv6Network;
import sun.net.util.IPAddressUtil;

public class ipv6 {

    public static void main(String[] args) {
        String t = "1200::abcd/24";
        IPv6Network network = IPv6Network.fromString(t);
        IPv6Address first = network.getFirst();
       // System.out.println(first.toString());
      //  System.out.println(network.getLast().toString());
        String ipstr = "2019:db8:a583::9e42:be55:53a7";
        boolean iPv6LiteralAddress = IPAddressUtil.isIPv6LiteralAddress(ipstr);
        boolean iPv4LiteralAddress = IPAddressUtil.isIPv4LiteralAddress(ipstr);
        System.out.println(iPv6LiteralAddress);
        System.out.println("iPv4LiteralAddress="+iPv4LiteralAddress);
    }

}
