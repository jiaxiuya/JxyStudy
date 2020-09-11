package com.jxy.designpattern.interpreter.test1;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2016/11/16 11:04]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class LoopCommandNode extends Node{
    private int number; //循环次数
    private Node commandNode; //循环语句中的表达式

    //解释循环命令
    @Override
    public void interpret(Context context) {
        context.skipToken("LOOP");
        number = context.currentNumber();
        context.nextToken();
        commandNode = new ExpressionNode(); //循环语句中的表达式
        commandNode.interpret(context);
    }

    @Override
    public void execute() {
        for (int i=0;i<number;i++)
            commandNode.execute();
    }
}
