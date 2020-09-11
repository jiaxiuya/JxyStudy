package com.jxy.designpattern.composite;

import java.util.ArrayList;
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
public class Frame extends Component {

    private List<Component> componentList = new ArrayList<>();

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
        componentList.add(component);
        return componentList;
    }

    @Override
    public void del(Component component) {
        componentList.remove(component);
    }

    @Override
    public Component getChild(int i) {
        return componentList.get(i);
    }

    @Override
    public void paint() {
        for (Component aComponentList : componentList) {
            aComponentList.paint();
        }
    }
}
