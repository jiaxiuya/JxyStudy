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
public class RuntimeConstantPoolOOM2 {
    public static void main(String[] args) {
        String str1 = new StringBuilder("计算器").append("软件").toString();
        System.out.println(str1 == str1.intern());

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2 == str2.intern());
    }
}
