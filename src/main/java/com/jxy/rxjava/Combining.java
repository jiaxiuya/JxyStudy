package com.jxy.rxjava;

import io.reactivex.Observable;

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
        Observable<String> source1 = Observable.interval(1, TimeUnit.SECONDS)
            .map(l -> l + 1) // emit elapsed seconds
            .map(l -> "Source1: " + l + " seconds");
        //emit every 300 milliseconds
        Observable<String> source2 = Observable.interval(300, TimeUnit.MILLISECONDS)
            .map(l -> (l + 1) * 300) // emit elapsed milliseconds
            .map(l -> "Source2: " + l + " milliseconds");
        //merge and subscribe
        Observable.merge(source1, source2).subscribe(System.out::println);
        //keep alive for 3 seconds
        sleep(3000);

    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}
