package com.rapidapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ConsumingRapidapiApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConsumingRapidapiApplication.class, args);
	}
	@Bean
	WebClient webClient(WebClient.Builder builder) {
		return builder.build();
	}
}
