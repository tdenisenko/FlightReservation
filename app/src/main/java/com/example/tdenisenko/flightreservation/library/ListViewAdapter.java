package com.example.tdenisenko.flightreservation.library;

/**
 * Created by ktgry2 on 24.12.2014.
 */

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tdenisenko.flightreservation.R;

import java.util.ArrayList;
import java.util.HashMap;
public class ListViewAdapter extends BaseAdapter {

    // Declare Variables
    Context context;
    LayoutInflater inflater;
    ArrayList<HashMap<String, String>> data;
    ImageLoader imageLoader;
    HashMap<String, String> resultp = new HashMap<String, String>();

    public ListViewAdapter(Context context,
                           ArrayList<HashMap<String, String>> arraylist) {
        this.context = context;
        data = arraylist;
        imageLoader = new ImageLoader(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        // Declare Variables
        TextView airlines;
        TextView flightNumber;
        TextView departureArrivalTime;
        TextView arrivalDepartureTime;
        TextView departureArrivalPlace;
        TextView arrivalDeparturePlace;
        TextView seats;
        TextView kabinClass;
        TextView price;

        ImageView flag;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.listview_item, parent, false);
        // Get the position
        resultp = data.get(position);

        // Locate the TextViews in listview_item.xml
        airlines = (TextView) itemView.findViewById(R.id.Airlines);
        flightNumber = (TextView) itemView.findViewById(R.id.Flight_number);
        departureArrivalTime = (TextView) itemView.findViewById(R.id.departure_arrival_time);
        arrivalDepartureTime = (TextView) itemView.findViewById(R.id.arrival_departure_time);
        departureArrivalPlace = (TextView) itemView.findViewById(R.id.departure_arrival_place);
        arrivalDeparturePlace = (TextView) itemView.findViewById(R.id.arrival_departure_place);
        seats = (TextView) itemView.findViewById(R.id.seat);
        kabinClass = (TextView) itemView.findViewById(R.id.Class);
        price = (TextView) itemView.findViewById(R.id.price);

        // Locate the ImageView in listview_item.xml
        flag = (ImageView) itemView.findViewById(R.id.flag);

        // Capture position and set results to the TextViews
        airlines.setText(resultp.get(SearchHtmlParser.AIRLINES));
        flightNumber.setText(resultp.get(SearchHtmlParser.FLIGHTNUMBER));
        departureArrivalTime.setText(resultp.get(SearchHtmlParser.DEPARTUREARRIVALTIME));
        arrivalDepartureTime.setText(resultp.get(SearchHtmlParser.ARRIVALDEPARTURETIME));
        departureArrivalPlace.setText(resultp.get(SearchHtmlParser.DEPARTUREARRIVALPLACE));
        arrivalDeparturePlace.setText(resultp.get(SearchHtmlParser.ARRIVALDEPARTURETIME));
        seats.setText(resultp.get(SearchHtmlParser.SEATS));
        kabinClass.setText(resultp.get(SearchHtmlParser.KABINCLASS));
        price.setText(resultp.get(SearchHtmlParser.PRICE));
        // Capture position and set results to the ImageView
        // Passes flag images URL into ImageLoader.class
        imageLoader.DisplayImage(resultp.get(SearchHtmlParser.FLAG), flag);
        // Capture ListView item click
        itemView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Get the position
                resultp = data.get(position);
                Intent intent = new Intent(context, SingleItemView.class);
                // Pass all data rank
                intent.putExtra("airlines", resultp.get(SearchHtmlParser.AIRLINES));
                // Pass all data country
                intent.putExtra("flightNumber", resultp.get(SearchHtmlParser.FLIGHTNUMBER));
                // Pass all data population
                intent.putExtra("departureArrivalTime",resultp.get(SearchHtmlParser.DEPARTUREARRIVALTIME));
                intent.putExtra("arrivalDepartureTime", resultp.get(SearchHtmlParser.ARRIVALDEPARTURETIME));
                // Pass all data country
                intent.putExtra("departureArrivalPlace", resultp.get(SearchHtmlParser.DEPARTUREARRIVALPLACE));
                // Pass all data population
                intent.putExtra("arrivalDeparturePlace",resultp.get(SearchHtmlParser.ARRIVALDEPARTUREPLACE));
                intent.putExtra("seats", resultp.get(SearchHtmlParser.SEATS));
                // Pass all data country
                intent.putExtra("kabinclass", resultp.get(SearchHtmlParser.KABINCLASS));
                // Pass all data population
                intent.putExtra("price",resultp.get(SearchHtmlParser.PRICE));
                // Pass all data flag
                intent.putExtra("flag", resultp.get(SearchHtmlParser.FLAG));
                // Start SingleItemView Class
                context.startActivity(intent);

            }
        });
        return itemView;
    }
}
