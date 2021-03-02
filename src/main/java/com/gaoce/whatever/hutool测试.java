package com.gaoce.whatever;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import com.alibaba.fastjson.JSON;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.Date;

public class hutool测试 {

    public static void main(String[] args) {
      //时间转换

        String shijian = "2017-05-06 12:22:23";
        Date date = Convert.toDate(shijian);
        System.out.println(JSON.toJSONString(date));

        Date date1 = DateUtil.date(1494044543000l);
    //获得年的部分
        DateUtil.year(date);

    //获得月份，从0开始计数
        DateUtil.month(date);
    //获得月份枚举
        DateUtil.monthEnum(date);
    //.....
        System.out.println(DateUtil.year(date));
        System.out.println(DateUtil.month(date));
        System.out.println(DateUtil.monthEnum(date));


        //        FileReader fileReader = new FileReader("D:\\work\\test\\whatever\\MobileNetRule.xml");
        //        String result = fileReader.readString();
        //        System.out.println(result);
        FileWriter writer = new FileWriter("test.xml");
        writer.write("D:\\work\\test\\whatever\\MobileNetRule.xml");

        String template = "{}爱{}，就像老鼠爱大米";
        String str = StrUtil.format(template, "大哥", "大姐"); //str -> 我爱你，就像老鼠爱大米
        String ss="";
        boolean empty = StrUtil.isEmpty(ss);
        System.out.println(empty);
        System.out.println(str);
        //创建
        Document xml = XmlUtil.createXml();
        xml.setXmlVersion("1.0");
        Element sd = xml.createElement("sd");
        sd.setAttribute("sd","sds");
    }
}
