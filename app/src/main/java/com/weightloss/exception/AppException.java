package com.weightloss.exception;

/**
 * App异常类
 * Created by admin on 2015/11/2.
 */
public class AppException extends RuntimeException {
    public AppException() {
    }

    public AppException(String detailMessage) {
        super(detailMessage);
    }

    public AppException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public AppException(Throwable throwable) {
        super(throwable);
    }
}
