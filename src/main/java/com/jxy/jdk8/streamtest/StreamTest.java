package com.jxy.jdk8.streamtest;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2017/6/27 16:46]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class StreamTest {
    private static void useStream() throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("D:\\workspace\\JxyStudy\\src\\main\\java\\com\\jxy\\jdk8\\streamtest\\test.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("\\r\\n"));
        long count = words.stream().filter(w -> w.length() > 5).count();
        System.out.println(count);
    }

    private static void createStream() {
        String[] contents = {"1", "2", "3"};
        Stream<String> words = Stream.of(contents);

        // 创建空的Stream
        Stream<String> stringStream = Stream.empty();

        // 创建带有常亮值的Stream
        Stream<String> stringStream1 = Stream.generate(() -> "echo");
        Stream<Double> stringStream2 = Stream.generate(Math::random);

        // 创建无限序列
        Stream<BigInteger> bigIntegerStream = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));

        // 通过正则表达式创建Stream
        String charSequences = "123123123";
        Stream<String> stringStream3 = Pattern.compile("[\\P{L}]").splitAsStream(charSequences);

        // 通过try-with-resource保证文件正常关闭
        try (Stream<String> lines = Files.lines(Paths.get("D:\\workspace\\JxyStudy\\src\\main\\java\\com\\jxy\\jdk8\\streamtest\\test.txt"))) {
            System.out.println(lines.count());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * map使用方法
     */
    private static void mapTest() {
        // 使用map改变流的内容
        List<String> wordList = new ArrayList<String>(Arrays.asList("sadf", "fhfd", "kckcc"));
        Stream<String> stream = wordList.stream();
        stream = stream.map(String::toUpperCase);
        Iterator<String> iterator = stream.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 嵌套的流
        stream = wordList.stream();
        Stream<Stream<Character>> result = stream.map(StreamTest::characterStream);

        // 展开嵌套流的结果
        stream = wordList.stream();
        Stream<Character> result1 = stream.flatMap(StreamTest::characterStream);
    }

    private static Stream<Character> characterStream(String s) {
        List<Character> result = new ArrayList<>();
        for (char c : s.toCharArray()) {
            result.add(c);
        }
        return result.stream();
    }


    /**
     * 裁剪指定长度的流
     */
    private static void limitSkipConcatPeekTest() throws IOException {
        // 生成100个随机数
        Stream<Double> stream = Stream.generate(Math::random).limit(10);
        Iterator<Double> iterator = stream.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // 跳过N个流数据
        String contents = new String(Files.readAllBytes(Paths.get("D:\\workspace\\JxyStudy\\src\\main\\java\\com\\jxy\\jdk8\\streamtest\\test.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("\\r\\n"));
        long count = words.stream().skip(1).count();
        System.out.println("跳过了一个流 " + count);

        // 连接两个流，第一个不能是无限流，这样会导致第二个流连接不上
        Stream<Character> combined = Stream.concat(characterStream("Hello"), characterStream("Word"));

        // 使用Peek获得一个和原始流具有相同元素的流，但是在每次获取元素时，都会执行自定义的动作
        Object[] powers = Stream.iterate(1.0, p -> p * 2).peek(e -> System.out.println("Fetching " + e)).limit(20).toArray();
    }

    /**
     * 有状态的方法的测试
     */
    private static void hasStateTest() {
        // 去重
        Stream<String> uniqueWords = Stream.of("You", "Are", "Me", "Me", "Me").distinct();
        Iterator<String> iterator = uniqueWords.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // 排序
        Stream<String> sortedStream = Stream.of("Are", "You", "OK", "?").sorted(Comparator.comparing(String::length));
        Iterator<String> iterator1 = sortedStream.iterator();
        while (iterator1.hasNext()) {
            System.out.print(iterator1.next() + " ");
        }
        System.out.println();

        // 获取最大值
        Optional<String> max = Stream.of("You", "Are", "OK", "", "To").max(String::compareToIgnoreCase);
        max.ifPresent(System.out::println);

        // 查找首次出现
        Optional<String> first = Stream.of("You", "Are", "OK", "OO", "To").filter(s -> s.startsWith("O")).findFirst();
        first.ifPresent(System.out::println);

        // 并行查找的时候，只要匹配到第一个就终止
        Optional<String> any = Stream.of("You", "Are", "OK", "OO", "To").parallel().filter(s -> s.startsWith("O")).findAny();
        any.ifPresent(System.out::println);

        // 匹配元素，还有allMatch，noneMatch
        Boolean isTrue = Stream.of("You", "Are", "OK", "OO", "To").parallel().anyMatch(s -> s.startsWith("O"));
        System.out.println(isTrue);
    }

    /**
     * optional测试
     */
    private static void optionalTest() throws NoSuchMethodException {
        Optional<String> optional = Optional.of("test");
        optional.map(String::toUpperCase);
        System.out.println(optional);

        // 当为空的时候获得一个默认值
        String orElse = optional.orElse("");
        System.out.println(orElse);

        // 计算默认值
        optional.orElseGet(() -> System.getProperty("user.dir"));
        System.out.println(optional.get());

        // 空的时候抛出异常
        optional.orElseThrow(NoSuchMethodException::new);
    }


    public static void main(String[] args) throws IOException, NoSuchMethodException {
        optionalTest();
    }
}
