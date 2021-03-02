package com.gaoce.whatever.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gaoce.whatever.domain.Test;
import com.gaoce.whatever.domain.Warning;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Slf4j
@Service
public class duo  extends ServiceImpl<TestMapper, Test> implements IService<Test> {


    public static void main(String[] args) {
        Test test1 =new Test();
        test1.setField1("1");
        Test test2 =new Test();
        test2.setField1("2");
        Test test3 =new Test();
        test3.setField1("3");
        Test test4 =new Test();
        test4.setField1("4");
        List<Test> list = new ArrayList<>();
        list.add(test1);
        list.add(test2);
        list.add(test3);
        list.add(test4);
        duo duo = new duo();
        duo.batchInsert(list);
    }

    public  void batchInsert(List<Test> list) {
        int total = list.size();
        int max = 3;
        int count = total / max;
        int left = total % max;
        int length;
        if (left == 0) length = count;
        else length = count + 1;
        for (int i = 0; i < length; i++) {
            int start = max * i;
            int end = max * (i + 1);
            if (i != count) {
                log.info("正在插入第" + (start + 1) + " ~ " + end + "条记录 ······");
             //   System.out.println("end"+end);
              //  System.out.println(JSON.toJSONString(list));
               saveBatch(list, end);
            } else {
                end = total;
                log.info("正在插入第" + (start + 1) + " ~ " + end + "条记录 ······");
            //    System.out.println(JSON.toJSONString(list));
             //   System.out.println("end"+end);
            saveBatch(list, end);
            }
        }
    }

}
