package com.eden.javalearning.annotation.retentionpolicy.source;

import java.util.HashMap;
import java.util.Map;

//@FlexBo
public class FlexBoTest {



    Map<String,Object> jsonObj = new HashMap<>();

    public void put(String key, Object val){
        this.jsonObj.put(key, val);
    }

    public void get(String key, Object val){
        this.jsonObj.put(key, val);
    }


}
