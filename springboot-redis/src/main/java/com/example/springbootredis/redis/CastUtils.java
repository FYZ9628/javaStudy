package com.example.springbootredis.redis;

import java.util.ArrayList;
import java.util.List;

/**
 * 转换工具
 */
public class CastUtils {

    //从缓存拿回来的是 Object ，我们需要编写一个方法把它转换为 List：
    public static <T> List<T> objectConvertToList(Object obj, Class<T> clazz) {
        List<T> result = new ArrayList<T>();
        if(obj instanceof List<?>)
        {
            for (Object o : (List<?>) obj)
            {
                result.add(clazz.cast(o));
            }
            return result;
        }
        return null;
    }
}
