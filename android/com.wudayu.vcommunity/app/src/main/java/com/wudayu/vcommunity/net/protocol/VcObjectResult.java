package com.wudayu.vcommunity.net.protocol;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by David on 4/25/15.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class VcObjectResult<T> extends BaseResult {

    @JsonProperty(value = "data")
    private T object;

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "VcObjectResult{" + "object=" + object + '}';
    }

}