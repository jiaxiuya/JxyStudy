package com.jxy.designpattern.Bridge;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2015/10/19 14:00]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public abstract class DataFormat {

    protected DatabaseReadInterface databaseReadInterface;

    /**
     * 设置读取数据库的类
     *
     * @param databaseReadInterface
     */
    public void setDatabaseReadInterface(DatabaseReadInterface databaseReadInterface) {
        this.databaseReadInterface = databaseReadInterface;
    }

    /**
     * 转换数据
     */
    public abstract void transformData();

}
