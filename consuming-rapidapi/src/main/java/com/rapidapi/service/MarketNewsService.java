package com.rapidapi.service;

import com.rapidapi.exchange.MarketNewsResponse;
import com.rapidapi.utilities.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilderFactory;

@Service
public class MarketNewsService {

    @Value("${rest.api.endpoint.bloomberg-market}")
    private String marketnewspath;

    @Value("${rapid.api.apiKey}")
    private String rapidKey;

    public MarketNewsResponse getMarketNews(String query, String rapidhost, String rapidAPIkey) {

        WebClient webClient = WebClient.builder()
                .baseUrl(marketnewspath)
                .defaultHeader(Constants.RAPIDAPI_HOST,rapidhost)
                .defaultHeader(Constants.RAPIDAPI_KEY, rapidAPIkey)
                .build();

        MarketNewsResponse marketNewsResponse = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("query", query)
                        .build())
                        .retrieve()
                        .bodyToMono(MarketNewsResponse.class)
                        .block();
        return marketNewsResponse;
    }
}
