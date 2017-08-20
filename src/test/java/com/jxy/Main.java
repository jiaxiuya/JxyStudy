package com.jxy;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String str = "北京 杭州 杭州 北京";
        // 输入匹配字符串
        while (true){
            System.out.println("请输入匹配字符串！");
            Scanner sc = new Scanner(System.in);
            String pattern = sc.nextLine();

            System.out.println(analyzeStr(str, pattern));
        }

    }


    /**
     * 分析字符串
     *
     * @param str
     * @param pattern
     * @return
     */
    private static boolean analyzeStr(String str, String pattern) {
        if (str == null || "".equals(str)) {
            return false;
        }

        // 切分字符串为数组
        String[] a = str.split(" ");
        if (a.length < 1) {
            return false;
        }

        String[] b = pattern.split("");

        if (a.length != b.length) {
            return false;
        }

        // 获得解析后的Map结构
        Map<Object, List<Integer>> map1 = toMap(a);
        Map<Object, List<Integer>> map2 = toMap(b);

        if (map1.size() != map2.size()) {
            return false;
        }

        Iterator<Map.Entry<Object, List<Integer>>> iterator1 = map1.entrySet().iterator();
        Iterator<Map.Entry<Object, List<Integer>>> iterator2 = map2.entrySet().iterator();

        for (int i = 0; i < map1.size(); i++) {
            List<Integer> value1 = iterator1.next().getValue();
            List<Integer> value2 = iterator2.next().getValue();
            if (!value1.containsAll(value2)) {
                return false;
            }

        }

        return true;
    }

    /**
     * 解析Map结构
     * @param a
     * @return
     */
    private static Map<Object, List<Integer>> toMap(Object[] a) {
        Map<Object, List<Integer>> map = new LinkedHashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])) {
                List<Integer> integers = map.get(a[i]);
                integers.add(i);
            } else {
                List<Integer> integers = new ArrayList<>();
                integers.add(i);
                map.put(a[i], integers);
            }
        }
        return map;
    }
}
