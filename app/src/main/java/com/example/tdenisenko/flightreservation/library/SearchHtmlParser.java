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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


public class SearchHtmlParser extends Activity {
    ListView listview;
    ListViewAdapter adapter;
    ProgressDialog mProgressDialog;
    ArrayList<HashMap<String, String>> arraylist;



    static String AIRLINES = "airlines";
    static String FLIGHTNUMBER = "flightNumber";
    static String DEPARTUREARRIVALTIME = "departureArrivalTime";
    static String ARRIVALDEPARTURETIME = "arrivalDepartureTime";
    static String DEPARTUREARRIVALPLACE = "departureArrivalPlace";
    static String ARRIVALDEPARTUREPLACE = "arrivalDeparturePlace";
   // static String SEATS = "seats";
    static String KABINCLASS = "kabinclass";
    static String PRICE = "price";
    static String FLAG= "flag";
    String from;
    String fromCode;
    //String fromCityCode = "AYT";
    String fromDate = "27.12.2014";
    String to;
    String toCode;
    //String toCityCode = "ANK";
    String toDate = "01.01.2015";

    int adult, child, infant;
    String flightType = "ONE";
    // URL Address
    //String url = "http://www.enuygun.com/ucak-bileti/barcelona-airport/istanbul/?gidis=26.12.2014&donus=28.12.2014&yetiskin=1";

    String url;
    //String url = "http://online.alobilethatti.com/Home/Search?fromAirport=%C4%B0stanbul%2C%20Sabiha%20Gokcen%2C%20T%C3%BCrkiye%20(SAW)&fromAirportCode=SAW-IST&toAirport=Antalya%2C%20Antalya%2C%20T%C3%BCrkiye%20(AYT)&toAirportCode=AYT-AYT&fromDate=27.12.2014&toDate=01.01.2015&adult=1&child=0&infant=0&senior=0&young=0&military=0&student=0&flightType=ONE";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from listview_main.xml
        setContentView(R.layout.listview_main);
        // Execute DownloadJSON AsyncTask
        new JsoupListView().execute();
        //if (flightType.equals("RET")) {
        Bundle b = getIntent().getExtras();
        String[] arr1 = b.getString("departure").split("\\|");
        Log.d("what", arr1[0] + " and " + arr1[1]);
        from = arr1[1];
        fromCode = arr1[0];
        String[] arr2 = b.getString("arrival").split("\\|");
        to = arr2[1];
        toCode = arr2[0];
        adult = b.getInt("adult");
        child = b.getInt("child");
        infant = b.getInt("infant");
        String[] arr3 = b.getString("depDate").split("/");
        fromDate = arr3[0] + "." + arr3[1] + "." + arr3[2];
        //Log.d("tirrak", fromDate);
        //fromDate = fromDate.charAt(0) + fromDate.charAt(1) + "." + fromDate.charAt(3) + fromDate.charAt(4) + "." + fromDate.charAt(6) + fromDate.charAt(7);
        //toDate = b.getString("arrDate");
        String[] arr4 = b.getString("arrDate").split("/");
        toDate = arr4[0] + "." + arr4[1] + "." + arr4[2];
        //toDate = toDate.charAt(0) + toDate.charAt(1) + "." + toDate.charAt(3) + toDate.charAt(4) + "." + toDate.charAt(6) + toDate.charAt(7);
        //Log.d("tirrak", fromDate);
        url = "http://online.alobilethatti.com/Home/Search?fromAirport=" + from + "&fromAirportCode=" + fromCode + "&toAirport=" + to + "&toAirportCode=" + toCode + "&fromDate=" + fromDate + "&toDate=" + toDate + "&adult=" + adult + "&child=" + child + "&infant" + infant + "&senior=0&young=0&military=0&student=0&flightType=" + flightType;
        //} else {
        //    String url = "http://online.alobilethatti.com/Home/Search?fromAirport=" + from + "&fromAirportCode=" + fromCode + "-" + fromCityCode + "&toAirport=" + to + "&toAirportCode=" + toCode + "-" + toCityCode + "&fromDate=" + fromDate + "&toDate=" + toDate + "&adult=" + adult + "&child=" + child + "&infant" + infant + "&senior=0&young=0&military=0&student=0&flightType=" + flightType;
        //}
        //Log.d("troll", url);

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
                        //Elements divs = row.select("div").select("div");

                        String price = row.attr("price");

                        Elements divs = row.select("div");
                        String airlineCompany = divs.select("div").select("img").attr("alt");
                        String flightId = divs.select("div:eq(1)").text();
                        String depTime = divs.select("div:eq(2)").select("span[name=DepartureTime]").text();
                        String arrTime = divs.select("div:eq(2)").select("span[name=ArrivalTime]").text();
                        String depAirport = divs.select("div:eq(3)").select("span[name=DepartureAirportName]").text();
                        String arrAirport = divs.select("div:eq(3)").select("span[name=ArrivalAirportName]").text();
                        String classes = divs.select("div:eq(4)").select("span").text().substring(0, 25);

                        //Log.d("dogrumu", arrAirport);
                        // Identify all img src's
                        Elements imgSrc = row.select("img[src]");
                        // Get only src from img src
                        String imgSrcStr = imgSrc.attr("src");

                        // Retrive Jsoup Elements
                        map.put("departureArrivalTime", depTime);
                        map.put("arrivalDepartureTime", arrTime);
                        map.put("departureArrivalPlace", depAirport);
                        map.put("arrivalDeparturePlace", arrAirport);
                        map.put("kabinclass", classes);
                        // Get the first td
                        map.put("price", price);
                        // Get the second td
                        map.put("airlines", airlineCompany);//divs.get(1).text());
                        // Get the third td
                        map.put("flightNumber", flightId);//divs.get(2).text());
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