package com.rapidapi.api.response;

import com.rapidapi.entity.News;
import com.rapidapi.entity.Quote;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MarketNewsResponse {
    private List<Quote> quote;
    private List<News> news;
}
