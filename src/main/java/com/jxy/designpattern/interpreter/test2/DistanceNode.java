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
public class DistanceNode extends AbstractNode {

    private String distance;

    public DistanceNode(String distance) {
        this.distance = distance;
    }

    //距离表达式的解释操作
    @Override
    public String interpret() {
        return this.distance;
    }
}
