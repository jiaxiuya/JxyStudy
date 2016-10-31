package com.jxy.designpattern.decorator;

/**
 * <抽象构建类>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2015/10/19 14:00]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public abstract class EncryptComponent {

    /**
     * 基础加密
     * @return
     */
    public abstract String baseEncrypt(String str);
}
