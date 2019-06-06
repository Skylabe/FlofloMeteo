package com.example.floflomto;

import com.example.floflomto.WeatherApi;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class WeatherActivity extends AppCompatActivity {

    private WeatherApi weatherApi;
    private final String appId = "2fb9973d5970eb11d09ee8aee644585e";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        weatherApi = SingletonApi.getInstance();

        Bundle extras = getIntent().getExtras();
        String cityName = extras.getString("cityName");

        searchWeatherByCity(cityName);

    }

    public void searchWeatherByCity(String cityName) {
        Call<Weather> call = weatherApi.searchWeather(cityName, appId); // Search cocktail by name
        // Put call in async queue
        call.enqueue(
                new Callback<Weather>() {
                    //On response
                    public void onResponse(Call<Weather> call, Response<Weather> response) {
                        Weather weather = response.body(); // Deserialize response body into objects

                        if (response.isSuccessful()) {
                            String name = weather.getName();
                            TextView txtView = findViewById(R.id.textCity);
                            txtView.setText(name);
                        }
                    }

                    // On failure
                    @Override
                    public void onFailure(Call<Weather> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "ERROR : API not reachable", Toast.LENGTH_LONG).show();
                        t.printStackTrace();
                    }
                }
        );
    }
}

