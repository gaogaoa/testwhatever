package com.gaoce.whatever.domain;

import lombok.Data;

import java.math.BigInteger;
import java.util.Date;


@Data
public class HostVariance {
    private BigInteger id;
    private String  ip;
    private Double ibpsvariance;
    private Double obpsvariance;
    private Date createtime;
}
