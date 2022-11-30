package com.rapidapi.controller;

import com.rapidapi.exchange.MarketNewsResponse;
import com.rapidapi.service.MarketNewsService;
import com.rapidapi.utilities.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarketNewsController {

    private MarketNewsService marketNewsService;

    public MarketNewsController(MarketNewsService marketNewsService){
        this.marketNewsService = marketNewsService;
    }

    @GetMapping("/market")
    public ResponseEntity<MarketNewsResponse> getMarketNewsOfOrganization(
            @RequestParam String query,
            @RequestHeader(name = Constants.RAPIDAPI_HOST , required = true) String rapidhost,
            @RequestHeader(name = Constants.RAPIDAPI_KEY , required = true) String rapidAPIkey)
    {
        MarketNewsResponse marketNewsResponse = new MarketNewsResponse();
        marketNewsResponse = marketNewsService.getMarketNews(query,rapidhost,rapidAPIkey);
        return new ResponseEntity<>(marketNewsResponse , HttpStatus.OK);
    }
}
