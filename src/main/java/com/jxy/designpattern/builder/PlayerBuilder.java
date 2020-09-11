package com.jxy.designpattern.builder;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2015/10/19 14:00]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public abstract class PlayerBuilder {

    protected Player player = new Player();

    public abstract void buildMenuName();

    public abstract void buildPlayList();

    public abstract void buildMainFrameName();

    public abstract void buildControlStripName();

    public boolean isMenuName() {
        return true;
    }

    public boolean isPlayList() {
        return true;
    }

    public boolean isMainFrameName() {
        return true;
    }

    public boolean isControlStripName() {
        return true;
    }

    public Player createPlayer() {
        return player;
    }
}
