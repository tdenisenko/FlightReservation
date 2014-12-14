package com.example.tdenisenko.flightreservation;

import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.renderscript.Element;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class SearchHtmlParser {
    protected void onCreate(Bundle savedUInstanceState){
            //test için oluşturlacak text fieldı
        final EditText edtURL =(EditText) findViewById(R.id.edtURL);
        Button btnGo=(Button) findViewById(R.id.btnGo);
        EditText respText=(EditText)findViewById(R.id.edtResp);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String siteUrl = edtURL.getText().toString();
                (new ParseURL()).execute(new String[](siteUrl));
            }
        });

    }


    //http://www.skyscanner.com.tr/tasima/ucak-bileti/tr/us/141207/141208/en_ucuz_ucuslar-kalkis-turkiye-varis-amerika-birlesik-devletleri-icinde-aralik-2014.html?rtn=1
    //tr = kalkış, us varış, 141207 tarih 1,141208 tarih 2/en_ucuz_ucuslar-kalkis-turkiye-varis-amerika-birlesik-devletleri-icinde-aralik-2014.html?rtn=1

}
public class ParseURL extends AsyncTask<String,Void,String> {
    protected String doInBackground(String...strings){
        StringBuffer buffer =new StringBuffer();
        try {
        Log.d("JSwa","Connecting to ["+strings[0]+"]");
        Document doc= Jsoup.connect("http://www.skyscanner.com.tr/tasima/ucak-bileti/tr/us/141207/141208/en_ucuz_ucuslar-kalkis-turkiye-varis-amerika-birlesik-devletleri-icinde-aralik-2014.html?rtn=1").get();
        Log.d("JSwa","Connected to ["+strings[0]+"]");
        //get document (HTML page) title
        String title=doc.title();
        Log.d("JSwA","Title ["+title+"]");
        buffer.append("Title:"+title+ "\r\n");

        //Get meta info
        Elements metaElems = doc.select("meta");
        buffer.append("Meta DATA\r\n");
        for(Element metaElem : metaElems){
            String name = metaElem.attr("name");
            String content =metaElem.attr("content");
            buffer.append("name["+name+"] - content["+content+"]\r\n");
             }
        Elements topicList = doc.select("h2.topic");
        buffer.append("Topic list\r\n");
        for(Element topic:topicList){
            String data = topic.text();

            buffer.append("Data["+data+"]\r\n");
        }
        }
        catch(Throwable t){
            t.printStackTrace();;
        }
        return buffer.Tostring();
    }

protected void onPostExeccute(String s){
    super.onPostExecute(s);
    respText.setText(s);
}
}
