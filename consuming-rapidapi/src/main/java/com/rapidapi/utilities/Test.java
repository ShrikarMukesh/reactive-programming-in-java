package com.rapidapi.utilities;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://bloomberg-market-and-financial-news.p.rapidapi.com/market/auto-complete?query=Mindtree")
                .get()
                .addHeader("X-RapidAPI-Key", "38194831b2msh48d54d791a849a9p1d41b4jsn1ac3f1926579")
                .addHeader("X-RapidAPI-Host", "bloomberg-market-and-financial-news.p.rapidapi.com")
                .build();

        Response response = client.newCall(request).execute();
        System.out.println(response.body().byteString());
    }
}
