package com.jxy.designpattern.builder;

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
public class Player {
    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 播放列表
     */
    private List<String> playList;

    /**
     * 主窗口名称
     */
    private String mainFrameName;

    /**
     * 控制条名称
     */
    private String controlStripName;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public List<String> getPlayList() {
        return playList;
    }

    public void setPlayList(List<String> playList) {
        this.playList = playList;
    }

    public String getMainFrameName() {
        return mainFrameName;
    }

    public void setMainFrameName(String mainFrameName) {
        this.mainFrameName = mainFrameName;
    }

    public String getControlStripName() {
        return controlStripName;
    }

    public void setControlStripName(String controlStripName) {
        this.controlStripName = controlStripName;
    }
}
