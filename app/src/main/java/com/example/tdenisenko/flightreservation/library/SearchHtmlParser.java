package com.example.tdenisenko.flightreservation.library;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.tdenisenko.flightreservation.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;


public class SearchHtmlParser extends Activity {
    ListView listview;
    ListViewAdapter adapter;
    ProgressDialog mProgressDialog;
    ArrayList<HashMap<String, String>> arraylist;
    static String RANK = "rank";
    static String COUNTRY = "country";
    static String POPULATION = "population";
    static String FLAG = "flag";
    // URL Address
    //String url = "http://www.enuygun.com/ucak-bileti/barcelona-airport/istanbul/?gidis=26.12.2014&donus=28.12.2014&yetiskin=1";
    String url = "http://online.alobilethatti.com/Home/Search?fromAirport=%C4%B0stanbul%2CAtaturk%2CT%C3%BCrkiye%20(IST)&fromAirportCode=IST-IST&toAirport=Barselona%2CEl%20Parat%20Airport%2C%C4%B0spanya%20(BCN)&toAirportCode=BCN-BCN&fromDate=27.12.2014&toDate=03.01.2015&adult=1&child=0&infant=0&senior=0&young=0&military=0&student=0&flightType=RET";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from listview_main.xml
        setContentView(R.layout.listview_main);
        // Execute DownloadJSON AsyncTask
        new JsoupListView().execute();

    }

    // Title AsyncTask
    private class JsoupListView extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(SearchHtmlParser.this);
            // Set progressdialog title
            mProgressDialog.setTitle("Searching for Flights");
            // Set progressdialog message
            mProgressDialog.setMessage("Returning requested flights...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();
        }

        /*@Override
        protected Void doInBackground(Void... params) {
            // Create an array
            arraylist = new ArrayList<HashMap<String, String>>();

            try {
                // Connect to the Website URL
                Document doc = Jsoup.connect(url).get();
                // Identify Table Class "worldpopulation"
                for (Element table : doc.select("table[class=worldpopulation]")) {

                    // Identify all the table row's(tr)
                    for (Element row : table.select("tr:gt(0)")) {
                        HashMap<String, String> map = new HashMap<String, String>();

                        // Identify all the table cell's(td)
                        Elements tds = row.select("td");

                        // Identify all img src's
                        Elements imgSrc = row.select("img[src]");
                        // Get only src from img src
                        String imgSrcStr = imgSrc.attr("src");

                        // Retrive Jsoup Elements
                        // Get the first td
                        map.put("rank", tds.get(0).text());
                        // Get the second td
                        map.put("country", tds.get(1).text());
                        // Get the third td
                        map.put("population", tds.get(2).text());
                        // Get the image src links
                        map.put("flag", imgSrcStr);
                        // Set all extracted Jsoup Elements into the array
                        arraylist.add(map);
                    }
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return null;
        }*/

        @Override
        protected Void doInBackground(Void... params) {
            // Create an array
            arraylist = new ArrayList<HashMap<String, String>>();

            try {
                // Connect to the Website URL
                Document doc = Jsoup.connect(url).get();
                // Identify Table Class "worldpopulation"
                for (Element table : doc.select("ul[id=lstFromFlights]")) {

                    // Identify all the table row's(tr)
                    for (Element row : table.select("li:gt(0)")) {
                        HashMap<String, String> map = new HashMap<String, String>();

                        // Identify all the table cell's(td)
                        Elements divs = row.select("div").select("div");

                        // Identify all img src's
                        Elements imgSrc = row.select("img[src]");
                        // Get only src from img src
                        String imgSrcStr = imgSrc.attr("src");

                        // Retrive Jsoup Elements
                        // Get the first td
                        map.put("rank", divs.get(0).text());
                        // Get the second td
                        map.put("country", divs.get(1).text());
                        // Get the third td
                        map.put("population", divs.get(2).text());
                        // Get the image src links
                        map.put("flag", imgSrcStr);
                        // Set all extracted Jsoup Elements into the array
                        arraylist.add(map);
                    }
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return null;
        }
/*
        @Override
        protected Void doInBackground(Void... params) {
            // Create an array
            arraylist = new ArrayList<HashMap<String, String>>();
            Log.d("doInBackground", "started");

            try {
                // Connect to the Website URL
                //org.jsoup.Connection cnt = Jsoup.connect(url);
                //Thread.sleep(15000);
                //Document doc = cnt.get();
                Document doc = Jsoup.connect(url).get();
                Thread.sleep(3000);

                //Element list = doc.select("div[class=flight-list-in]");
                // Identify Table Class "worldpopulation"
                Elements table2 = doc.select("ul[id=lstFromFlights]");
                String asd = table2.get(0).text();
                Log.d("noluyor", asd);
                table2 = table2.select("li:gt(0)");
                String attr2 = table2.attr("price");
                Log.d("noluyor", attr2);
                for (Element table : doc.select("ul[id=lstFromFlights]")) {

                    HashMap<String, String> map = new HashMap<String, String>();
                    //Elements props = table.select("li:gt(0)");
                    Log.d("asd", table.text());

                    String price = table.select("li").attr("price");
                    Log.d("asd", table.select("li").text());
                    //String departuretime = table.attr("departuretime");
                    //props = table.select("div[class=row-group]");
                    Elements logo = table.select("img[name=AirlineLogo");
                    String airlineCompany = logo.attr("alt");
                    String imgSrc = logo.attr("src");
                    String flightNo = table.select("div[class=row-group]").get(1).text();

                    // Identify all the table cell's(td)
                    //Elements tds = row.select("td");

                    // Identify all img src's
                    //Elements imgSrc = row.select("img[src]");
                    // Get only src from img src
                    //String imgSrcStr = imgSrc.attr("src");

                    // Retrive Jsoup Elements
                    // Get the first td
                    map.put("rank", price);
                    // Get the second td
                    map.put("country", airlineCompany);
                    // Get the third td
                    map.put("population", flightNo);
                    // Get the image src links
                    map.put("flag", imgSrc);
                    // Set all extracted Jsoup Elements into the array
                    arraylist.add(map);
                    //}
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }*/

        @Override
        protected void onPostExecute(Void result) {
            // Locate the listview in listview_main.xml
            listview = (ListView) findViewById(R.id.listview);
            // Pass the results into ListViewAdapter.java
            adapter = new ListViewAdapter(SearchHtmlParser.this, arraylist);
            // Set the adapter to the ListView
            listview.setAdapter(adapter);
            // Close the progressdialog
            mProgressDialog.dismiss();
        }
    }

}