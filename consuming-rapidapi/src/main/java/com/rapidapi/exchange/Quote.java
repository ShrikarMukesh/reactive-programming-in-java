package com.rapidapi.exchange;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Quote {
    private String securityType;
    private String symbol;;
    private String exchange;
    private String country;
    private String currency;
    private String resourceType;
    private String fundamentalDataCurrency;;
    private String resourceSubtype;
    private String region;
    private String ticker;
    private String tickerName;;
    private String template;
    private String tinyName;
    private String name;
    private String watchlist;
    private String resourceId;
    private String id;
    private String title;
    private String card;

}
