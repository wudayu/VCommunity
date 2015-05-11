package com.vcommunity.server.core.rest;

/**
 * @author James Chow
 * @createdate 2015/4/25
 * @contact zhouxy.vortex@gmail.com
 * @since v1.0
 */
public class Message {

    public static final int MESSAGE_TYPE_NORMAL = 0x01;
    public static final int MESSAGE_TYPE_NEED_CONFIRM = 0x02;

    private boolean success;

    private String message;

    private int messageType;

    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
