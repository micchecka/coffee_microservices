package com.user.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@org.springframework.context.annotation.Configuration
@Slf4j
public class Configuration {
//    @Bean
//    RestTemplate restTemplate(){
//        return new RestTemplate();
//    }
@Bean
public WebClient.Builder webClientBuilder() {
    return WebClient.builder().filter(ExchangeFilterFunction.ofRequestProcessor(
            clientRequest -> {
                log.info("Request: {} {}", clientRequest.method(), clientRequest.url());
                clientRequest.headers().forEach((name, values) -> values.forEach(value -> log.info("{}={}", name, value)));
                return Mono.just(clientRequest);
            }
    )).filter(ExchangeFilterFunction.ofResponseProcessor(
            clientResponse -> {
                log.info("Response: {}", clientResponse.statusCode());
                return Mono.just(clientResponse);
            }
    ));
}
}
