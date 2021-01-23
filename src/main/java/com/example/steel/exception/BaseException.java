package com.example.steel.exception;

/**
 * 对异常进行封装的基本异常类
 *
 */
public class BaseException extends RuntimeException {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -1187516993124229948L;

    /**
     * 构造函数
     * 
     * @param throwable 异常
     */
    public BaseException(Throwable throwable) {
        super(throwable);
    }

    /**
     * 构造函数
     * @param message 异常消息
     */
    public BaseException(String message) {
        super(message);
    }
    
    /**
     * 构造函数
     * @param message 异常消息
     * @param cause 堆栈异常
     */
    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
