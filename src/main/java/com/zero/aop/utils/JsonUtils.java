package com.zero.aop.utils;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zero.aop.core.AopBeanDefinition;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

public final class JsonUtils {

    private static Gson gson = new Gson();
    private static Type aopBeanDefinitionListType = new TypeToken<List<AopBeanDefinition>>() {
    }.getType();

    private JsonUtils() {
    }

    public static List<AopBeanDefinition> jsonToAopBeanDefinition(InputStream is) throws IOException {
        return jsonToType(is, aopBeanDefinitionListType);
    }

    public static List<AopBeanDefinition> jsonToType(InputStream is, Type type) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(is);
        char[] buf = new char[1024];
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (true) {
            count = inputStreamReader.read(buf);
            if (count < 0) {
                break;
            }
            sb.append(new String(buf, 0, count));
        }
        return jsonToBeanDefinition(sb.toString(), type);
    }

    public static List<AopBeanDefinition> jsonToBeanDefinition(String json, Type type) {
        return gson.fromJson(json, type);
    }
}
