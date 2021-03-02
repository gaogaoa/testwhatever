package com.gaoce.whatever.domain;

import lombok.Data;

import java.util.List;

@Data
public class Response {
    private String message;
    private String code;
    private List<NewHostAndPort> data;
}
