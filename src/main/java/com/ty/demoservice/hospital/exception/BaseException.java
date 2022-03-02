package com.ty.demoservice.hospital.exception;

/**
 * @author xch
 * @date 2022-02-24 14:23
 * @since v1.0
 */

public class BaseException extends RuntimeException {

    public final int code;
    public final String msg;

    public BaseException() {
        this(1000, null);
    }

    public BaseException(String msg) {
        this(1000, msg);
    }

    public BaseException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
