package com.jxy.designpattern.factory;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2015/10/19 14:00]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Client {
    private static PictureFactory pictureFactory;
    private static Picture picture;

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class pictureFactoryClass = Class.forName("com.jxy.designpattern.factory.GIFPictureFactory");
        pictureFactory = (PictureFactory) pictureFactoryClass.newInstance();
        picture = pictureFactory.createPicture();
        picture.readPicture();
    }
}
