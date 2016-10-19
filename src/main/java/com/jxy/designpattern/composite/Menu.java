package com.jxy.designpattern.composite;

import java.util.List;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2015/10/19 14:00]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Menu extends Component {

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<Component> add(Component component) {
        throw new RuntimeException("Menu菜单不支持该方法");
    }

    @Override
    public void del(Component component) {
        throw new RuntimeException("Menu菜单不支持该方法");
    }

    @Override
    public Component getChild(int i) {
        throw new RuntimeException("Menu菜单不支持该方法");
    }

    @Override
    public void paint() {
        System.out.println("画一个Menu菜单,名字叫 " + name);
    }
}
