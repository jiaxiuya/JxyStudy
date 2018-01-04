package com.jxy.jdk8.lambda.exercise;

import java.io.File;
import java.util.Arrays;

/**
 * Info
 *
 * @author xiuya.jxy
 * @date 2017/12/27
 * @since 2017/12/27
 */
public class ListFilesTest {

    public static void main(String[] args) {

        File file = new File("/Users/jiaxiuya/Documents");
        String[] list = file.list((File dir, String name) -> name.endsWith(".jpeg"));
        System.out.println(Arrays.toString(list));

        File file1 = new File("/Users/jiaxiuya/Documents");
        File[] files = file1.listFiles(File::isDirectory);
        System.out.println(Arrays.toString(files));

        File[] files2 = new File("/Users/jiaxiuya/Documents").listFiles();
        Arrays.sort(files2, (first, second) -> {
            if (first.isDirectory() && second.isDirectory() || first.isFile() && second.isFile()) {
                return first.getPath().compareTo(second.getPath());
            } else {
                if (first.isDirectory()) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        System.out.println(Arrays.toString(files2));
    }
}
