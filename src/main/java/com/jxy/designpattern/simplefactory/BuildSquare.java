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
public class BuildSquare {

    private static Shape shape;

    public static Shape buildSquare(String arg) {

        if ("circular".equals(arg)) {
            shape = new Circular();
        } else if ("square".equals(arg)) {
            shape = new Square();
        } else if ("triangle".equals(arg)) {
            shape = new Triangle();
        } else {
            throw new UnSupportedShapeException();
        }
        return shape;

    }
}
