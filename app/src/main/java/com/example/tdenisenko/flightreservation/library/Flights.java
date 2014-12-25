package com.example.tdenisenko.flightreservation.library;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.tdenisenko.flightreservation.FlightReservation.CustomOnItemSelectedListener;
import com.example.tdenisenko.flightreservation.R;


public class Flights extends Activity {


    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flights);

        spinner1 = (Spinner) findViewById(R.id.city_spinner);
        spinner2 = (Spinner) findViewById(R.id.fav_spinner);
        spinner3 = (Spinner) findViewById(R.id.offers_spinner);


        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.city_spinner, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.fav_spinner, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,R.array.offers_spinner, android.R.layout.simple_spinner_item);



        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter2);
        spinner3.setAdapter(adapter3);



        addListenerOnSpinnerItemSelection();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }
    public void addListenerOnSpinnerItemSelection(){
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        spinner2.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        spinner3.setOnItemSelectedListener(new CustomOnItemSelectedListener());


    }
}
