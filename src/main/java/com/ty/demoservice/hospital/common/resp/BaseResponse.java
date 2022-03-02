package com.ty.demoservice.hospital.common.resp;

import java.io.Serializable;

/**
 * @author xch
 * @date 2022-02-24 14:27
 * @since v1.0
 */

public abstract class BaseResponse implements Serializable {

    protected int code;

    protected String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
