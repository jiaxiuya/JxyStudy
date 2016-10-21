package com.jxy.reflection;

import java.lang.reflect.Field;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2015/10/19 14:00]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public enum EnumTest {
    ONE, TWO, THREE;

    public static void main(String[] args) {
        Field[] declaredFields = ONE.getClass().getDeclaredFields();

        for (Field f : declaredFields) {
            // check for each field if it is an enum constant or not
            System.out.println(f.getName() + " " + f.isEnumConstant());
        }

    }

}
