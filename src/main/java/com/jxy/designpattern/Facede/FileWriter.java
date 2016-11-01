package com.jxy.designpattern.Facede;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2015/10/19 14:00]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class FileWriter {

    public void write(String encryptStr, String fileNameDes) {
        System.out.println("保存密文，写入文件。");

        FileOutputStream fs = null;
        try {
            fs = new FileOutputStream(fileNameDes);
            byte[] str = encryptStr.getBytes();
            fs.write(str, 0, str.length);
            fs.flush();
            fs.close();
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在！");
        } catch (IOException e) {
            e.printStackTrace();

            System.out.println("文件操作错误！");
        }
    }
}
