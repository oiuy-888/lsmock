package com.example.lsmock.utils;

import lombok.Data;
import java.io.Serializable;

@Data
public class Result implements Serializable{

    public static final Integer Success = 20000;
    public static final Integer Error = 50000;
    public static final String SuccessMsg = "调用成功";
    public static final String ErrorMsg = "调用失败";
    public static final String ExitMsg = "数据已存在";

    private Integer code;
    private String message;
    private Object data;

    public Result(Integer code, String message, Object data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(Integer code, String message){
        this.code = code;
        this.message = message;
        this.data = null;
    }

    public Result(Object data){
        this.data = data;
        this.code = Success;
        this.message = SuccessMsg;
    }


}
