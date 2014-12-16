package com.example.tdenisenko.flightreservation;

import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ParseURL extends AsyncTask<String,Void,String> {
    protected String doInBackground(String...strings){
        StringBuffer buffer =new StringBuffer();
        try {
        Log.d("JSwa", "Connecting to [" + strings[0] + "]");
        Document doc= Jsoup.connect(strings[0]).get(); //connect to the remote url and get the DOM representation of the HTML page
        Log.d("JSwa","Connected to ["+strings[0]+"]");
        //get document (HTML page) title
        String title=doc.title();
        Log.d("JSwA","Title ["+title+"]");
        buffer.append("Title:"+title+ "\r\n");

        //Get meta info by selecting
        org.jsoup.select.Elements metaElems = doc.select("meta");
        buffer.append("Meta DATA\r\n");
        for(org.jsoup.nodes.Element metaElem : metaElems){
            String name = metaElem.attr("name");
            String content =metaElem.attr("content");
            buffer.append("name["+name+"] - content["+content+  "]\r\n");

             }
        org.jsoup.select.Elements topicList = doc.select("h2.topic");
        buffer.append("Topic list\r\n");
        for(org.jsoup.nodes.Element topic:topicList){
            String data = topic.text();

            buffer.append("Data["+data+"]\r\n");
        }
        }
        catch(Throwable t){
            t.printStackTrace();;
        }
        return buffer.toString();
    }
    //public void onPostExecute(String s){
      //  super.onPostExecute(s);
        //respText.setText(s);
    // }



}

