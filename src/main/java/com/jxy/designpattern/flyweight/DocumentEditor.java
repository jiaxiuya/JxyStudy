package com.jxy.designpattern.flyweight;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2015/10/19 14:00]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public abstract class DocumentEditor {

    abstract String getDocument();

    public void display(LocationSize locationSize) {
        System.out.println("显示文档，名称： " + this.getDocument() +
                " 位置： " + locationSize.getX() + "," + locationSize.getY() +
                " 大小： " + locationSize.getLength() + "," + locationSize.getWide());
    }
}
