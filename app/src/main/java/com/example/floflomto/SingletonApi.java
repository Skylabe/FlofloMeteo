package com.example.floflomto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SingletonApi {
    static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    private static WeatherApi instanceAPI;

    public static WeatherApi getInstance() {
        // If instanceAPI doesn't exist, create it before using it
        if(instanceAPI == null){
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            // Create the instanceAPI of CocktailAPI
            instanceAPI = retrofit.create(WeatherApi.class);
        }
        //Set instanceAPI of api
        return instanceAPI;
    }
}
