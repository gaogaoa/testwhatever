package com.gaoce.whatever.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author : wx
 * @version : 1
 * @date : 2020/7/28 11:43
 */
@Data
public class Host implements Serializable {
    /**
     * 所属地域.varchar(31)
     */
    private String city;
    /**
     * snmp团体字，暂时不对外提供.varchar(31)
     */
    private String community;
    /**
     * 指定请求设备数量.最大支持10000
     */
    private Integer count;

    /**
     * PING延迟.单位：s
     */
    private Float delay;

    /**
     * 设备型号.varchar(63)
     */
    private String dev;

    /**
     * 采集服务器节点.varchar(31)
     */
    private String dg;
    /**
     * PING丢包.0-1
     */
    private Float drop;
    /**
     * 指定开始设备序号.从0开始
     */
    private Integer from;
    /**
     * 整机输入速率（5分钟均值）.单位：bps
     */
    private BigDecimal ibps;
    /**
     * 备注.varchar(255)
     */
    private String intro;
    /**
     * 设备IP.char(15)
     */
    private String ip;
    /**
     * 所属网络.z=Z网，v=V网
     */
//    private Net net;
    /**
     * 整机输出速率（5分钟均值）.单位：bps
     */
    private BigDecimal obps;
    /**
     * 系统版本.varchar(63)
     */
    private String osver;
    /**
     * 设备拥有者（负责人）.varchar(31)
     */
    private String owner;
    /**
     * SNMP采集丢包.0-1
     */
    private Float snmpdrop;
    /**
     * snmp版本（目前主要支持2）.int
     */
    private Integer snmpver;
    /**
     * 设备状态.32位，0表示正常，每一位含义： 0. 正常； 1. 网络不可达或SNMP团体字异常 2. 网络协议异常 3. 未知的设备 4. 未知的用户
     * 5. SNMP无写权限 6-7. 预留 8. 配置错误 9. 端口DOWN 10. 错包 11. 设备间端口不匹配 12-15.预留 16. 流量出大于入 17. 流量出少于入
     * 18. 流量突变 19-23.预留 24. GTC 25. G-D链路数不匹配
     */
    private Integer state;
    /**
     * 设备主机名.varchar(31)
     */
    private String sysname;
    /**
     * 采样时间戳.datetime
     */
    private Date timestamp;
    /**
     * 设备类型.char(7)
     */
    private String type;

}
