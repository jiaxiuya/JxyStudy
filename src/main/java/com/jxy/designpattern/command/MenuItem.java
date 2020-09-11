package com.jxy.designpattern.command;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2016/11/14 9:56]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class MenuItem {
    private String name;
    private AbstractCommand abstractCommand;

    public void setName(String name) {
        this.name = name;
    }

    public void setAbstractCommand(AbstractCommand abstractCommand) {
        this.abstractCommand = abstractCommand;
    }

    public void click() {
        abstractCommand.execute();
    }
}
