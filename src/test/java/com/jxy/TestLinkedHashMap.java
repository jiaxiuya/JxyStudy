package com.jxy;

import java.util.LinkedHashMap;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2017/5/17 16:11]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class TestLinkedHashMap {
    public static void main(String[] args) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>(10, 1.0f, true);
        linkedHashMap.put("123", "123");
        linkedHashMap.put("124j3", "123");
        linkedHashMap.put("125f3", "123");
        linkedHashMap.put("12r3", "123");
        linkedHashMap.put("123tr", "123");
        linkedHashMap.put("12f23g", "123");
        linkedHashMap.put("1h233", "123");

        linkedHashMap.get("125f3");
        linkedHashMap.get("1h233");
    }
}
