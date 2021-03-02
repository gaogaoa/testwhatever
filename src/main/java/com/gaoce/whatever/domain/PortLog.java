package com.gaoce.whatever.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * @author : wx
 * @version : 1
 * @date : 2020/7/31 13:48
 */
@Data
@TableName("t_port_log")
public class PortLog implements Serializable {
    private static final long serialVersionUID = 1244702696104554663L;
    @TableId(value = "ID", type = IdType.AUTO)
    private BigInteger id;
    @TableField("IP")
    private String  ip;
    @TableField("PORT")
    private String  port;
    @TableField("IN_BPS")
    private BigDecimal ibps;
    @TableField("OUT_BPS")
    private BigDecimal obps;
    @TableField("IN_MPPS")
    @JsonProperty("iMpps")
    private BigDecimal iMpps;
    @TableField("OUT_MPPS")
    @JsonProperty("oMpps")
    private BigDecimal oMpps;
    @TableField("IN_UPPS")
    @JsonProperty("iUpps")
    private BigDecimal iUpps;
    @TableField("OUT_UPPS")
    @JsonProperty("oUpps")
    private BigDecimal oUpps;
    @TableField("DISCARDS")
    private BigDecimal discards;
//    @TableField("PORT_DROP")
//    private Float drop;
    @TableField("ERROR_PPS")
    private BigDecimal epps;
    @TableField("CREATE_TIME")
//    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date timestamp;

    @Override
    public String toString() {
        return "PortLog{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", port='" + port + '\'' +
                ", ibps=" + ibps +
                ", obps=" + obps +
                ", iMpps=" + iMpps +
                ", oMpps=" + oMpps +
                ", iUpps=" + iUpps +
                ", oUpps=" + oUpps +
                ", discards=" + discards +
                ", epps=" + epps +
                ", timestamp=" + timestamp +
                '}';
    }
}
