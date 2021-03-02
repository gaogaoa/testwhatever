package com.gaoce.whatever.domain;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TableName {
    port("port"),host("host");
    @JsonValue
    public String getValue() {
        return value;
    }
    TableName(String value){
        this.value=value;
    }
    private String value;
}
