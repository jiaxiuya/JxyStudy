package com.jxy.designpattern.decorator;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2015/10/19 14:00]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class BaseEncrypt extends EncryptComponent {

    @Override
    public String baseEncrypt(String str) {
        System.out.println("我是基础的求模加密");
        return str;
    }
}
