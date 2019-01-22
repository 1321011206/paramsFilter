package com.monkey.paramsfilter.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @description: 去除请求参数中的首尾空格
 * @author: JJC
 * @createTime: 2019/1/22
 */
public class StringJsonUtils {
    /**
     * jsonstring 转换成map
     * @param jsonString
     * @return
     * @throws Exception
     */
    public static Map<String, Object> jsonStringToMap(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<>();
        try {
            map = mapper.readValue(jsonString,
                    new TypeReference<HashMap<String, Object>>() {
                    });
            Set<String> set = map.keySet();
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                String key = (String) it.next();
                map.put(key, map.get(key).toString().trim());
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}

