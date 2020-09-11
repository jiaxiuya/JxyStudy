package com.jxy.designpattern.interpreter.test2;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2016/11/16 11:12]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class AndNode extends AbstractNode{

    private AbstractNode left; //And的左表达式
    private AbstractNode right; //And的右表达式

    public AndNode(AbstractNode left, AbstractNode right) {
        this.left = left;
        this.right = right;
    }

    //And表达式解释操作
    @Override
    public String interpret() {
        return left.interpret() + "再" + right.interpret();
    }
}
