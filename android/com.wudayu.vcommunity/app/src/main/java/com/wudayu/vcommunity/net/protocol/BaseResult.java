package com.wudayu.vcommunity.net.protocol;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author: Wu Dayu
 * @En_Name: David Wu
 * @E-mail: wudayu@gmail.com
 * @Created Time: Nov 5, 2014, 11:28:03 PM
 * @Description: BaseResult是由服务器返回的通用Json所对应的对象，其所包含的字段在每个服务器返回的字段中都包含
 *
 **/

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseResult {

    public static final int MESSAGE_TYPE_NORMAL = 0x01;
    public static final int MESSAGE_TYPE_NEED_CONFIRMED = 0x02;

	@JsonProperty(value = "success")
	private boolean success;

	@JsonProperty(value = "message")
	private String message;

    @JsonProperty(value = "messageType")
    private int messageType;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", messageType=" + messageType +
                '}';
    }
}
