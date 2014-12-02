package com.example.tdenisenko.flightreservation;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

/**
 * Created by SULUNGOZ on 03.12.2014.
 */
public class searchMy extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.my,menu);
        return true;
    }
}
