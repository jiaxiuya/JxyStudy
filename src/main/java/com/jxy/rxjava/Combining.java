package com.jxy.rxjava;

import io.reactivex.Observable;
import io.reactivex.observables.GroupedObservable;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Info
 *
 * @author xiuya.jxy
 * @since 2018/5/24
 */
public class Combining {

    public static void main(String[] args) {
      /*  Observable<String> source1 = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        Observable<String> source2 = Observable.just("Zeta", "Eta", "Theta");
        Observable.merge(source1, source2).subscribe(i -> System.out.println("RECEIVED: " + i));*/

       /* Observable<String> source1 = Observable.just("Alpha", "Beta");
        Observable<String> source2 = Observable.just("Gamma", "Delta");
        Observable<String> source3 = Observable.just("Epsilon", "Zeta");
        Observable<String> source4 = Observable.just("Eta", "Theta");
        Observable<String> source5 = Observable.just("Iota", "Kappa");
        Observable.mergeArray(source1, source2, source3, source4, source5)
            .subscribe(i -> System.out.println("mergeArray RECEIVED: " + i));*/

        // 对于无限流，也是可以合并的
       /* Observable<String> source1 = Observable.interval(1, TimeUnit.SECONDS)
            .map(l -> l + 1) // emit elapsed seconds
            .map(l -> "Source1: " + l + " seconds");
        //emit every 300 milliseconds
        Observable<String> source2 = Observable.interval(300, TimeUnit.MILLISECONDS)
            .map(l -> (l + 1) * 300) // emit elapsed milliseconds
            .map(l -> "Source2: " + l + " milliseconds");
        //merge and subscribe
        Observable.merge(source1, source2).subscribe(System.out::println);
        //keep alive for 3 seconds
        sleep(3000);*/

        // flatMap
        /*Observable<String> source = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        source.flatMap(s -> Observable.fromArray(s.split(""))).subscribe(System.out::println);*/

        // flatMap结合正则表达式过滤数据
       /* Observable<String> source =
            Observable.just("521934/2342/FOXTROT", "21962/12112/78886/TANGO",
                "283242/4542/WHISKEY/2348562");
        source.flatMap(s -> Observable.fromArray(s.split("/")))
            .filter(s -> s.matches("[0-9]+")) //use regex to filter integers
            .map(Integer::valueOf).subscribe(System.out::println);
*/
        // flatMap处理无限Observable
       /* Observable<Integer> intervalArguments = Observable.just(2, 3, 10, 7);
        intervalArguments.flatMap(i -> Observable.interval(i, TimeUnit.SECONDS)
            .map(i2 -> i + "s interval: " + ((i + 1) * i) + "seconds elapsed")
        ).subscribe(System.out::println);
        sleep(12000);*/

        // flatMap 的clever用户
        /*Observable<Integer> secondIntervals =
            Observable.just(2, 0, 3, 10, 7);
        secondIntervals.flatMap(i -> {
            if (i == 0) { return Observable.empty(); } else {
                return Observable.interval(i, TimeUnit.SECONDS)
                    .map(l -> i + "s interval: " + ((l + 1) * i) + " seconds elapsed");
            }
        }).subscribe(System.out::println);*/

        // 顺序连接，concat和combine对应的
       /* Observable<String> source1 = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        Observable<String> source2 = Observable.just("Zeta", "Eta", "Theta");
        Observable.concat(source1, source2)
            .subscribe(i -> System.out.println("concat RECEIVED: " + i));*/

      /* // concat 处理无限流的时候只会在第一个流结束的时候才会继续处理第二个流
        Observable<String> source1 =
            Observable.interval(1, TimeUnit.SECONDS)
                .take(2).map(l -> l + 1) // emit elapsed seconds
                .map(l -> "Source1: " + l + " seconds");
        //emit every 300 milliseconds
        Observable<String> source2 =
            Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(l -> (l + 1) * 300) // emit elapsed milliseconds
                .map(l -> "Source2: " + l + " milliseconds");
        Observable.concat(source1, source2)
            .subscribe(i -> System.out.println("concat RECEIVED: " + i));
        //keep application alive for 5 seconds
        sleep(5000);*/

      /*// concatMap 对应 flatMap 顺序处理流
        Observable<String> source =
            Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        source.concatMap(s -> Observable.fromArray(s.split("")))
            .subscribe(System.out::println);*/

       /* // Ambiguous,两个流处于竞争关系，取最快到达的流
        //emit every second
        Observable<String> source1 =
            Observable.interval(1, TimeUnit.SECONDS)
                .take(2)
                .map(l -> l + 1) // emit elapsed seconds
                .map(l -> "Source1: " + l + " seconds");
        //emit every 300 milliseconds
        Observable<String> source2 =
            Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(l -> (l + 1) * 300) // emit elapsed milliseconds
                .map(l -> "Source2: " + l + " milliseconds");
        //emit Observable that emits first
        Observable.amb(Arrays.asList(source1, source2))
            .subscribe(i -> System.out.println("RECEIVED: " + i));
        //keep application alive for 5 seconds
        sleep(5000);*/

        // zip，合并流
        /*Observable<String> source1 =
            Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        Observable<Integer> source2 = Observable.range(1, 6);
        Observable.zip(source1, source2, (s, i) -> s + "-" + i)
            .subscribe(System.out::println);*/

       /* Observable<String> strings =
            Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        Observable<Long> seconds =
            Observable.interval(1, TimeUnit.SECONDS);
        Observable.zip(strings, seconds, (s, l) -> s)
            .subscribe(s -> System.out.println("Received " + s + " at " + LocalTime.now()));
        sleep(6000);*/

      /* // combineLatest ,使用两个流最新的元素合并，而不是等待两个流的元素个数匹配上
        Observable<Long> source1 =
            Observable.interval(300, TimeUnit.MILLISECONDS);
        Observable<Long> source2 =
            Observable.interval(1, TimeUnit.SECONDS);
        Observable.combineLatest(source1, source2,
            (l1, l2) -> "SOURCE 1: " + l1 + "  SOURCE 2: " + l2)
            .subscribe(System.out::println);
        sleep(5000);*/

        // withLatestFrom 合并两个流，只关心第一个流的每个元素和第二个流的最新的元素
        /*Observable<Long> source1 =
            Observable.interval(300, TimeUnit.MILLISECONDS);
        Observable<Long> source2 =
            Observable.interval(1, TimeUnit.SECONDS);
        source2.withLatestFrom(source1,
            (l1, l2) -> "SOURCE 2: " + l1 + "  SOURCE 1: " + l2
        ).subscribe(System.out::println);
        sleep(3000);*/

        Observable<String> source = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        Observable<GroupedObservable<Integer, String>> byLengths = source.groupBy(s -> s.length());
        //byLengths.flatMapSingle(grp -> grp.toList()).subscribe(System.out::println);
        byLengths.flatMapSingle(
            grp -> grp.reduce("", (x, y) -> x.equals("") ? y : x + ", " + y).map(s -> grp.getKey() + ": " + s)
        ).subscribe(System.out::println);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}
