package com.example.demo.common.api;

public class CommonResult<T>{
    private long code;
    private  String message;
    private T data;

    protected CommonResult(){

    }

    protected CommonResult(long code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    //成功获取数据
    public static <T> CommonResult<T> success(T data){
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }
    //返回成功信息-提示信息
    public static <T>CommonResult<T> success(T data, String message){
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), message, data);
    }
    //返回失败信息-错误码
    public static <T>CommonResult<T> failed(IErrorCode errorCode) {
        return new CommonResult<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }
    //返回错误信息-提示信息
    public static <T>CommonResult<T> failed(String message){
        return new CommonResult<T>(ResultCode.FAILED.getCode(), message, null);
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
