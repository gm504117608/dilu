package com.dilu.common.exception;


/**
 * @author guonima
 * @create 2017-09-06 13:34
 */
public class DataException extends RuntimeException {
    public DataException() {
        super();
    }

    public DataException(String message) {
        super(message);
    }

    public DataException(Throwable cause) {
        super(cause);
    }

    public DataException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataException(String message, Throwable cause,
                         boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
