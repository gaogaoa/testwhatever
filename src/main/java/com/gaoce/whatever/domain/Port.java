package com.gaoce.whatever.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author : wx
 * @version : 1
 * @date : 2020/7/29 15:59
 */
@Data
public class Port implements Serializable {

    /**
     * 端口描述.char(127)
     */
    private String desc;
    /**
     * 端口丢包速率（5分钟均值）.double，单位：pps
     */
    private BigDecimal discards;
    /**
     * 端口错包速率（5分钟均值）.double，单位：pps
     */
    private BigDecimal epps;
    /**
     * 端口输入组/广播包速率（5分钟均值）.double，单位：pps
     */

    /**
     * 端口输入速率（5分钟均值）.double，单位：bps
     */
    private BigDecimal ibps;
    /**
     * 设备IP.char(15)
     */
    private String ip;
    /**
     * 所属网络.z=Z网，v=V网
     */
//    private Net net;

    /**
     * 端口输出组/广播包速率（5分钟均值）.double，单位：pps
     */
    /**
     * 端口输出速率（5分钟均值）.double，单位：bps
     */
    private BigDecimal obps;
    /**
     * 端口名.char(31)
     */
    private String port;
    /**
     * 端口带宽.int，单位Mbps
     */
    private Integer speed;
    /**
     * 端口状态.int，1=UP，2=DOWN，3=SHUT
     */
    private Integer state;
    /**
     * 采样时间戳.datetime
     */
    private Date timestamp;

}
