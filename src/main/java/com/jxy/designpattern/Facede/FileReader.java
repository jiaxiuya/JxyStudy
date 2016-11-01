package com.jxy.designpattern.Facede;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
public class FileReader {

    public String read(String fileNameSrc) {
        FileInputStream fs = null;
        StringBuilder sb = new StringBuilder();
        try {
            fs = new FileInputStream(fileNameSrc);
            int data;
            while ((data = fs.read()) != -1) {
                sb = sb.append((char) data);
            }
            fs.close();
            System.out.println(sb);
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在");
        } catch (IOException e) {
            System.out.println("文件操作错误");
        }
        return sb.toString();
    }
}
