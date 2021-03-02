package com.gaoce.whatever.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@Data
public class HostLogVo {

    @TableId(value = "ID", type = IdType.AUTO)
    private BigInteger id;
    @TableField("IP")
    private String  ip;
    @TableField("STATE")
    private Integer state;
    @TableField("IN_BPS")
    private BigDecimal ibps;
    @TableField("OUT_BPS")
    private BigDecimal obps;
    @TableField("IN_MPPS")
    private BigDecimal iMpps;
    @TableField("OUT_MPPS")
    private BigDecimal oMpps;
    @TableField("IN_UPPS")
    private BigDecimal iUpps;
    @TableField("OUT_UPPS")
    private BigDecimal oUpps;
    @TableField("DISCARDS")
    private BigDecimal discards;
    @TableField("HOST_DROP")
    private Float dropping;
    @TableField("ERROR_PPS")
    private BigDecimal epps;
    @TableField("DELAY")
    private Float delay;
    @TableField("CREATE_TIME")
    private Date timestamp;
}
