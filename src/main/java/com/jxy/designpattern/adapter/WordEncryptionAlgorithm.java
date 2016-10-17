package com.jxy.designpattern.adapter;


/**
 * <适配者>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2015/10/19 14:00]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class WordEncryptionAlgorithm {

    public String encrypt(String wordStr) {
        System.out.println("加密口令！");
        return wordStr += "我加密过了";
    }
}
