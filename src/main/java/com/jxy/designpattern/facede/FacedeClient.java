package com.jxy.designpattern.facede;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2015/10/19 14:00]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class FacedeClient {
    static void Main(String[] args) {

        EncryptFacade ef = new EncryptFacade();

        ef.FileEncrypt("src.txt", "des.txt");

    }
}
