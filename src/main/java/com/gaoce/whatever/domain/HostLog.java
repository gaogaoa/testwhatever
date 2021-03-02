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
@TableName("t_host_log")
public class HostLog implements Serializable {
    private static final long serialVersionUID = 7152897511405235783L;
    @TableId(value = "ID", type = IdType.AUTO)
    private BigInteger  id;
    @TableField("IP")
    private String  ip;
    @TableField("STATE")
    private Integer state;
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
    @TableField("HOST_DROP")
    private Float drop;
    @TableField("ERROR_PPS")
    private BigDecimal epps;
    @TableField("DELAY")
    private Float delay;
    @TableField("CREATE_TIME")
   // @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date timestamp;
}
