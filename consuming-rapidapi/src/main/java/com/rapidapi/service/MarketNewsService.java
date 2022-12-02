package com.rapidapi.service;

import com.rapidapi.api.request.MarketNewRequest;
import com.rapidapi.api.response.MarketNewsResponse;
import com.rapidapi.entity.News;
import com.rapidapi.entity.Quote;
import com.rapidapi.repository.MarketNewsRepository;
import com.rapidapi.utilities.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class MarketNewsService {

    @Autowired
    MarketNewsRepository marketNewsRepository;

    @Value("${restendpoint.bloomberg-market}")
    private String marketnewspath;

    public MarketNewsResponse getMarketNews(String query, String rapidhost, String rapidAPIkey) {
        MarketNewRequest marketNewRequest = new MarketNewRequest();
        List<News> news = new ArrayList<>();
        List<Quote> quotes = new ArrayList<>();
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

        //marketNewRequest.setMarketnewsid(new Random().nextLong());

        news = marketNewsResponse.getNews();
        //news.stream().forEach(news1 -> news1.setNewsId(marketNewRequest.getMarketnewsid()));
        marketNewRequest.setNews(news);

        quotes = marketNewsResponse.getQuote();
        //quotes.stream().forEach(quote -> quote.setQuoteId(marketNewRequest.getMarketnewsid()));
        marketNewRequest.setQuote(quotes);

        marketNewsRepository.save(marketNewRequest);
        return marketNewsResponse;
    }
}
