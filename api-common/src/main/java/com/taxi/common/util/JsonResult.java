package com.taxi.common.util;

import com.taxi.common.api_enum.ResponseStatusEnum;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class JsonResult<T> {

    private int code;
    private String message;
    private Object data;

    public static JsonResult tip(){
        return new JsonResult().setCode(ResponseStatusEnum.TIP.getCode()).setMessage(ResponseStatusEnum.TIP.getMessage());
    }

    public static <T> JsonResult tip(T obj){
        return tip().setData(obj);
    }

    public static JsonResult success(){
        return new JsonResult().setCode(ResponseStatusEnum.SUCCESS.getCode()).setMessage(ResponseStatusEnum.SUCCESS.getMessage());
    }

    public static <T> JsonResult success(T obj){
        return success().setData(obj);
    }

    public static JsonResult fail(){
       return new JsonResult().setCode(ResponseStatusEnum.FAIL.getCode()).setMessage(ResponseStatusEnum.FAIL.getMessage());
    }

    public static <T> JsonResult fail(T obj){
        return fail().setData(obj);
    }

    public static JsonResult error(){
        return new JsonResult().setCode(ResponseStatusEnum.ERROR.getCode()).setMessage(ResponseStatusEnum.ERROR.getMessage());
    }

    public static <T> JsonResult error(T obj){
        return error().setData(obj);
    }



}
