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
public class ReverseEncryptDecorator extends ComponentDecorator {

    public ReverseEncryptDecorator(EncryptComponent encryptComponent) {
        super(encryptComponent);
    }

    @Override
    public String baseEncrypt(String str) {

        return super.baseEncrypt(reverseEncrypt(str));
    }

    public String reverseEncrypt(String str) {
        System.out.println("对字符串进行逆向加密");
        return str;
    }
}
