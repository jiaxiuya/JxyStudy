package com.jxy.designpattern.iterator;

import java.util.List;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2016/11/16 14:39]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ProductList extends AbstractObjectList {

    public ProductList(List products) {
        super(products);
    }

    //实现创建迭代器对象的具体工厂方法
    public AbstractIterator createIterator() {
        return new ProductIterator(this);
    }
}
