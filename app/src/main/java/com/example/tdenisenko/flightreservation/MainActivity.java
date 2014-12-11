package com.example.tdenisenko.flightreservation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class    MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //--- find both the buttons---
        /*Button button1 = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);

        // -- register click event with first button ---
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setContentView(R.layout.activity_main);
            }
        });*/
    }


        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void cabinView(View view) {
        Intent intent = new Intent(this, com.example.tdenisenko.flightreservation.Cabin.class);
        startActivity(intent);
    }
    public void calenderView(View view) {
        Intent intent = new Intent(this, calender.class);
        startActivity(intent);
    }
    public void personView(View view) {
        Intent intent = new Intent(this, personPicker.class);
        startActivity(intent);
    }
    public void searchView(View view) {
        Intent intent = new Intent(this, searchMy.class);
        startActivity(intent);
    }

      public void parserView(View view){
        Intent intent = new Intent(this,ParseURL.class);
        startActivity(intent);
    }

}
