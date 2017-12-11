package com.example.android.sunshine.sync;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;

import com.example.android.sunshine.data.WeatherContract;
import com.example.android.sunshine.utilities.NetworkUtils;
import com.example.android.sunshine.utilities.OpenWeatherJsonUtils;

import java.net.URL;

import static com.example.android.sunshine.data.WeatherContract.WeatherEntry.CONTENT_URI;

//  TODO (1) Create a class called SunshineSyncTask
public class SunshineSyncTask {
    //  TODO (2) Within SunshineSyncTask, create a synchronized public static void method called syncWeather
    synchronized public static void syncWeather(Context context) {
//      TODO (3) Within syncWeather, fetch new weather data
        try {
            // getUrl returns the Url returns the Url for the JSON results
            URL weatherRequestUrl = NetworkUtils.getUrl(context);

            // Use the Url to return the Json
            String jsonWeather = NetworkUtils.getResponseFromHttpUrl(weatherRequestUrl);

            // Parse the Json
            ContentValues[] weatherValues = OpenWeatherJsonUtils
                    .getWeatherContentValuesFromJson(context, jsonWeather);

            // Check for errors and or null data
            if (weatherValues != null && weatherValues.length != 0) {
                // Use the ContentResolver to refresh data
                ContentResolver sunshineContentResolver = context.getContentResolver();

                // TODO (4) If we have valid results, delete the old data and insert the new
                // delete old
                sunshineContentResolver.delete(CONTENT_URI, null, null);

                // insert new
                sunshineContentResolver.bulkInsert(CONTENT_URI, weatherValues);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}