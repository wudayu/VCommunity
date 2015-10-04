package com.vcommunity.core.ex;

/**
 * VCommunity-Server basic Exception.
 *
 * @author James
 * @since V1.0
 */
public class VCException extends RuntimeException {
    private Integer code;

    /**
     * Exception base error code.
     */
    public static final Integer BASE_ERROR_CODE = 600;

    /**
     * No permission to access the Restful api.
     */
    public static final Integer NO_PERMISSION = BASE_ERROR_CODE + 1;

    /**
     * Illegal arguments.
     */
    public static final Integer ILLEGAL_ARGUMENTS = BASE_ERROR_CODE + 2;

    public VCException(Exception e) {
        super(e);
    }

    public VCException(String message, Throwable cause) {
        super(message, cause);
    }

    public VCException(String message) {
        super(message);
    }

    public VCException(Throwable cause) {
        super(cause);
    }

    public VCException() {
        super();
    }

    public VCException(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
