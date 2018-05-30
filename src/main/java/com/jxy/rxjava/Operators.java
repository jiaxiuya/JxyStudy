package com.jxy.rxjava;

import com.google.common.collect.ImmutableList;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Info
 *
 * @author xiuya.jxy
 * @since 2018/5/23
 */
public class Operators {

    public static void main(String[] args) {

        //take()
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .take(3)
            .subscribe(s -> System.out.println("take RECEIVED: " + s));

       /* Observable.interval(300, TimeUnit.MILLISECONDS)
            .take(2, TimeUnit.SECONDS)
            .subscribe(i -> System.out.println("RECEIVED: " + i));
        sleep(5000);*/

        //TODO takeLast()对于无限流如何操作

        Observable.range(1, 100)
            .takeWhile(i -> i < 5)
            .subscribe(i -> System.out.println("takeWhile RECEIVED: " + i));

        // takeUntil(),当第二个Observable收到数据的时候，源Observable停止发射数据
        Observable.interval(1, TimeUnit.SECONDS)
            .takeUntil(Observable.timer(3, TimeUnit.SECONDS))
            .subscribe(aBoolean -> System.out.println("TakeUntil:" + aBoolean));

        // skip（）
        Observable.range(1, 100)
            .skip(90)
            .subscribe(i -> System.out.println("skip RECEIVED: " + i));

        // distinct()
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .map(String::length)
            .distinct()
            .subscribe(i -> System.out.println("distinct RECEIVED: " + i));

        Observable.just(1, 1, 1, 2, 2, 3, 3, 2, 1, 1)
            .distinctUntilChanged()
            .subscribe(i -> System.out.println("distinctUntilChanged RECEIVED: " + i));

        // elementAt()
        Observable.just("Alpha", "Beta", "Zeta", "Eta", "Gamma",
            "Delta")
            .elementAt(3)
            .subscribe(i -> System.out.println("RECEIVED: " + i));

        // cast()
        Observable<Object> items = Observable.just("Alpha", "Beta", "Gamma").cast(Object.class);

        // startWith()
        Observable.just("Coffee", "Tea", "Espresso", "Latte").startWith("COFFEE SHOP MENU").subscribe(
            System.out::println);

        // startWithArray()
        Observable.just("Coffee", "Tea", "Espresso", "Latte").startWithArray("COFFEE SHOP MENU", "----------------")
            .subscribe(System.out::println);

        // defaultIfEmpty()
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .filter(s -> s.startsWith("Z"))
            .defaultIfEmpty("None")
            .subscribe(System.out::println);

        // switchIfEmpty
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
            "Epsilon")
            .filter(s -> s.startsWith("Z"))
            .switchIfEmpty(Observable.just("Zeta", "Eta", "Theta"))
            .subscribe(i -> System.out.println("switchIfEmpty RECEIVED: " + i),
                e -> System.out.println("RECEIVED ERROR: " + e)
            );

        // sorted()，无限Observable有可能会导致OutOfMemory
        Observable.just(6, 2, 5, 7, 1, 4, 9, 8, 3)
            .sorted()
            .subscribe(i -> System.out.println("sorted RECEIVED: " + i));

        Observable.just(6, 2, 5, 7, 1, 4, 9, 8, 3)
            .sorted(Comparator.reverseOrder())
            .subscribe(i -> System.out.println("sorted reverseOrder RECEIVED: " + i));

        Observable.just("Alpha", "Beta", "Gamma", "Delta",
            "Epsilon")
            .sorted(Comparator.comparingInt(String::length))
            .subscribe(System.out::println);

        // delay()
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .delay(3, TimeUnit.SECONDS)
            .subscribe(s -> System.out.println("delay Received: " + s));

        // repeat()
        Observable.just("Alpha", "Beta").repeat(2)
            .subscribe(s -> System.out.println("repeat Received: " + s));

        // scan()
        Observable.just(5, 3, 7, 10, 2, 14)
            .scan((accumulator, next) -> accumulator + next)
            .subscribe(s -> System.out.println("scan Received: " + s));

        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .scan(0, (total, next) -> total + 1).skip(1)
            .subscribe(s -> System.out.println("scan2 Received: " + s));

        // count()
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .count()
            .subscribe(s -> System.out.println("count Received: " + s));

        // reduce()
        Observable.just(5, 3, 7, 10, 2, 14)
            .reduce((total, next) -> total + next)
            .subscribe(s -> System.out.println("reduce Received: " + s));

        Observable.just(5, 3, 7, 10, 2, 14)
            .reduce("", (total, next) -> total + (total.equals("") ? "" : ",") + next)
            .subscribe(s -> System.out.println("reduce2 Received: " + s));

        // all()
        Observable.just(5, 3, 7, 11, 2, 14)
            .all(i -> i < 10)
            .subscribe(s -> System.out.println("all Received: " + s));

