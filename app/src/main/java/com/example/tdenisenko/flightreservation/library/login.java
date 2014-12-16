package com.example.tdenisenko.flightreservation.library;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tdenisenko.flightreservation.R;

/**
 * Created by ktgry2 on 16.12.2014.
 */
public class login extends Activity {
    private EditText  username=null;
    private EditText  password=null;
    private TextView attempts;
    private Button login;
    int counter = 3;
    /*public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;
    public static final String name = "nameKey";
    public static final String pass = "passwordKey";*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login1);
        username = (EditText)findViewById(R.id.editText1);
        password = (EditText)findViewById(R.id.editText2);
        attempts = (TextView)findViewById(R.id.textView5);
        attempts.setText(Integer.toString(counter));
        login = (Button)findViewById(R.id.button1);
    }
   /* protected void onResume() {
        sharedpreferences=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        if (sharedpreferences.contains(name))
        {
            if(sharedpreferences.contains(pass)){
                Intent i = new Intent(this,com.example.tdenisenko.flightreservation.searchMy.class);
                startActivity(i);
            }
        }
        super.onResume();
    }*/

    public void login(View view){
        if(username.getText().toString().equals("admin") &&
                password.getText().toString().equals("admin")){

            Toast.makeText(getApplicationContext(), "Redirecting...",
                    Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(), "Logged in",
                    Toast.LENGTH_SHORT).show();
            /*SharedPreferences.Editor editor = sharedpreferences.edit();
            String u = username.getText().toString();
            String p = password.getText().toString();
            editor.putString(name, u);
            editor.putString(pass, p);
            editor.commit();
            Intent i = new Intent(this,com.example.tdenisenko.flightreservation.searchMy.class);
            startActivity(i);*/
        }
        else{
            Toast.makeText(getApplicationContext(), "Wrong Credentials",
                    Toast.LENGTH_SHORT).show();
            attempts.setBackgroundColor(Color.RED);
            counter--;
            attempts.setText(Integer.toString(counter));
            if(counter==0){
                login.setEnabled(false);
            }

        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

}

