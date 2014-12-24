package com.example.tdenisenko.flightreservation.FlightReservation;

/**
 * Created by tdenisenko on 15-Dec-14.
 */

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tdenisenko.flightreservation.R;

import junit.framework.Test;

import java.lang.reflect.Field;

public class CustomOnItemSelectedListener implements OnItemSelectedListener {

    public void onItemSelected(AdapterView<?> parent, View view, int pos,
                               long id) {

        //Field f = R.id.class.getField("spinner" + )
        /*Toast.makeText(parent.getContext(),
                "On Item Select : \n" + parent.getId() + "\n" + R.id.spinner1,
                Toast.LENGTH_LONG).show();*/
        parent.setSelection(pos);
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
    }
}