package com.example.floflomto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

public interface WeatherApi {

    public static final String ENDPOINT = "https://api.openweathermap.org/data/2.5/";

    @GET("weather")
    Call<Weather> searchWeather(@Query("q") String query, @Query("appid") String apiKey);
}