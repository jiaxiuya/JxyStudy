package com.jxy.spring.controlleradvice;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2017/7/20 15:06]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class DemoObj {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DemoObj{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
