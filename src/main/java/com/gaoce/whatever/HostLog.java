package com.gaoce.whatever;


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

public class HostLog implements Serializable {
    private static final long serialVersionUID = 7152897511405235783L;

    private BigInteger  id;

    private String  ip;

    private Integer state;

    private BigDecimal ibps;

    private BigDecimal obps;

    @JsonProperty("iMpps")
    private BigDecimal iMpps;

    @JsonProperty("oMpps")
    private BigDecimal oMpps;

    @JsonProperty("iUpps")
    private BigDecimal iUpps;

    @JsonProperty("oUpps")
    private BigDecimal oUpps;

    private BigDecimal discards;

    private Float drop;

    private BigDecimal epps;
    private Float delay;

   // @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date timestamp;
}
