package com.ty.demoservice.hospital.common.resp;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


@EqualsAndHashCode(callSuper = true)
@Data
public class ObjectResponse<T> extends BaseResponse {

    private ObjectContent<T> data;

    @Data
    public static class ObjectContent<T> implements Serializable {
        private T content;

        public ObjectContent(T data) {
            this.content = data;
        }
    }

    public ObjectResponse() {}

    public ObjectResponse(T data) {
        this.data = new ObjectContent<>(data);
    }

    public ObjectResponse(T data, String msg) {
        this(data);
        this.msg = msg;
    }

    public ObjectResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
