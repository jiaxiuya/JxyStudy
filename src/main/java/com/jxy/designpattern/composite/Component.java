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
public abstract class Component {

    public String name;

    public abstract String getName();

    public abstract void setName(String name);

    public abstract List<Component> add(Component component);

    public abstract void del(Component component);

    public abstract Component getChild(int i);

    public abstract void paint();

}
