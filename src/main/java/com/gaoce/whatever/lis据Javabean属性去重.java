package com.gaoce.whatever;

import java.util.*;
import java.util.stream.Collectors;

public class lis据Javabean属性去重 {

    public static void main(String[] args) {

        List<HostLog> list= new ArrayList<>();
        HostLog hostLog = new HostLog();
        HostLog hostLog1 = new HostLog();
        hostLog.setTimestamp(new Date(1604311095000l));
        hostLog1.setTimestamp(new Date(1604311095000l));
        list.add(hostLog);
        list.add(hostLog1);
        List<HostLog> cpList= new ArrayList<>();
        cpList=list.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(()->new TreeSet<>(Comparator.comparing(HostLog::getTimestamp))),ArrayList::new));
        System.out.println(cpList);
        System.out.println("========="+list);

    }
  }
