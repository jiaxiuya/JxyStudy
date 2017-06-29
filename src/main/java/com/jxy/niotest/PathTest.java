package com.jxy.niotest;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2017/4/24 14:32]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class PathTest {
    public static void main(String[] args) {
        String originalPath =
                "d:\\data\\projects\\a-project\\..\\another-project";

        Path path1 = Paths.get(originalPath);
        System.out.println("path1 = " + path1);

        Path path2 = path1.normalize();
        System.out.println("path2 = " + path2);
    }
}
