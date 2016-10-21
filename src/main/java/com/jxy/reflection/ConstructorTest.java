package com.jxy.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2015/10/19 14:00]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ConstructorTest {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<String> stringGetClass = String.class;
        Constructor<?>[] constructors = stringGetClass.getConstructors();

        for (Constructor<?> constructor : constructors) {
            int numberParams = constructor.getParameterCount();
            System.out.println("constructor " + constructor.getName());
            System.out.println("number of arguments " + numberParams);
            // public, private, etc.
            int modifiersConstructor = constructor.getModifiers();
            System.out.println("modifiers " + modifiersConstructor);
            // array of parameters, more info in the methods section
            Parameter[] parameters = constructor.getParameters();
            if (parameters.length == 1 && parameters[0].getType().isAssignableFrom(String.class)) {
                // 如果为没有参数的构造函数，利用反射创建一个String对象
                String testCreate = (String) constructor.newInstance("kbs");
                System.out.println(testCreate);
            }
            // annotations array, more info in the annotations section
            Annotation[] annotations = constructor.getAnnotations();
            System.out.println("=============================");
        }
    }
}