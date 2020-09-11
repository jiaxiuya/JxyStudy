package com.jxy;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2017/5/19 17:49]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class LRUCache {
    public static void main(String[] args) {
        final int cacheSize = 3;
        Map<String, String> map = new LinkedHashMap<String, String>((int) Math.ceil(cacheSize / 0.75f) + 1, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > cacheSize;
            }
        };

        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        map.get("1");
        map.put("4","4");
    }
}
