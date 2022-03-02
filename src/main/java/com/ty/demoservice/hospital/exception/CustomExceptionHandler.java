package com.ty.demoservice.hospital.exception;

import com.ty.demoservice.hospital.common.resp.ObjectResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(BaseException.class)
    @ResponseStatus
    public ObjectResponse<Void> handlerBaseException(BaseException baseException) {
        log.error("baseException : code ---> {}, msg ---> {}", baseException.getCode(), baseException.getMsg());
        return new ObjectResponse<>(baseException.getCode(), baseException.getMsg());
    }

    /**
     * 统一异常处理
     *
     * @param exception 异常
     * @return 自定义返回信息
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus
    public ObjectResponse<Void> handlerException(Exception exception) {
        Throwable cause = exception.getCause();
        if (cause instanceof BaseException) {
            BaseException baseException = (BaseException) cause;
            return handlerBaseException(baseException);
        }
        log.error("exception message ---> {}", exception.getMessage());
        exception.printStackTrace();
        return new ObjectResponse<>(1000, "内部错误");
    }

}
