package com.jxy.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
public class MethodsTest {
    public static void main(String[] args) {
        Class<String> stringclass = String.class;
        String test = "kkk";
        Method[] methods = stringclass.getMethods();

        // All methods for the String class
        for (Method method : methods) {

            try {
                // 通过反射执行方法
                if ("equals".equals(method.getName())) {
                    System.out.println(method.invoke(test, "kkk"));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            System.out.println("****************************************************");
            System.out.println("name: " + method.getName());
            System.out.println("defaultValue: " + method.getDefaultValue());

            System.out.println("generic return type: " + method.getGenericReturnType());
            System.out.println("return type: " + method.getReturnType());

            System.out.println("modifiers: " + method.getModifiers());

            // Parameters
            Parameter[] parameters = method.getParameters();
            System.out.println(parameters.length + " parameters:");
            // also method.getParameterCount() is possible
            for (Parameter parameter : parameters) {
                System.out.println("parameter name: " + parameter.getName());
                System.out.println("parameter type: " + parameter.getType());
            }
            Class<?>[] parameterTypes = method.getParameterTypes();
            System.out.println(parameterTypes.length + " parameters:");
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("parameter type name: " + parameterType.getName());
            }

            // Exceptions
            Class<?>[] exceptionTypes = method.getExceptionTypes();
            System.out.println(exceptionTypes.length + " exception types: ");
            for (Class<?> exceptionType : exceptionTypes) {
                System.out.println("exception name " + exceptionType.getName());
            }

            System.out.println("is accesible: " + method.isAccessible());
            System.out.println("is varArgs: " + method.isVarArgs());

        }
    }
}
