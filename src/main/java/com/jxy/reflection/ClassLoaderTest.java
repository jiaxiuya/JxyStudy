package com.jxy.reflection;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2015/10/19 14:00]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {

        // 获得系统默认的ClassLoader
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        // 获得指定类的ClassLoader
        ClassLoader classClassLoader = ClassLoaderTest.class.getClassLoader();

        // loadClass
        Class<?> aClass = classClassLoader.loadClass("com.jxy.reflection.StringTest");

        Class.forName("com.jxy.reflection.StringTest", true, classLoader);

    }
}
