package com.example.android.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";

    // TextView to display the weather string passed with the intent
    private TextView weatherTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Bind the text view to the XML view
        weatherTextView = (TextView) findViewById(R.id.tv_weather_selected);

        // Grab the intent with the selected weather data
        Intent intentThatStartedThisActivity = getIntent();

        // COMPLETED (2) Display the weather forecast that was passed from MainActivity

        // If the intent that started this activity has weather data attached to it...
        if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)) {

            // extract the data to this String...
            String weatherData = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEXT);

            // and display it to the screen
            weatherTextView.setText(weatherData);
        }
    }
}