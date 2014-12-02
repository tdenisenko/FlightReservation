package com.example.tdenisenko.flightreservation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

/**
 * Created by SULUNGOZ on 02.12.2014.
 */
public class cabin extends Activity {
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.cabin_class);
}
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.my,menu);
        return true;
    }

}



}
