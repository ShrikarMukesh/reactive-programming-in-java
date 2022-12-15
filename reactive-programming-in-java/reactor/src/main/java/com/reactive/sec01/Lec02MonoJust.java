package com.reactive.sec01;

import reactor.core.publisher.Mono;

public class Lec02MonoJust {
    public static void main(String[] args) {

        //publisher
        Mono<String> mono = Mono.just("I am Publisher");

        System.out.println(mono);

        mono.subscribe(s -> System.out.println("Received Message from publisher : " + s));
    }
}
