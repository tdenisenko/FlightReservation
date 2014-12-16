package com.example.tdenisenko.flightreservation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class SearchHtmlParser extends Activity {
    final EditText respText =(EditText) findViewById(R.id.edtResp);
    final EditText edtURL =(EditText) findViewById(R.id.edtURL);
    public void onCreate(Bundle savedUInstanceState){
            //test için oluşturlacak text fieldı
        super.onCreate(savedUInstanceState);
        setContentView(R.layout.parser_test);

        Button btnGo=(Button) findViewById(R.id.btnGo);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String siteUrl = edtURL.getText().toString();
                (new ParseURL()).execute(new String[]{siteUrl});

            }
        });

        }




    //http://www.skyscanner.com.tr/tasima/ucak-bileti/tr/us/141207/141208/en_ucuz_ucuslar-kalkis-turkiye-varis-amerika-birlesik-devletleri-icinde-aralik-2014.html?rtn=1
    //tr = kalkış, us varış, 141207 tarih 1,141208 tarih 2/en_ucuz_ucuslar-kalkis-turkiye-varis-amerika-birlesik-devletleri-icinde-aralik-2014.html?rtn=1

}

