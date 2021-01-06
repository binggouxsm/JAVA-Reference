package com.eden.javalearning.annotation.retentionpolicy.source;

import java.util.HashMap;
import java.util.Map;

public interface BasicFlexBo {

    Map<String,Object> jsonObj = new HashMap<>();

    default void put(String key, Object val){
        this.jsonObj.put(key, val);
    }

    default void get(String key, Object val){
        this.jsonObj.put(key, val);
    }
}
