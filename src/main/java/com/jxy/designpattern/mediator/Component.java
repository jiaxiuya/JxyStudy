package com.jxy.designpattern.mediator;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2016/11/17 14:37]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public abstract class Component {

    protected Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void change() {
        mediator.componentChanged(this);
    }

    abstract void update();

}