        // any()
        Observable.just("2016-01-01", "2016-05-02", "2016-09-12", "2016-04-03")
            .map(LocalDate::parse)
            .any(dt -> dt.getMonthValue() >= 6)
            .subscribe(s -> System.out.println("any Received: " + s));

        // contains()
        Observable.range(1, 10000)
            .contains(9563)
            .subscribe(s -> System.out.println("contains Received: " + s));

        // toList(),capacityHint是优化初始化List的大小，不是元素的长度
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .toList(10)
            .subscribe(s -> System.out.println("toList Received: " + s));

        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .toList(CopyOnWriteArrayList::new)
            .subscribe(s -> System.out.println("toList2 Received: " + s));

        // toSortedList
        Observable.just(6, 2, 5, 7, 1, 4, 9, 8, 3)
            .toSortedList()
            .subscribe(s -> System.out.println(" toSortedList Received: " + s));

        // toMap
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .toMap(s -> s.charAt(0), String::length, ConcurrentHashMap::new)
            .subscribe(s -> System.out.println("toMap Received: " + s));

        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .toMap(String::length)
            .subscribe(s -> System.out.println("toMap2 Received: " + s));

        // toMultimap
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .toMultimap(String::length)
            .subscribe(s -> System.out.println("toMultimap Received: " + s));

        // collect
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .collect(HashSet::new, HashSet::add)
            .subscribe(s -> System.out.println("collect Received: " + s));

        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .collect(ImmutableList::builder, ImmutableList.Builder::add)
            .map(ImmutableList.Builder::build)
            .subscribe(s -> System.out.println("collect2 Received: " + s));

        // onErrorReturnItem
        Observable.just(5, 2, 4, 0, 3, 2, 8)
            .map(i -> 10 / i)
            .onErrorReturnItem(-1)
            .subscribe(i -> System.out.println("onErrorReturnItem RECEIVED: " + i),
                e -> System.out.println("RECEIVED ERROR: " + e)
            );

        // onErrorReturn
        Observable.just(5, 2, 4, 0, 3, 2, 8)
            .map(i -> 10 / i)
            .onErrorReturn(e -> -1)
            .subscribe(i -> System.out.println("onErrorReturn RECEIVED: " + i),
                e -> System.out.println("RECEIVED ERROR: " + e)
            );

        Observable.just(5, 2, 4, 0, 3, 2, 8)
            .map(i -> {
                try {
                    return 10 / i;
                } catch (ArithmeticException e) {
                    return -1;
                }
            })
            .subscribe(i -> System.out.println("try catch RECEIVED: " + i),
                e -> System.out.println("RECEIVED ERROR: " + e)
            );

        Observable.just(5, 2, 4, 0, 3, 2, 8)
            .map(i -> 10 / i)
            .onErrorResumeNext(Observable.just(-1).repeat(3))
            .subscribe(i -> System.out.println("onErrorResumeNext RECEIVED: " + i),
                e -> System.out.println("onErrorResumeNext RECEIVED ERROR: " + e)
            );

        Observable.just(5, 2, 4, 0, 3, 2, 8)
            .map(i -> 10 / i)
            .onErrorResumeNext((Throwable e) -> Observable.just(-1).repeat(3))
            .subscribe(i -> System.out.println("onErrorResumeNext2 RECEIVED: " + i),
                e -> System.out.println("RECEIVED ERROR: " + e)
            );

        // retry
        Observable.just(5, 2, 4, 0, 3, 2, 8)
            .map(i -> 10 / i)
            .retry(1)
            .subscribe(i -> System.out.println("retry RECEIVED: " + i),
                e -> System.out.println("RECEIVED ERROR: " + e));

        // doOnNext
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .doOnNext(s -> System.out.println("doOnNext Processing: " + s))
            .map(String::length)
            .subscribe(i -> System.out.println("doOnNext Received: " + i));

        // doOnComplete
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .doOnComplete(() -> System.out.println("doOnComplete Source is done emitting!"))
            .map(String::length)
            .subscribe(i -> System.out.println("doOnComplete Received: " + i));

        // doOnError
        Observable.just(5, 2, 4, 0, 3, 2, 8)
            .doOnError(e -> System.out.println("doOnError Source failed!"))
            .map(i -> 10 / i)
            .doOnError(e -> System.out.println("doOnError Division failed!"))
            .subscribe(i -> System.out.println("doOnError RECEIVED: " + i),
                e -> System.out.println("doOnError RECEIVED ERROR: " + e)
            );

        // doOnSubscribe doOnDispose
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .doOnSubscribe(d -> System.out.println("Subscribing!"))
            .doOnDispose(() -> System.out.println("Disposing!"))
            .subscribe(i -> System.out.println("RECEIVED: " + i));

        // doOnSuccess
        Observable.just(5, 3, 7, 10, 2, 14)
            .reduce((total, next) -> total + next)
            .doOnSuccess(i -> System.out.println("doOnSuccess Emitting: " + i))
            .subscribe(i -> System.out.println("doOnSuccess Received: " + i));
        sleep(10000);

    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
