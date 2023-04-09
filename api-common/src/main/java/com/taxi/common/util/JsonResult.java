package com.taxi.common.util;

import com.taxi.common.api_enum.ResponseStatusEnum;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;

@Data
@Accessors(chain = true)
public class JsonResult {

    private int code;
    private String message;
    private Object data;

    public static JsonResult tip(){
        return new JsonResult().setCode(ResponseStatusEnum.TIP.getCode()).setMessage(ResponseStatusEnum.TIP.getMessage());
    }

    public static JsonResult tip(Object obj){
        return tip().setData(obj);
    }

    public static JsonResult success(){
        return new JsonResult().setCode(ResponseStatusEnum.SUCCESS.getCode()).setMessage(ResponseStatusEnum.SUCCESS.getMessage());
    }

    public static JsonResult success(Object obj){
        return success().setData(obj);
    }

    /**
     * WARNING 该方法会清空原有值
     * @param key
     * @param obj
     * @return
     */
    public JsonResult put(String key, Object obj){
        if(key==null&&!key.equals("")){
            throw new NullPointerException("key值不能为空");
        }
        Map<String,Object> map = null;
        Object data = this.getData();
        if(data instanceof HashMap){
            map = (HashMap<String,Object>)data;
            map.put(key,obj);
        }else{
            map = new HashMap<>();
            map.put(key,obj);
            if(data!=null&&!data.equals("")){
                map.put("value",data);
            }
        }
        this.setData(map);
        return this;
    }

    public static JsonResult fail(){
       return new JsonResult().setCode(ResponseStatusEnum.FAIL.getCode()).setMessage(ResponseStatusEnum.FAIL.getMessage());
    }

    public static JsonResult fail(Object obj){
        return fail().setData(obj);
    }

    public static JsonResult error(){
        return new JsonResult().setCode(ResponseStatusEnum.ERROR.getCode()).setMessage(ResponseStatusEnum.ERROR.getMessage());
    }

    public static JsonResult error(Object obj){
        return error().setData(obj);
    }
}
