package com.jxy.jdk8.defaultfunction;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2016/11/30 17:21]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class TestDefaultFunctionImpl implements TestDefaultFunction {

    public void functionB() {
        functionA();
    }

    public static void main(String[] args) {
        new TestDefaultFunctionImpl().functionB();
    }
}
