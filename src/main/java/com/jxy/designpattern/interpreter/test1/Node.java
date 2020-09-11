package com.jxy.designpattern.interpreter.test1;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2016/11/16 11:01]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public abstract class Node {
    public abstract void interpret(Context text); //声明一个方法用于解释语句

    public abstract void execute(); //声明一个方法用于执行标记对应的命令
}
