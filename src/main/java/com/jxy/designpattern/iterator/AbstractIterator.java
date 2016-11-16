package com.jxy.designpattern.iterator;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2016/11/16 14:40]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface AbstractIterator {
    public void next(); //移至下一个元素

    public boolean isLast(); //判断是否为最后一个元素

    public void previous(); //移至上一个元素

    public boolean isFirst(); //判断是否为第一个元素

    public Object getNextItem(); //获取下一个元素

    public Object getPreviousItem(); //获取上一个元素
}
