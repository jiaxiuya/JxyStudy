package com.jxy.designpattern.interpreter.test2;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2016/11/16 11:14]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ActionNode extends AbstractNode {

    private String action;

    public ActionNode(String action) {
        this.action = action;
    }

    //动作（移动方式）表达式的解释操作
    @Override
    public String interpret() {
        if (action.equalsIgnoreCase("move")) {
            return "移动";
        }
        else if (action.equalsIgnoreCase("run")) {
            return "快速移动";
        }
        else {
            return "无效指令";
        }
    }
}
