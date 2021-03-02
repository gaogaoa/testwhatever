package com.gaoce.whatever.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class HostLogPps {

    private String  ip;
    private BigDecimal iMpps;
    private BigDecimal oMpps;
    private BigDecimal iUpps;
    private BigDecimal oUpps;
    private Date timestamp;
}
