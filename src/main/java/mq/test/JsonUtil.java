package mq.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class JsonUtil {

    public static String bean2Json(Object bean) {
        if(bean == null){
            return null;
        }
        //WriteMapNullValue——–是否输出值为null的字段,默认为false
        return JSON.toJSONString(bean, SerializerFeature.WriteMapNullValue);
    }

    public static <T> T json2Bean(String json, Class<T> clazz) {
        if(StringUtils.isEmpty(json)){
            return null;
        }
        return JSON.parseObject(json, clazz);
    }

    public static <T> List<T> json2List(String json, Class<T> clazz) {
        if(StringUtils.isEmpty(json)){
            return null;
        }
        return JSON.parseArray(json, clazz);
    }

}
