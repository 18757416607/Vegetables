package com.vegetables.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Mloong on 2018/11/5.
 * Jackson json工具类
 */
public class JacksonUtils {

    private static ObjectMapper MAPPER = new ObjectMapper();


    /**
     * 字符串 换 Map
     * @param paramStr
     * @return
     * @throws IOException
     */
    public static Map<String,Object> strToMap(String paramStr) throws IOException {
        return MAPPER.readValue(paramStr,Map.class);
    }

}
