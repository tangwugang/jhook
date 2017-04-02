package com.sanweibook.jhook.common.exception;

/**
 * Created by twg on 17/3/21.
 */
public class JhookException extends RuntimeException {
    public JhookException(){
        super();
    }
    public JhookException(String message){
        super(message);
    }
    public JhookException(Throwable throwable){
        super(throwable);
    }
}
