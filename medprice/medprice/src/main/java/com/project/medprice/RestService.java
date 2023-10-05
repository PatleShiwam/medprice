package com.project.medprice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@org.springframework.stereotype.Service
public class RestService {

    private final WebClient.Builder webClientBuilder;
    
    private WebClient webClient;

    @Autowired
    public RestService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }
    
    public Mono<String> getDrugInfo(String medName) {

        this.webClient = webClientBuilder.baseUrl("https://drug-info-and-price-history.p.rapidapi.com").build();
        Mono<String> data=webClient.get()
                .uri("/1/druginfo?drug={medName}",medName)
                .header("X-RapidAPI-Key", "fc69a4ed61mshe93b3e09faebc99p14178bjsna22c0428b63d")
                .header("X-RapidAPI-Host", "drug-info-and-price-history.p.rapidapi.com")
                .retrieve()
                .bodyToMono(String.class);
        data.subscribe(
            response->{ System.out.println(response);},
            error ->{System.err.println("Error "+error.getMessage());}
         );

         return data;
    }
   
}
