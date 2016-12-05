package com.jxy.jdk8.lambda;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.*;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2016/12/1 10:23]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class TestLambda {


    /**
     * 例外的透明度，这样是不允许的,只运行在内部处理异常
     *
     * @param values
     * @param out
     */
    void appendAll(Iterable<String> values, Appendable out) { // doesn't help with the error
        values.forEach(s -> {
            // error: can't throw IOException here Consumer.accept(T) doesn't allow it
            try {
                out.append(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * 不允许修改捕获的变量
     */
    void nonFinal() {
        int count = 0;
        List<String> strings = Arrays.asList("a", "b", "c");
        strings.forEach(s -> {
            System.out.println(count);
            // error: can't modify the value of count
//            count++;

        });

    }


    final String secret = "foo";

    /**
     * 不可以中途break return
     *
     * @param values
     * @return
     */
    boolean containsSecret(Iterable<String> values) {
        values.forEach(s -> {
            if (secret.equals(s)) {
                // want to end the loop and return true, but can't
            }
        });
        return true;
    }

    static void forEachMap() {
        Map<String, String> m = new HashMap<>();
        m.put("1", "1");
        m.forEach((key, value) -> System.out.println(key + " " + value));
    }

    /**
     * 使用静态方法实现接口功能性接口
     */
    static void testStaticMethod() {
        IntUnaryOperator converter = Integer::valueOf;
        IntUnaryOperator converter2 = (operand) -> (operand);

        Integer converted = converter.applyAsInt(123);
        Integer converted2 = converter2.applyAsInt(321);
        System.out.println(converted);   // 123
        System.out.println(converted2);
    }

    static class Something {
        int startsWith(int s) {
            return s;
        }
    }

    /**
     * 使用::传递普通方法
     */
    static void testDoubleColon() {

        Something something = new Something();
        IntUnaryOperator converter = something::startsWith;
        int converted = converter.applyAsInt(11212);
        System.out.println(converted);
    }

    class Person {
        String firstName;
        String lastName;

        Person() {
        }

        Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }

    interface PersonFactory<P extends Person> {
        P create(String firstName, String lastName);
    }

    /**
     * 使用::调用构造函数
     */
    void testDoubleColonConstruct() {
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");
        System.out.println(person);
    }


    /**
     * Predicates是只拥有一个参数的Boolean型功能的接口。
     * 这个接口拥有多个默认方法用于构成predicates复杂的逻辑术语。
     */
    void predicatesInterface() {
        Predicate<String> predicate = (s) -> s.length() > 0;

        predicate.test("foo");              // true
        predicate.negate().test("foo");     // false

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();
    }

    /**
     * Functions接受一个参数并产生一个结果。默认方法能够用于将多个函数链接在一起。
     */
    void functionsInterface() {
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        backToString.apply("123");     // "123"
    }

    /**
     * Suppliers对于给定的泛型类型产生一个实例。不同于Functions，Suppliers不需要任何参数。
     */
    void supplierInterface() {
        Supplier<Person> personSupplier = Person::new;
        personSupplier.get();   // new Person
    }


    /**
     * Consumers代表在只有一个输入参数时操作被如何执行。
     */
    void consumerInterface() {
        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
        greeter.accept(new Person("Luke", "Skywalker"));
    }

    /**
     * Comparators在老版本中就已经被熟知。Java8向该接口中添加了多种默认方法。
     */
    void comparatorsInterface() {

        Comparator<Person> comparator = Comparator.comparing(p -> p.firstName);

        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");

        comparator.compare(p1, p2);             // > 0
        comparator.reversed().compare(p1, p2);  // < 0
    }

    /**
     * Optionals并不是功能性接口，反而它是一种特殊的工具用来阻止NullPointerException。
     */
    void optionalsInterface() {
        Optional<String> optional = Optional.of("bam");

        optional.isPresent();           // true
        optional.get();                 // "bam"
        optional.orElse("fallback");    // "bam"

        optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"
    }

    /**
     * java.util.Stream代表着一串你可以在其上进行多种操作的元素。
     * 流操作既可以是连续的也可以是中断的。中断操作返回操作结果。而连续操作返回流本身，这样你就可以在该行上继续操作。
     * 流是创建在数据源上的，例如：java.util.Collection、list集合和set集合。
     * 流操作既可以顺序执行也可以并行执行。
     */
    static void streamsInterface() {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        // Filter接受一个predicate来过滤流中的所有元素。这个操作是连续的，它可以让我们在结果上继续调用另外一个流操作forEach。
        // ForEach接受一个consumer，它被用来对过滤流中的每个元素执行操作。ForEach是一个中断操作，因此我们不能在ForEach后调用其他流操作。
        stringCollection.stream().filter((s) -> s.startsWith("a")).forEach(System.out::println);

        // Sorted是一个连续操作，它返回流的已排序版本。如果你没有显示的指定Comparator，那么流中元素的排序规则为默认的。
        stringCollection.stream().sorted().filter((s) -> s.startsWith("a")).forEach(System.out::println);

        // 需要注意的是sorted只创建了流的排序结果，它并没有改变集合中元素的排序位置。
        System.out.println(stringCollection);

        // 连续性操作map通过指定的Function将流中的每个元素转变为另外的对象。下面的示例将每个字符串转换为大写的字符串。
        // 此外，你也可以使用map将每个元素的类型改变为其它类型。转换后流的泛型类型依赖于你传入的Function的泛型类型。
        stringCollection.stream().map(String::toUpperCase).sorted(Comparator.reverseOrder()).forEach(System.out::println);

        // 各种匹配操作可以用来检测是否某种predicate和流中元素相匹配。所有的这些操作是中断的并返回一个boolean结果。
        boolean anyStartsWithA = stringCollection.stream().anyMatch((s) -> s.startsWith("a"));
        System.out.println(anyStartsWithA);      // true

        boolean allStartsWithA = stringCollection.stream().allMatch((s) -> s.startsWith("a"));
        System.out.println(allStartsWithA);      // false

        boolean noneStartsWithZ = stringCollection.stream().noneMatch((s) -> s.startsWith("z"));
        System.out.println(noneStartsWithZ);      // true

        //Count是中断型操作，它返回流中的元素数量。
        long startsWithB = stringCollection.stream().filter((s) -> s.startsWith("b")).count();
        System.out.println(startsWithB);    // 3

        // Reduced 这个中断性操作使用指定的function对流中元素实施消减策略。此操作的返回值是一个包括所有被消减元素的Optional。
        Optional<String> reduced = stringCollection.stream().sorted().reduce((s1, s2) -> s1 + "#" + s2);
        reduced.ifPresent(System.out::println);// "aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2"
    }

    static void parallelStreamsInterface() {
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        // 采用串行操作
        long t0 = System.nanoTime();
        long count = values.stream().sorted().count();
        System.out.println(count);
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));

        // 并发处理
        long t0p = System.nanoTime();
        long countP = values.parallelStream().sorted().count();
        System.out.println(count);
        long t1p = System.nanoTime();
        long millisP = TimeUnit.NANOSECONDS.toMillis(t1p - t0p);
        System.out.println(String.format("parallel sort took: %d ms", millisP));
        // parallel sort took: 472 ms

    }

    static void mapInterface() {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }
        map.forEach((id, val) -> System.out.println(val));

        map.computeIfPresent(3, (num, val) -> val + num);
        map.get(3);             // val33

        map.computeIfPresent(9, (num, val) -> null);
        map.containsKey(9);     // false

        map.computeIfAbsent(23, num -> "val" + num);
        map.containsKey(23);    // true

        map.computeIfAbsent(3, num -> "bam");
        map.get(3);             // val33

        map.remove(3, "val3");
        map.get(3);             // val33

        map.remove(3, "val33");
        map.get(3);             // null

        map.getOrDefault(42, "not found");  // not found

        // 合并
        map.merge(9, "val9", String::concat);
        map.get(9);             // val9

        map.merge(9, "concat", String::concat);
        map.get(9);             // val9concat
    }

    public static void main(String[] args) {
        mapInterface();
    }

}
