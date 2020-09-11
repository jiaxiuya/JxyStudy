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
public class EncryptionAdapter implements EncryptionOperationInterface {

    private EmailEncryptionAlgorithm emailEncryptionAlgorithm;

    private WordEncryptionAlgorithm wordEncryptionAlgorithm;


    public EncryptionAdapter() {
        emailEncryptionAlgorithm = new EmailEncryptionAlgorithm();
        wordEncryptionAlgorithm = new WordEncryptionAlgorithm();
    }

    @Override
    public String encryptEmail(String emailStr) {
        return emailEncryptionAlgorithm.encrypt(emailStr);

    }

    @Override
    public String encryptWord(String wordStr) {
        return wordEncryptionAlgorithm.encrypt(wordStr);
    }
}
