package com.jxy.designpattern.mediator;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2016/11/17 15:30]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ConcreteMediator extends Mediator {

    public TextPane textPane;
    public ListPane listPane;
    public GraphicPane graphicPane;

    @Override
    void componentChanged(Component component) {
        if (component == textPane) {
            graphicPane.update();
        } else if (component == listPane) {
            graphicPane.update();
        } else if(component == graphicPane){
            textPane.update();
            listPane.update();
        }
    }
}
