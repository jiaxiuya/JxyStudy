package com.jxy.reflection;

import java.util.*;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2015/10/19 14:00]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class CollectionsTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");

        reflectionCollections(map);
        reflectionCollections(map.keySet());
        reflectionCollections(map.values());

        List<String> list = new ArrayList<String>();
        list.add("10");
        list.add("20");
        list.add("30");
        list.add("40");

        reflectionCollections(list);
        reflectionCollections("this is an string");
    }

    private static void reflectionCollections(Object ref) {
        //check is collection
        if (ref instanceof Collection) {
            System.out.println("A collection:  " + ref.getClass().getName());
            @SuppressWarnings("rawtypes")
            // not nice
                    Iterator items = ((Collection) ref).iterator();
            while (items != null && items.hasNext()) {
                Object item = items.next();
                System.out.println("Element of the collection:  " + item.getClass().getName());
            }
        } else {

            System.out.println("Not a collection:  " + ref.getClass().getName());
        }
    }
}
