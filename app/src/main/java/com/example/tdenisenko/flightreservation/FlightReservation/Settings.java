package com.example.tdenisenko.flightreservation.FlightReservation;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.example.tdenisenko.flightreservation.R;

/**
 * Created by SULUNGOZ on 13.12.2014.
 */
public class Settings extends PreferenceActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.layout.settings);

    }



}
