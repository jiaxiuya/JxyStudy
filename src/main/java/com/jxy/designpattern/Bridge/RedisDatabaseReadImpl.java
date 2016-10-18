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
public class RedisDatabaseReadImpl implements DatabaseReadInterface {
    @Override
    public String readData() {
        System.out.println("读取Redis数据库数据！");
        return "Redis数据库数据";
    }
}
