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
public class DecoratorClient {

    public static void main(String[] args) {

        EncryptComponent encryptComponent = new BaseEncrypt();

        ComponentDecorator componentDecorator1 = new ReverseEncryptDecorator(encryptComponent);

        ComponentDecorator componentDecorator2 = new ShiftEncryptDecorator(componentDecorator1);

        componentDecorator2.baseEncrypt("123");


    }
}
