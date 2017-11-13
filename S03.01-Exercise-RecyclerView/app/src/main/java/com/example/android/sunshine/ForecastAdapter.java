package com.example.android.sunshine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * com.example.android.sunshine
 * Created by Peter Wanden on 13/11/2017.
 */

// COMPLETED (22) Extend RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder>
public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder>{

    // COMPLETED (23) Create a private string array called mWeatherData
    private String[] mWeatherData;


    // COMPLETED (47) Create the default constructor (we will pass in parameters in a later lesson)
    public ForecastAdapter () {

    }

    // COMPLETED (16) Create a class within ForecastAdapter called ForecastAdapterViewHolder
    // COMPLETED (17) Extend RecyclerView.ViewHolder
    public class ForecastAdapterViewHolder extends RecyclerView.ViewHolder {
        // Within ForecastAdapterViewHolder ///////////////////////////////////////////////////////
        // COMPLETED (18) Create a public final TextView variable called mWeatherTextView
        public final TextView mWeatherTextView;

        // COMPLETED (19) Create a constructor for this class that accepts a View as a parameter
        public ForecastAdapterViewHolder(View itemView) {
            // COMPLETED (20) Call super(view) within the constructor for ForecastAdapterViewHolder
            super(itemView);
            // COMPLETED (21) Using view.findViewById, get a reference to this layout's TextView and save it to mWeatherTextView
            mWeatherTextView = (TextView) itemView.findViewById(R.id.tv_weather_data);
        }
        // Within ForecastAdapterViewHolder ///////////////////////////////////////////////////////
    }

    // COMPLETED (24) Override onCreateViewHolder
    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.forecast_list_item;
        // COMPLETED (25) Within onCreateViewHolder, inflate the list item xml into a view
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        // COMPLETED (26) Within onCreateViewHolder, return a new ForecastAdapterViewHolder with the above view passed in as a parameter
        return new ForecastAdapterViewHolder(view);
    }

    // COMPLETED (27) Override onBindViewHolder
    @Override
    public void onBindViewHolder(ForecastAdapterViewHolder holder, int position) {
        // COMPLETED (28) Set the text of the TextView to the weather for this list item's position
        String todayWeather = mWeatherData[position];
        holder.mWeatherTextView.setText(todayWeather);
    }

    /**
     * This method simply returns the number of items to display. It is used behind the scenes
     * to help layout our Views and for animations.
     *
     * @return The number of items available
     */
    // COMPLETED (29) Override getItemCount
    @Override
    // COMPLETE (30) Return 0 if mWeatherData is null, or the size of mWeatherData if it is not null
    public int getItemCount() {
        if (mWeatherData == null) {
            return 0;
        }
        return mWeatherData.length;
    }
    // COMPLETED (31) Create a setWeatherData method that saves the weatherData to mWeatherData
    // COMPLETED (32) After you save mWeatherData, call notifyDataSetChanged
    public void setWeatherData(String weatherData[]){
        mWeatherData = weatherData;
        notifyDataSetChanged();
    }
}
