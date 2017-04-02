package com.sanweibook.jhook.common.result;

import lombok.Data;

/**
 * Created by twg on 17/3/23.
 */
@Data
public final class Result<T> {
    private String code;
    private boolean success;
    private String message;
    private T D;


    public static <T> Result<T> returnSuccessResult(String message){
        Result<T> result = new Result<T>();
        result.setCode("00000");
        result.setSuccess(true);
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> returnSuccessResult(T D,String message){
        Result<T> result = new Result<T>();
        result.setCode("00000");
        result.setD(D);
        result.setSuccess(true);
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> returnSuccessResult(T D){
        Result<T> result = new Result<T>();
        result.setCode("00000");
        result.setD(D);
        result.setSuccess(true);
        return result;
    }

    public static <T> Result<T> returnErrorResult(String code,String message){
        Result<T> result = new Result<T>();
        result.setCode(code);
        result.setSuccess(false);
        result.setMessage(message);
        return result;
    }
}
