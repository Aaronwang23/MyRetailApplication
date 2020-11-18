package com.example.MyRetail.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class RedSkyRestService {

    String redSkyUrl = "https://redsky.target.com/v3/pdp/tcin/";
    String redSkyParameterUrl = "?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics&key=candidate";

    WebClient webClient = WebClient.create();

    public String getRedSkyJson(String id) {
        return webClient.get()
                .uri(redSkyUrl + id + redSkyParameterUrl)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("API not found")))
                .onStatus(HttpStatus::is5xxServerError,
                        error -> Mono.error(new RuntimeException("Server is not responding")))
                .bodyToMono(String.class)
                .block();
    }


}
