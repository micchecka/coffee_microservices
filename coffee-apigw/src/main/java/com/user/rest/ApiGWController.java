package com.user.rest;

import com.user.DTO.InitialDataResponse;
import com.user.domain.Bucket;
import com.user.domain.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping()
@Slf4j
public class ApiGWController {
    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping()
    public Mono<ResponseEntity<InitialDataResponse>> getInitialData(@RequestHeader HttpHeaders headers) {
//        WebClient menuServiceClient = webClientBuilder.baseUrl("http://localhost:8083/api/v1").build();
//          WebClient bucketServiceClient = webClientBuilder.baseUrl("http://localhost:8082/api/v1").build();
          WebClient menuServiceClient = webClientBuilder.baseUrl("http://coffee_menu:8083/api/v1").build();
          WebClient bucketServiceClient = webClientBuilder.baseUrl("http://coffee-bucket:8082/api/v1").build();


        // Асинхронные запросы к сервисам
        Mono<List<Item>> itemMono = menuServiceClient.get()
                .uri("/menu")
                .retrieve()
                .bodyToFlux(Item.class) // или DTO
                .onErrorResume(e -> {
                    log.error("Error calling coffee_menu service", e);
                    return Mono.empty();
                })
                .collectList();
               // .map(ResponseEntity::ok)
                //.defaultIfEmpty(ResponseEntity.notFound().build());

       Mono<Bucket> bucketMono = bucketServiceClient.get()
                .uri("/bucket")
               .headers(httpHeaders -> httpHeaders.addAll(headers))
                .retrieve()
                .bodyToMono(Bucket.class)
               .onErrorResume(e -> {
                   log.error("Error calling coffee_menu service", e);
                   return Mono.empty();
               });
        ;
//                .map(ResponseEntity::ok)
//                .defaultIfEmpty(ResponseEntity.notFound().build());

        // Агрегация данных
        return Mono.zip(itemMono, bucketMono, (item, bucket) -> new InitialDataResponse(item, bucket))
                .map(response -> ResponseEntity.ok(response)).defaultIfEmpty(ResponseEntity.notFound().build());


    }

}
