package com.jxy.rxjava;

import io.reactivex.*;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Info
 *
 * @author xiuya.jxy
 * @since 2018/1/26
 */
public class TestRxJava2 {

    private static StringBuilder mRxOperatorsText = new StringBuilder();

    public static void main(String[] args) throws InterruptedException {

        Observable.create((ObservableOnSubscribe<Integer>)e -> {
            mRxOperatorsText.append("Observable emit 1" + "\n");
            System.out.println("Observable emit 1" + "\n");
            e.onNext(1);
            mRxOperatorsText.append("Observable emit 2" + "\n");
            System.out.println("Observable emit 2" + "\n");
            e.onNext(2);
            mRxOperatorsText.append("Observable emit 3" + "\n");
            System.out.println("Observable emit 3" + "\n");
            e.onNext(3);
            e.onComplete();
            mRxOperatorsText.append("Observable emit 4" + "\n");
            System.out.println("Observable emit 4" + "\n");
            e.onNext(4);
        }).subscribe(new Observer<Integer>() {
            private int i;
            private Disposable mDisposable;

            @Override
            public void onSubscribe(@NonNull Disposable d) {
                mRxOperatorsText.append("onSubscribe : " + d.isDisposed() + "\n");
                System.out.println("onSubscribe : " + d.isDisposed() + "\n");
                mDisposable = d;
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                mRxOperatorsText.append("onNext : value : " + integer + "\n");
                System.out.println("onNext : value : " + integer + "\n");
                i++;
                if (i == 2) {
                    // 在RxJava 2.x 中，新增的Disposable可以做到切断的操作，让Observer观察者不再接收上游事件
                    mDisposable.dispose();
                    mRxOperatorsText.append("onNext : isDisposable : " + mDisposable.isDisposed() + "\n");
                    System.out.println("onNext : isDisposable : " + mDisposable.isDisposed() + "\n");
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {
                mRxOperatorsText.append("onError : value : " + e.getMessage() + "\n");
                System.out.println("onError : value : " + e.getMessage() + "\n");
            }

            @Override
            public void onComplete() {
                mRxOperatorsText.append("onComplete" + "\n");
                System.out.println("onComplete" + "\n");
            }
        });

        Observable.create((ObservableOnSubscribe<Integer>)e -> {
            e.onNext(1);
            e.onNext(2);
            e.onNext(3);
        }).map(integer -> "This is result " + integer).subscribe(s -> {
            mRxOperatorsText.append("accept : " + s + "\n");
            System.out.println("accept : " + s + "\n");
        });

        System.out.println("=============ZipTest============");
        Observable.zip(getStringObservable(), getIntegerObservable(), (s, integer) -> s + integer).subscribe(s -> {
            mRxOperatorsText.append("zip : accept : " + s + "\n");
            System.out.println("zip : accept : " + s + "\n");
        });

        System.out.println("=======concatTest========");
        Observable.concat(Observable.just(1, 2, 3), Observable.just(4, 5, 6))
            .subscribe(new Consumer<Integer>() {
                @Override
                public void accept(@NonNull Integer integer) throws Exception {
                    mRxOperatorsText.append("concat : " + integer + "\n");
                    System.out.println("concat : " + integer + "\n");
                }
            });

        System.out.println("=======flatMapTest========");
        // flatMap是无序的
        Observable.create((ObservableOnSubscribe<Integer>)e -> {
            e.onNext(1);
            e.onNext(2);
            e.onNext(3);
        }).flatMap((Function<Integer, ObservableSource<String>>)integer -> {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                list.add("I am value " + integer);
            }
            return Observable.fromIterable(list);
        }).subscribe(s -> {
            System.out.println("flatMap : accept : " + s + "\n");
            mRxOperatorsText.append("flatMap : accept : " + s + "\n");
        });

        System.out.println("=======concatMapTest========");
        Observable.create((ObservableOnSubscribe<Integer>)e -> {
            e.onNext(1);
            e.onNext(2);
            e.onNext(3);
        }).concatMap((Function<Integer, ObservableSource<String>>)integer -> {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                list.add("I am value " + integer);
            }
            return Observable.fromIterable(list);
        }).subscribe(s -> {
            System.out.println("concatMap : accept : " + s + "\n");
            mRxOperatorsText.append("concatMap : accept : " + s + "\n");
        });

        System.out.println("==========distinctTest==========");
        Observable.just(1, 1, 1, 2, 2, 3, 4, 5)
            .distinct()
            .subscribe(integer -> {
                mRxOperatorsText.append("distinct : " + integer + "\n");
                System.out.println("distinct : " + integer + "\n");
            });

        System.out.println("==========filterTest==========");
        Observable.just(1, 20, 65, -5, 7, 19)
            .filter(integer -> integer >= 10).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(@NonNull Integer integer) throws Exception {
                mRxOperatorsText.append("filter : " + integer + "\n");
                System.out.println("filter : " + integer + "\n");
            }
        });

        System.out.println("==========bufferTest==========");
        Observable.just(1, 2, 3, 4, 5)
            .buffer(3, 2)
            .subscribe(integers -> {
                mRxOperatorsText.append("buffer size : " + integers.size() + "\n");
                System.out.println("buffer size : " + integers.size() + "\n");
                mRxOperatorsText.append("buffer value : ");
                System.out.println("buffer value : ");
                for (Integer i : integers) {
                    mRxOperatorsText.append(i + "");
                    System.out.println(i + "");
                }
                mRxOperatorsText.append("\n");
                System.out.println("\n");
            });

        System.out.println("==========timerTest==========");
        mRxOperatorsText.append("timer start : " + LocalDateTime.now() + "\n");
        System.out.println("timer start : " + LocalDateTime.now() + "\n");
        Observable.timer(2, TimeUnit.SECONDS)
            .subscribe(aLong -> {
                mRxOperatorsText.append("timer :" + aLong + " at " + LocalDateTime.now() + "\n");
                System.out.println("timer :" + aLong + " at " + LocalDateTime.now() + "\n");
            });

        System.out.println("==========intervalTest==========");
        mRxOperatorsText.append("interval start : " + LocalDateTime.now() + "\n");
        System.out.println("interval start : " + LocalDateTime.now() + "\n");
        Disposable mDisposable = Observable.interval(3, 2, TimeUnit.SECONDS)
            .subscribe(aLong -> {
                mRxOperatorsText.append("interval :" + aLong + " at " + LocalDateTime.now() + "\n");
                System.out.println("interval :" + aLong + " at " + LocalDateTime.now() + "\n");
            });

        System.out.println("==========doOnNextTest==========");
        Observable.just(1, 2, 3, 4)
            .doOnNext(integer -> {
                mRxOperatorsText.append("doOnNext 保存 " + integer + "成功" + "\n");
                System.out.println("doOnNext 保存 " + integer + "成功" + "\n");
            })
            .subscribe(integer -> {
                mRxOperatorsText.append("doOnNext :" + integer + "\n");
                System.out.println("doOnNext :" + integer + "\n");
            });

        System.out.println("==========skipTest==========");
        Observable.just(1, 2, 3, 4, 5)
            .skip(2)
            .subscribe(integer -> {
                mRxOperatorsText.append("skip : " + integer + "\n");
                System.out.println("skip : " + integer + "\n");
            });

        System.out.println("==========takeTest==========");
        Flowable.fromArray(1, 2, 3, 4, 5)
            .take(2)
            .subscribe(integer -> {
                mRxOperatorsText.append("take : " + integer + "\n");
                System.out.println("accept: take : " + integer + "\n");
            });

        System.out.println("==========SingleObserverTest==========");
        Single.just(new Random().nextInt())
            .subscribe(new SingleObserver<Integer>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {
                }

                @Override
                public void onSuccess(@NonNull Integer integer) {
                    mRxOperatorsText.append("single : onSuccess : " + integer + "\n");
                    System.out.println("single : onSuccess : " + integer + "\n");
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    mRxOperatorsText.append("single : onError : " + e.getMessage() + "\n");
                    System.out.println("single : onError : " + e.getMessage() + "\n");
                }

            });

        System.out.println("==========debounceTest==========");
        Observable.create((ObservableOnSubscribe<Integer>)emitter -> {
            // send events with simulated time wait
            emitter.onNext(1); // skip
            Thread.sleep(400);
            emitter.onNext(2); // deliver
            Thread.sleep(505);
            emitter.onNext(3); // skip
            Thread.sleep(100);
            emitter.onNext(4); // deliver
            Thread.sleep(605);
            emitter.onNext(5); // deliver
            Thread.sleep(510);
            emitter.onComplete();
        }).debounce(500, TimeUnit.MILLISECONDS)
            .subscribe(integer -> {
                mRxOperatorsText.append("debounce :" + integer + "\n");
                System.out.println("debounce :" + integer + "\n");
            });

        System.out.println("==========deferTest==========");
        Observable<Integer> observable = Observable.defer(new Callable<ObservableSource<Integer>>() {
            @Override
            public ObservableSource<Integer> call() throws Exception {
                return Observable.just(1, 2, 3);
            }
        });
        observable.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Integer integer) {
                mRxOperatorsText.append("defer : " + integer + "\n");
                System.out.println("defer : " + integer + "\n");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                mRxOperatorsText.append("defer : onError : " + e.getMessage() + "\n");
                System.out.println("defer : onError : " + e.getMessage() + "\n");
            }

            @Override
            public void onComplete() {
                mRxOperatorsText.append("defer : onComplete\n");
                System.out.println("defer : onComplete\n");
            }
        });

        System.out.println("==========lastTest==========");
        Observable.just(1, 2, 3)
            .last(4)
            .subscribe(integer -> {
                mRxOperatorsText.append("last : " + integer + "\n");
                System.out.println("last : " + integer + "\n");
            });

        System.out.println("==========mergeTest==========");
        Observable.merge(Observable.just(1, 2), Observable.just(3, 4, 5))
            .subscribe(integer -> {
                mRxOperatorsText.append("merge :" + integer + "\n");
                System.out.println("accept: merge :" + integer + "\n");
            });

        System.out.println("==========reduceTest==========");
        Observable.just(1, 2, 3)
            .reduce((integer, integer2) -> integer + integer2).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(@NonNull Integer integer) throws Exception {
                mRxOperatorsText.append("reduce : " + integer + "\n");
                System.out.println("accept: reduce : " + integer + "\n");
            }
        });

        System.out.println("==========justTest==========");
        Observable.just(1, 2, 3)
            .scan((integer, integer2) -> integer + integer2).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(@NonNull Integer integer) throws Exception {
                mRxOperatorsText.append("scan " + integer + "\n");
                System.out.println("accept: scan " + integer + "\n");
            }
        });

        System.out.println("==========windowTest==========");
        mRxOperatorsText.append("window\n");
        System.out.println("window\n");
        // 间隔一秒发一次
        Observable.interval(1, TimeUnit.SECONDS)
            // 最多接收15个
            .take(15)
            .window(3, TimeUnit.SECONDS)
            .subscribe(longObservable -> {
                mRxOperatorsText.append("Sub Divide begin...\n");
                System.out.println("Sub Divide begin...\n");
                longObservable
                    .subscribe(new Consumer<Long>() {
                        @Override
                        public void accept(@NonNull Long aLong) throws Exception {
                            mRxOperatorsText.append("Next:" + aLong + "\n");
                            System.out.println("Next:" + aLong + "\n");
                        }
                    });
            });

        Thread.sleep(100000);
    }

    private static Observable<String> getStringObservable() {
        return Observable.create(e -> {
            if (!e.isDisposed()) {
                e.onNext("A");
                mRxOperatorsText.append("String emit : A \n");
                System.out.println("String emit : A \n");
                e.onNext("B");
                mRxOperatorsText.append("String emit : B \n");
                System.out.println("String emit : B \n");
                e.onNext("C");
                mRxOperatorsText.append("String emit : C \n");
                System.out.println("String emit : C \n");
            }
        });
    }

    private static Observable<Integer> getIntegerObservable() {
        return Observable.create(e -> {
            if (!e.isDisposed()) {
                e.onNext(1);
                mRxOperatorsText.append("Integer emit : 1 \n");
                System.out.println("Integer emit : 1 \n");
                e.onNext(2);
                mRxOperatorsText.append("Integer emit : 2 \n");
                System.out.println("Integer emit : 2 \n");
                e.onNext(3);
                mRxOperatorsText.append("Integer emit : 3 \n");
                System.out.println("Integer emit : 3 \n");
                e.onNext(4);
                mRxOperatorsText.append("Integer emit : 4 \n");
                System.out.println("Integer emit : 4 \n");
                e.onNext(5);
                mRxOperatorsText.append("Integer emit : 5 \n");
                System.out.println("Integer emit : 5 \n");
            }
        });
    }

}
