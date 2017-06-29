package com.jxy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2017/4/10 17:01]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class test {
    public static void main(String[] args) {
        List<String> articles = new ArrayList<>();
        articles.add("123");
        articles.add("456");
        System.out.println(articles.stream()
                .filter(article -> article.contains("123"))
                .collect(Collectors.toList()).size());
    }
}
