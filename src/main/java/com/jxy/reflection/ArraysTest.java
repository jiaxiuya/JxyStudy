package com.jxy.reflection;

import java.lang.reflect.Array;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2015/10/19 14:00]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ArraysTest {

    public static void main(String[] args) {
        // using the Array class it is possible to create new arrays passing the type and the length via reflection
        String[] strArrayOne = (String[]) Array.newInstance(String.class, 10);

        // it contains utility methods for setting values
        Array.set(strArrayOne, 0, "member0");
        Array.set(strArrayOne, 1, "member1");
        Array.set(strArrayOne, 9, "member9");

        // and for getting values as well
        System.out.println("strArrayOne[0] : " + Array.get(strArrayOne, 0));
        System.out.println("strArrayOne[1] : " + Array.get(strArrayOne, 1));
        System.out.println("strArrayOne[3] (not initialized) : " + Array.get(strArrayOne, 3));
        System.out.println("strArrayOne[9] : " + Array.get(strArrayOne, 9));

        // also methods to retrieve the lenght of the array
        System.out.println("lenght strArrayOne: " + Array.getLength(strArrayOne));

        // primitive types work as well
        int[] intArrayOne = (int[]) Array.newInstance(int.class, 10);

        Array.set(intArrayOne, 0, 1);
        Array.set(intArrayOne, 1, 2);
        Array.set(intArrayOne, 9, 10);

        // and specific getters and setters for primitive types
        for (int i = 0; i < Array.getLength(intArrayOne); ++i) {
            System.out.println("intArrayOne[" + i + "] : " + Array.getInt(intArrayOne, i));
        }
    }
}
