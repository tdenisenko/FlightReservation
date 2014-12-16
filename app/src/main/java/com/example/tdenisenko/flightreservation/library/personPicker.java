package com.example.tdenisenko.flightreservation.library;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.example.tdenisenko.flightreservation.R;

/**
 * Created by SULUNGOZ on 03.12.2014.
 */
public class personPicker extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.person_picker);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.my,menu);
        return true;
    }




}
