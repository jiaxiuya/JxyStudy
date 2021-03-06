package com.jxy.reflection;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2015/10/19 14:00]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class StringTest {

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {

        String stringer = "this is a String called stringer";

        Class<? extends String> stringGetClass = stringer.getClass();

        Class<String> stringclass = String.class;

        Field[] fields = stringclass.getDeclaredFields();

        for (Field field : fields) {
            System.out.println("*************************");
            System.out.println("Name: " + field.getName());
            System.out.println("Type: " + field.getType());

            // values
            if (field.isAccessible()) {
                System.out.println("Get: " + field.get(stringer));
                // depending on the type we can access the fields using these methods
                // System.out.println( "Get boolean: " + field.getBoolean( stringer ) );
                // System.out.println( "Get short: " + field.getShort( stringer ) );
                // ...
            }
            System.out.println("Modifiers:" + field.getModifiers());
            System.out.println("isAccesible: " + field.isAccessible());

        }

        // stringclass.getField( "hashCode" );//exception
        Field fieldHashCode = stringclass.getDeclaredField("hash");// all fields can be
        // accessed this way
        // fieldHashCode.get( stringer ); // this produces an java.lang.IllegalAccessException
        // we change the visibility
        fieldHashCode.setAccessible(true);

        // and we can access it
        Object value = fieldHashCode.get(stringer);
        int valueInt = fieldHashCode.getInt(stringer);
        System.out.println(value);

        System.out.println(valueInt);

    }
}
