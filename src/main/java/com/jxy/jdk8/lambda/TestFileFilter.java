package com.jxy.jdk8.lambda;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2017/6/26 16:10]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class TestFileFilter {
    public static void main(String[] args) {
        File file = new File("D:\\project svn\\battle\\文档\\20工程\\20.20需求");

        File[] files = file.listFiles(File::isDirectory);

        System.out.println(files.length);

        // 找出有指定扩展名的文件
        File file2 = new File("D:\\project svn\\battle\\文档\\20工程\\20.20需求");

        File[] files2 = file.listFiles(pathName -> pathName.getPath().endsWith(".xlsx"));

        System.out.println(files2.length);

        // 对File数组进行排序
        File file3 = new File("D:\\project svn\\battle\\文档\\20工程\\20.20需求");
        File[] files3 = file3.listFiles();
//        Arrays.sort(files3, Comparator.comparing(File::getPath));
        Arrays.sort(files3, (o1, o2) -> {
            String path1 = o1.getPath();
            path1 = o1.getPath().substring(path1.lastIndexOf("\\"), path1.length());
            String path2 = o2.getPath();
            path2 = o2.getPath().substring(path2.lastIndexOf("\\"), path2.length());
            return path2.compareTo(path1);
        });
        System.out.println(files3[0]);

    }
}
