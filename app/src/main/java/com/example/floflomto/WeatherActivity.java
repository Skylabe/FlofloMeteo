package com.example.floflomto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        Bundle extras = getIntent().getExtras();
        String cityName = extras.getString("cityName");
        TextView txtCity = findViewById(R.id.textCity);
        txtCity.setText(cityName);
    }
}
