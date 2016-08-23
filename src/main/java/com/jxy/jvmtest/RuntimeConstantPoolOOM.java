package jxy.jvmtest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiaxiuya
 * VM Args:-XX:PermSize10M  -XX:MaxPermSize10M
 *
 * @Date 2016/5/11 21:01.
 * @Version nothing
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        //适用List保持着常量池的引用，避免FULL GC回收常量池的行为
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
