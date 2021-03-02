package com.gaoce.whatever;

import cn.hutool.bloomfilter.BitMapBloomFilter;
import cn.hutool.bloomfilter.BloomFilter;

public class 布隆过滤器 {


    private static int size = 1000000;

  //  private static BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), size);

    public static void main(String[] args) {
        BitMapBloomFilter filter = new BitMapBloomFilter(1000);
        filter.add("123");
        filter.add("abc");
        filter.add("ddd");

// 查找
        boolean abc = filter.contains("abc");
        System.out.println(abc);
    }

}
