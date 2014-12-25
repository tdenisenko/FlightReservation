package com.example.tdenisenko.flightreservation.library;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.tdenisenko.flightreservation.R;

public class SingleItemView extends Activity {
	// Declare Variables
    String airlines;
    String flightNumber;
    String departureArrivalTime;
    String arrivalDepartureTime;
    String departureArrivalPlace;
    String arrivalDeparturePlace;
    String seats;
    String kabinClass;
    String price;

    String flag;


	ImageLoader imageLoader = new ImageLoader(this);

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from singleitemview.xml
		setContentView(R.layout.singleitemview);

		Intent i = getIntent();
		// Get the result of rank
        airlines = i.getStringExtra("airlines");
        // Get the result of country
        flightNumber = i.getStringExtra("flightNumber");
        // Get the result of population
        departureArrivalTime = i.getStringExtra("departureArrivalTime");
        arrivalDepartureTime = i.getStringExtra("arrivalDepartureTime");
        // Get the result of country
        departureArrivalPlace = i.getStringExtra("departureArrivalPlace");
        // Get the result of population
        arrivalDeparturePlace = i.getStringExtra("arrivalDeparturePlace");
        seats = i.getStringExtra("seats");
        // Get the result of country
        kabinClass = i.getStringExtra("kabinClass");
        // Get the result of population
        price = i.getStringExtra("price");
		// Get the result of flag
		//flag = i.getStringExtra("flag");

		// Locate the TextViews in singleitemview.xml
		TextView txtairlines = (TextView) findViewById(R.id.Airlines);
		TextView txtflightNumber = (TextView) findViewById(R.id.Flight_number);
		TextView txtdepartureArrivalTime = (TextView) findViewById(R.id.departure_arrival_time);
        TextView txtarrivalDepartureTime = (TextView) findViewById(R.id.arrival_departure_time);
        TextView txtdepartureArrivalPlace = (TextView) findViewById(R.id.departure_arrival_place);
        TextView txtarrivalDeparturePlace = (TextView) findViewById(R.id.arrival_departure_place);
        TextView txtseats = (TextView) findViewById(R.id.seat);
        TextView txtkabinClass = (TextView) findViewById(R.id.Class);
        TextView txtprice = (TextView) findViewById(R.id.price);

		// Locate the ImageView in singleitemview.xml
		//ImageView imgflag = (ImageView) findViewById(R.id.flag);

		// Set results to the TextViews
        txtairlines.setText(airlines);
        txtflightNumber.setText(flightNumber);
        txtdepartureArrivalTime.setText(departureArrivalTime);
        txtarrivalDepartureTime.setText(arrivalDepartureTime);
        txtdepartureArrivalPlace.setText(departureArrivalPlace);
        txtarrivalDeparturePlace.setText(arrivalDeparturePlace);
        txtseats.setText(seats);
        txtkabinClass.setText(kabinClass);
        txtprice.setText(price);
        //BURAYA BUTTON EKLENECEK FAVOURITE FLIGHT USER REGISTERED DEGILSE LOGINE BAGLANACAK.//
		// Capture position and set results to the ImageView
		// Passes flag images URL into ImageLoader.class
		//imageLoader.DisplayImage(flag, imgflag);
	}
}