package com.jxy.designpattern.mediator;

/**
 * <抽象中介类>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2016/11/17 15:29]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public abstract class Mediator {
    abstract void componentChanged(Component component);
}
