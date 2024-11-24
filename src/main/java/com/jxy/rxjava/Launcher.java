//package com.jxy.rxjava;
//
//import io.reactivex.*;
//import io.reactivex.disposables.CompositeDisposable;
//import io.reactivex.disposables.Disposable;
//import io.reactivex.observables.ConnectableObservable;
//import io.reactivex.observers.ResourceObserver;
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.concurrent.*;
//
//import static java.lang.Thread.sleep;
//
///**
// * Info
// *
// * @author xiuya.jxy
// * @since 2018/5/22
// */
//public class Launcher {
//    public static void main(String[] args) {
//        try {
//
//            Observable<String> myStrings =
//                Observable.just("Alpha", "Beta", "Gamma", "Delta",
//                    "Epsilon");
//            myStrings.map(String::length).subscribe(System.out::println);
//
//            // 创建Observable对象，emitter对象
//            /*Observable<String> source = Observable.create(emitter -> {
//                try {
//                    emitter.onNext("Alpha");
//                    emitter.onNext("Beta");
//                    emitter.onNext("Gamma");
//                    emitter.onNext("Delta");
//                    emitter.onNext("Epsilon");
//                    emitter.onComplete();
//                } catch (Throwable e) {
//                    emitter.onError(e);
//                }
//            });*/
//            /*Observable<String> source =
//                Observable.just("Alpha", "Beta", "Gamma", "Delta",
//                    "Epsilon");*/
//            /*List<String> items =
//                Arrays.asList("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
//            Observable<String> source = Observable.fromIterable(items);
//*/
//            /*source.map(String::length).filter(i -> i >= 5)
//                .subscribe(s -> System.out.println("RECEIVED: " + s), Throwable::printStackTrace);*/
//
//           /* Observer<Integer> myObserver = new Observer<Integer>() {
//                @Override
//                public void onSubscribe(Disposable d) {
//                    //do nothing with Disposable, disregard for now
//                }
//
//                @Override
//                public void onNext(Integer value) {
//                    System.out.println("RECEIVED: " + value);
//                }
//
//                @Override
//                public void onError(Throwable e) {
//                    e.printStackTrace();
//                }
//
//                @Override
//                public void onComplete() {
//                    System.out.println("Done!");
//                }
//            };
//            source.map(String::length).filter(i -> i >= 5).subscribe(myObserver);*/
//
//           /* source.map(String::length).filter(i -> i >= 5)
//                .subscribe(i -> System.out.println("RECEIVED: " + i),
//                    Throwable::printStackTrace,
//                    () -> System.out.println("Done!"));
//*/
//           /* //first observer
//            source.subscribe(s -> System.out.println("Observer 1 Received: " + s));
//            //second observer
//            source.subscribe(s -> System.out.println("Observer 2 Received: " + s));*/
//
//           /* //Cold observable first observer，先给第一个observer
//            source.subscribe(s -> System.out.println("Observer 1 Received: " + s));
//            //Cold observable second observer，再给第二个observer，map，filter不会破坏这种顺序性
//            source.map(String::length).filter(i -> i >= 5)
//                .subscribe(s -> System.out.println("Observer 2 Received: " + s));
//
//            // hot observable，类似广播消息，observer同时接收到
//            ConnectableObservable<String> source2 =
//                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon").publish();
//            //Set up observer 1，和observer 2同时接收到
//            source2.subscribe(s -> System.out.println("Observer 1: " + s));
//            //Set up observer 2
//            source2.map(String::length)
//                .subscribe(i -> System.out.println("Observer 2: " + i));
//            // Fire!
//            source2.connect();
//
//            Observable.range(10, 10)
//                .subscribe(s -> System.out.println("range RECEIVED: " + s));*/
//
//           /* // Cold Observable
//            Observable<Long> secondIntervals =
//                Observable.interval(1, TimeUnit.SECONDS);
//            secondIntervals.subscribe(System.out::println);
//            *//* Hold main thread for 5 seconds Observable above has chance to fire *//*
//            sleep(5000);
//
//            // Hot Observable
//            ConnectableObservable<Long> seconds =
//                Observable.interval(1, TimeUnit.SECONDS).publish();
//            //observer 1
//            seconds.subscribe(l -> System.out.println("Observer 1: " + l));
//            seconds.connect();
//            //sleep 5 seconds
//            sleep(5000);
//            //observer 2
//            seconds.subscribe(l -> System.out.println("Observer 2: " + l));
//            //sleep 5 seconds
//            sleep(5000);*/
//
//            /*
//            // 将已经存在的Future转化为Observable
//            ExecutorService executor = Executors.newCachedThreadPool();
//            Task task = new Task();
//            Future<String> result = executor.submit(task);
//            Observable.fromFuture(result)
//                .map(String::length)
//                .subscribe(System.out::println);*/
//
//            /*// 空的Observable
//            Observable<String> empty = Observable.empty();
//            empty.subscribe(System.out::println,
//                Throwable::printStackTrace,
//                () -> System.out.println("Done!"));*/
//
//            /*// 同为空的Observable，区别是不执行onComplete
//            Observable<String> empty = Observable.never();
//            empty.subscribe(System.out::println,
//                Throwable::printStackTrace,
//                () -> System.out.println("Done!"));
//            sleep(5000);*/
//
//            /*// 直接导致异常抛出
//            Observable.error(() -> new Exception("Crash and burn!"))
//                .subscribe(i -> System.out.println("RECEIVED: " + i),
//                    Throwable::printStackTrace,
//                    () ->  System.out.println("Done!"));*/
//
//           /* // 可以动态变更Observable中的数据，延迟方式，比如改变一个list的值后就不需要重新再创建一个Observable了
//            Observable<Integer> source = Observable.defer(() -> Observable.range(start, count));
//            source.subscribe(i -> System.out.println("Observer 1: " + i));
//            //modify count
//            count = 10;
//            source.subscribe(i -> System.out.println("Observer 2: " + i));*/
//
//           /* // 将observable的异常抛给observer
//            Observable.fromCallable(() -> 1 / 0)
//                .subscribe(i -> System.out.println("Received: " + i),
//                    e -> System.out.println("Error Captured: " + e));*/
//
//            /*// Observable中只有一个元素
//            Single.just("Hello").map(String::length).subscribe(System.out::println, Throwable::printStackTrace);
//            // first()返回第一个元素
//            Observable<String> source = Observable.just("Alpha", "Beta", "Gamma");
//            source.first("Nil").subscribe(System.out::println);*/
//
//            /*// has emission，Maybe
//            Maybe<Integer> presentSource = Maybe.just(100);
//            presentSource.subscribe(s -> System.out.println("Process 1 received: " + s),
//                Throwable::printStackTrace,
//                () -> System.out.println("Process 1 done!"));
//            //no emission
//            Maybe<Integer> emptySource = Maybe.empty();
//            emptySource.subscribe(s -> System.out.println("Process 2 received: " + s),
//                Throwable::printStackTrace,
//                () -> System.out.println("Process 2 done!"));
//
//            Observable<String> source =
//                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
//            source.firstElement().subscribe(s -> System.out.println("RECEIVED " + s), Throwable::printStackTrace,
//                () -> System.out.println("Done!"));*/
//
//            /*Completable.fromRunnable(Launcher::runProcess)
//                .subscribe(() -> System.out.println("Done!"));*/
//
//            /*// 中途中断接收
//            Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS);
//            Disposable disposable = seconds.subscribe(l -> System.out.println("Received: " + l));
//            //sleep 5 seconds
//            sleep(5000);
//            //dispose and stop emissions
//            disposable.dispose();
//            //sleep 5 seconds to prove
//            //there are no more emissions
//            sleep(5000);*/
//
//            /*// rxjava2默认的disposale处理
//            Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS);
//            ResourceObserver<Long> myObserver = new ResourceObserver<Long>() {
//                @Override
//                public void onNext(Long value) {
//                    System.out.println(value);
//                }
//
//                @Override
//                public void onError(Throwable e) {
//                    e.printStackTrace();
//                }
//
//                @Override
//                public void onComplete() {
//                    System.out.println("Done!");
//                }
//            };
//            //capture Disposable
//            Disposable disposable = source.subscribeWith(myObserver);*/
//
//
//            /*// 组合Disposable，统一管理
//            Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS);
//            //subscribe and capture disposables
//            Disposable disposable1 = seconds.subscribe(l -> System.out.println("Observer 1: " + l));
//            Disposable disposable2 = seconds.subscribe(l -> System.out.println("Observer 2: " + l));
//            //put both disposables into CompositeDisposable
//            disposables.addAll(disposable1, disposable2);
//            //sleep 5 seconds
//            sleep(5000);
//            //dispose all disposables
//            disposables.dispose();
//            //sleep 5 seconds to prove
//            //there are no more emissions
//            sleep(5000);*/
//
//            /*// 在Observable里面达到管理disposer的目的
//            Observable<Integer> source = Observable.create(observableEmitter -> {
//                try {
//                    for (int i = 0; i < 1000; i++) {
//                        while (!observableEmitter.isDisposed()) {
//                            observableEmitter.onNext(i);
//                        }
//                        if (observableEmitter.isDisposed()) { return; }
//                    }
//                    observableEmitter.onComplete();
//                } catch (Throwable e) {
//                    observableEmitter.onError(e);
//                }
//            });*/
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static int start = 1;
//    private static int count = 5;
//
//    public static void runProcess() {
//        //run process here
//    }
//
//    private static final CompositeDisposable disposables = new CompositeDisposable();
//
//    Observer<Integer> myObserver = new Observer<Integer>() {
//        private Disposable disposable;
//
//        @Override
//        public void onSubscribe(Disposable disposable) {
//            this.disposable = disposable;
//        }
//
//        @Override
//        public void onNext(Integer value) {
//            //has access to Disposable
//        }
//
//        @Override
//        public void onError(Throwable e) {
//            //has access to Disposable
//        }
//
//        @Override
//        public void onComplete() {
//            //has access to Disposable
//        }
//    };
//
//    /**
//     * 动态监听ObservableValue是否observable
//     * @param fxObservable
//     * @param <T>
//     * @return
//     */
//    private static <T> Observable<T> valuesOf(final ObservableValue<T> fxObservable) {
//        return Observable.create(observableEmitter -> {
//            //emit initial state
//            observableEmitter.onNext(fxObservable.getValue());
//            //emit value changes uses a listener
//            final ChangeListener<T> listener = (observableValue, prev, current) -> observableEmitter.onNext(current);
//            //add listener to ObservableValue
//            fxObservable.addListener(listener);
//            //Handle disposing by specifying cancellable
//            observableEmitter.setCancellable(() -> fxObservable.removeListener(listener));
//        });
//    }
//
//    static class Task implements Callable<String> {
//        @Override
//        public String call() throws Exception {
//            System.out.println("子线程在进行计算");
//            Thread.sleep(3000);
//            int sum = 0;
//            for (int i = 0; i < 100; i++) { sum += i; }
//            return sum + "";
//        }
//    }
//
//}
