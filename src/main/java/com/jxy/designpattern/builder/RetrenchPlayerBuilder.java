package com.jxy.designpattern.builder;

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
public class RetrenchPlayerBuilder extends PlayerBuilder {

    @Override
    public void buildMenuName() {
        player.setMenuName("精简菜单");
    }

    @Override
    public void buildPlayList() {
        List<String> playList = new ArrayList<String>();
        playList.add("中国足球");
        playList.add("中国篮球");
        player.setPlayList(playList);
    }

    @Override
    public void buildMainFrameName() {
        player.setMainFrameName("精简的主窗口");

    }

    @Override
    public void buildControlStripName() {
        player.setControlStripName("精简的控制条");

    }

    @Override
    public boolean isMainFrameName() {
        return false;
    }

    @Override
    public boolean isControlStripName() {
        return false;
    }
}
