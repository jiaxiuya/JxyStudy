package com.jxy.designpattern.composite;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2015/10/19 14:00]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class CompositeClient {
    public static void main(String[] args) {
        Component button = new Button();
        button.setName("确认按钮");
        Component text = new Text();
        text.setName("输入你的名字吧");
        Component menu = new Menu();
        menu.setName("关于菜单");

        Component frame = new Frame();
        frame.add(button);
        frame.add(text);
        frame.add(menu);

        Component window = new Frame();
        Component wMenu = new Menu();
        wMenu.setName("窗口菜单");
        window.add(wMenu);
        window.add(frame);

        window.paint();

    }
}
