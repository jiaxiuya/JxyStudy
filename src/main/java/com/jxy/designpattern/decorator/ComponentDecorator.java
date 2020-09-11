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
public class ComponentDecorator extends EncryptComponent {
    private EncryptComponent encryptComponent;

    public ComponentDecorator(EncryptComponent encryptComponent) {
        this.encryptComponent = encryptComponent;
    }

    @Override
    public String baseEncrypt(String str) {
        return encryptComponent.baseEncrypt(str);
    }
}
