package com.jxy;

/*
请用JAVA代码完成以下功能，要求使用多线程
cat /home/admin/logs/*.log | "Login" | uniq -c | sort -nr

时间：1小时
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;

class myCode {

    public static void main(String[] args) throws Exception {

        File file = new File("/home/admin/logs/");

        if (file.isDirectory()) {
            ExecutorService executorService = Executors.newCachedThreadPool();
            List<Future<List<String>>> resultList = new ArrayList<>();
            List<List<String>> result = new ArrayList<>();

            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].getPath().endsWith(".log")) {
                    //使用ExecutorService执行Callable类型的任务，并将结果保存在future变量中
                    Future<List<String>> future = executorService.submit(new TaskWithResult(files[i]));
                    //将任务执行结果存储到List中
                    resultList.add(future);
                }
            }

            //遍历任务的结果
            for (Future<List<String>> fs : resultList) {
                try {
                    // Future返回如果没有完成，则一直循环等待，直到Future返回完成
                    while (!fs.isDone()) ;
                    result.add(fs.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                } finally {
                    // 启动一次顺序关闭，执行以前提交的任务，但不接受新任务
                    executorService.shutdown();
                }
            }

            Map<String, Integer> stringMap = new ConcurrentHashMap<>();
            // 将结果去重
            for (int i = 0; i < result.size(); i++) {
                List<String> strings = result.get(i);
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        for (int j = 0; j < strings.size(); j++) {
                            String str = strings.get(j);
                            if (stringMap.containsKey(str)) {
                                stringMap.put(str, stringMap.get(str) + 1);
                            } else {
                                stringMap.put(str, 1);
                            }
                        }
                    }
                });
            }
            executorService.shutdown();

            // 从小到大排序
            List<Map.Entry<String, Integer>> list = new ArrayList<>(stringMap.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                //升序排序
                public int compare(Map.Entry<String, Integer> o1,
                                   Map.Entry<String, Integer> o2) {
                    return o1.getKey().compareTo(o2.getKey());
                }

            });

            // 遍历输出
            for (Map.Entry<String, Integer> mapping : list) {
                System.out.println(mapping.getValue() + "   " + mapping.getKey());
            }

        }
    }
}

class TaskWithResult implements Callable<List<String>> {

    private File file;

    TaskWithResult(File file) {
        this.file = file;
    }

    @Override
    public List<String> call() throws Exception {
        BufferedReader reader = null;
        List<String> strings = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 读取含有content的行号
                if (tempString.contains("Login")) {
                    strings.add(tempString);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return strings;
    }
}