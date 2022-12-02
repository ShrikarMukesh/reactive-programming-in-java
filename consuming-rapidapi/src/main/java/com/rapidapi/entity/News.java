package com.rapidapi.entity;

import com.rapidapi.api.request.MarketNewRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long newsId;

    private String title;
    private String id;
    private String card;
    private String date;
    private String longURL;

    @JoinColumn(name = "marketnewsid")
    @ManyToOne
    private MarketNewRequest nmrn;
}
