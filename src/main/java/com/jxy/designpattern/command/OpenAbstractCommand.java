package com.jxy.designpattern.command;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2016/11/14 9:44]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class OpenAbstractCommand extends AbstractCommand {
    BoardScreen boardScreen = new BoardScreen();

    @Override
    public void execute() {
        boardScreen.open();
    }
}
