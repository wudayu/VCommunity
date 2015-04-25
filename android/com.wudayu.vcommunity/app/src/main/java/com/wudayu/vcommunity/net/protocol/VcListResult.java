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
    private ArrayList<T> list;

    public ArrayList<T> getList() {
        return list;
    }

    public void setList(ArrayList<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "VcListResult{" + "list=" + list + '}';
    }

}