package com.example.tdenisenko.flightreservation.library;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.example.tdenisenko.flightreservation.R;


public class Flights extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flights);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

}
