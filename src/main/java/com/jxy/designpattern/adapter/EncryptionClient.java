package com.jxy.designpattern.adapter;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2015/10/19 14:00]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class EncryptionClient {

    public static void main(String[] args) {
        EncryptionAdapter encryptionAdapter = new EncryptionAdapter();

        String email = "test@test.com";
        email = encryptionAdapter.encryptEmail(email);
        System.out.println(email);

        String word = "test";
        word = encryptionAdapter.encryptWord(word);
        System.out.println(word);

    }
}
