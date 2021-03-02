package com.gaoce.whatever;

import cn.hutool.core.util.XmlUtil;
import org.w3c.dom.Document;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class xxxxml {
    public static  void xxx(){

        try {
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder builder = factory.newDocumentBuilder();
//        Document document = builder.newDocument();
            //xml文件
            Document document = XmlUtil.createXml();
            document.setXmlVersion("1.0");
            document.setXmlStandalone(true);
            Element root = document.createElement("Programs");
            for (int i = 0; i < 2; i++) {
                Element Program = document.createElement("Program");       //创建根节点
                //document.appendChild(Program);                               //将根节点添加到Document对象中
                Element methodElement = document.createElement("PZID");   //设置method节点
                methodElement.setTextContent("demo001");                        //给method设置值
                Program.appendChild(methodElement);                     //添加method节点到page节点内

                Element PZTIME = document.createElement("PZTIME");
                PZTIME.setTextContent("1575342235");
                Program.appendChild(PZTIME);
                Element GKLB = document.createElement("GKLB");
                GKLB.setTextContent("list撒旦发放");
                Program.appendChild(GKLB);

                Element IP = document.createElement("IP");
                IP.setTextContent("sds");
                Program.appendChild(IP);
                root.appendChild(Program);
            }
            document.appendChild(root);






        TransformerFactory transFactory = TransformerFactory.newInstance();     //开始把Document映射到文件
        Transformer transFormer = transFactory.newTransformer();

        DOMSource domSource = new DOMSource(document);                           //设置输出结果

        File file = new File("MobileNetRule.xml"); //生成xml文件

        if (!file.exists()) {
            file.createNewFile();
        }

        FileOutputStream out = new FileOutputStream(file);          //文件输出流
        StreamResult xmlResult = new StreamResult(out);            //设置输入源

        transFormer.transform(domSource, xmlResult);              //输出xml文件
        System.out.println(file.getAbsolutePath());               //测试文件输出的路径

        TransformerFactory  tf  =  TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        t.setOutputProperty("{/encoding/}","GB2312/");
        ByteArrayOutputStream boc  = new ByteArrayOutputStream();
        t.transform(new DOMSource(document), new StreamResult(boc));
        String xmlstring = boc.toString();
        System.out.println(xmlstring);

    } catch (Exception e) {
        e.printStackTrace();
    }



}

    public static void main(String[] args){
        xxxxml.xxx();

    }
}
