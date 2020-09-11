package com.jxy.jdk8.defaultfunction;

/**
 * <接口中允许出现默认方法，但是不可以用默认方法来重载equals，hashCode，toString方法>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2016/11/30 17:16]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface TestDefaultFunction {

    default void functionA() {
        System.out.println("我是默认方法");
    }
}
