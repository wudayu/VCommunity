package com.wudayu.vcommunity.net.protocol;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by David on 4/25/15.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class VcListResult<T> extends BaseResult {

    @JsonProperty(value = "data")
    private ArrayList<T> object;

    public ArrayList<T> getObject() {
        return object;
    }

    public void setObject(ArrayList<T> object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "VcListResult{" + "object=" + object + '}';
    }

}