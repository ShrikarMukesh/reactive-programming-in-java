package com.rapidapi.api.request;

import com.rapidapi.entity.News;
import com.rapidapi.entity.Quote;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "marketnews")
public class MarketNewRequest {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long marketnewsid;

    @OneToMany(mappedBy = "qmnr" ,cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    private List<Quote> quote;

    @OneToMany(mappedBy = "nmrn" ,cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    private List<News> news;
}
