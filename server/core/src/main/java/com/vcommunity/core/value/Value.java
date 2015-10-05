package com.vcommunity.core.value;

import com.vcommunity.core.ex.VCException;

import java.io.Serializable;

/**
 * Restful return value, this object will JSONfiy by Alibaba FastJson.
 *
 * @author James
 * @since V1.0
 */
public class Value implements Serializable {
    private static final long serialVersionUID = 8449730340558649204L;

    private Object ret;
    private Integer ret_code = 0;
    private String ret_msg;

    public Value() {}

    public Value(Object ret) {
        this.ret = ret;
    }

    public Value(VCException e) {
        this.ret_code = e.getCode();
        this.ret_msg = e.getMessage();
        this.ret = e.getMessage();
    }

    public Object getRet() {
        return ret;
    }

    public void setRet(Object ret) {
        this.ret = ret;
    }

    public Integer getRet_code() {
        return ret_code;
    }

    public void setRet_code(Integer ret_code) {
        this.ret_code = ret_code;
    }

    public String getRet_msg() {
        return ret_msg;
    }

    public void setRet_msg(String ret_msg) {
        this.ret_msg = ret_msg;
    }
}
