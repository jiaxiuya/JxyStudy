package com.jxy.designpattern.builder;

import com.jxy.designpattern.util.XMLUtil;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2015/10/19 14:00]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class BuilderClient {
    public static void main(String args[]) {
        PlayerBuilder playerBuilder; //针对抽象建造者编程
        playerBuilder = (PlayerBuilder) XMLUtil.getBean(); //反射生成具体建造者对象

        PlayerController playerController = new PlayerController();

        Player player = playerController.construct(playerBuilder); //通过指挥者创建完整的建造者对象

        System.out.println("主窗口名称：" + player.getMainFrameName());
        System.out.println("菜单名称：" + player.getMenuName());
        System.out.println("控制条名称：" + player.getControlStripName());
        System.out.println("播放列表：" + player.getPlayList());
    }
}
