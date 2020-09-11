package com.jxy.designpattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2016/11/14 9:58]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Menu {
    private List<MenuItem> menuItems = new ArrayList<>();

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public void display() {
        menuItems.forEach(MenuItem::click);
    }
}
