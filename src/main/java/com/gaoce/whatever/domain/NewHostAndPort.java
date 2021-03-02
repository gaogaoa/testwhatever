package com.gaoce.whatever.domain;


import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
public class NewHostAndPort {

    private   TableName table;
    private  String host;
    private  String port;
    private Date from;

    private  Date to;
    private String grain;
    private  String vtype;
    private  Integer offset;

    private  Integer limit;
    private  Map< String,String> tags;
    private List<String> timestamp;
    private Map<String,Object> fields;
}
