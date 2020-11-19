package com.example.MyRetail.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class RedSkyRestService {

    String redSkyUrl = "https://redsky.target.com/v3/pdp/tcin/";
    String redSkyParameterUrl = "?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics&key=candidate";

    WebClient webClient = WebClient.create();

    public String getRedSkyJson(String id) {
        return webClient.get()
                .uri(redSkyUrl + id + redSkyParameterUrl)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }


}
