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
public class PrimitiveCommandNode extends Node {

    private String name;
    private String text;

    //解释基本命令
    @Override
    public void interpret(Context context) {
        name = context.currentToken();
        context.skipToken(name);
        if (!name.equals("PRINT") && !name.equals("BREAK") && !name.equals("SPACE")) {
            System.err.println("非法命令！");
        }
        if (name.equals("PRINT")) {
            text = context.currentToken();
            context.nextToken();
        }
    }

    @Override
    public void execute() {
        if (name.equals("PRINT"))
            System.out.print(text);
        else if (name.equals("SPACE"))
            System.out.print(" ");
        else if (name.equals("BREAK"))
            System.out.println();
    }
}
