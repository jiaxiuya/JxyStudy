package com.jxy.designpattern.simplefactory;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2015/10/19 14:00]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("画个正方形");
    }

    @Override
    public void erase() {
        System.out.println("擦除正方形");
    }
}
