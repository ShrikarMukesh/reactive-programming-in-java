package com.reactive.sec01;

//import com.rp.courseutil.Util;
import courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {
    public static void main(String[] args) {
        // publisher
        Mono<Integer> mono = Mono.just("ball")
                .map(String::length)
                .map(l -> l / 1);
        // 1
        // mono.subscribe();
        // 2
//        mono.subscribe(
//                item -> System.out.println(item),
//                err-> System.out.println(err.getMessage()),
//                ()-> System.out.println("Completd")
//        );
        mono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}