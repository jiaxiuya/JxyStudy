package com.jxy.niotest.nettyserialize.msgpack;

import org.msgpack.annotation.Message;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2015/10/19 14:00]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Message
public class UserInfo {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
