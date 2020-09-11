package com.jxy.designpattern.abstractfactory;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2015/10/19 14:00]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class MobileOperationControllerFactory implements MobileControllerFactory {
    @Override
    public SymbianController createSymbian() {
        return new SymbianOperationController();
    }

    @Override
    public AndroidController createAndroid() {
        return new AndroidOperationController();
    }

    @Override
    public IPhoneController createIPhone() {
        return new IPhoneOperationController();
    }
}
