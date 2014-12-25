package com.example.tdenisenko.flightreservation.library;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class ParseURL extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... strings) {
        StringBuffer buffer = new StringBuffer();
        try {

            Document doc = Jsoup.connect(strings[0]).get();
           // Get document (HTML page) title
            String title = doc.title();
            buffer.append("Title: " + title + "\r\n");

            // Get meta info
            Elements metaElems = doc.select("meta");
            buffer.append("META DATA\r\n");
            for (Element metaElem : metaElems) {
                String name = metaElem.attr("name");
                String content = metaElem.attr("content");
                buffer.append("name [" + name + "] - content [" + content + "] \r\n");
            }

            Elements topicList = doc.select("h2.topic");
            buffer.append("Topic list\r\n");
            for (Element topic : topicList) {
                String data = topic.text();

                buffer.append("Data [" + data + "] \r\n");
            }

        } catch (Throwable t) {
            t.printStackTrace();
        }

        return buffer.toString();
    }
}

