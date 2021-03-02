package com.gaoce.whatever.domain;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public enum Net implements Serializable {
    v("v"),z("z");
    private String value;
    Net(String value){
        this.value=value;
    }
    @JsonValue
    public String getValue() {
        return value;
    }
    public static List<String> getValuesList(){
        List<String> data=new ArrayList<>(2);
//        data.add(v.value);
        data.add(z.value);
        return data;
    }
}
