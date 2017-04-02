package com.sanweibook.jhook.dal;

/**
 * Created by twg on 17/3/19.
 */
public class SnowflakeIdWorkerException extends RuntimeException {

    public SnowflakeIdWorkerException(){
        super();
    }

    public SnowflakeIdWorkerException(String message){
        super(message);
    }
}
