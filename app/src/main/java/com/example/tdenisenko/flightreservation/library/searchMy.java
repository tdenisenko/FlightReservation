package com.example.tdenisenko.flightreservation.library;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tdenisenko.flightreservation.FlightReservation.Settings;
import com.example.tdenisenko.flightreservation.R;
import com.example.tdenisenko.flightreservation.login.HomeActivity;
import com.example.tdenisenko.flightreservation.login.LoginDataBaseAdapter;
import com.example.tdenisenko.flightreservation.login.SignUPActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


/**
 * Created by SULUNGOZ on 03.12.2014.
 */
public class searchMy extends Activity {
    private static final int RESULT_SETTINGS = 1;
    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    private Spinner spinner4;
    private TextView textView1;
    private TextView textView2;
    private EditText departure;
    private EditText arrival;
    private Button flights;
    private Button login;
    Calendar myCalendar = Calendar.getInstance();

    Button btnSignIn,btnSignUp;
    LoginDataBaseAdapter loginDataBaseAdapter;

    DatePickerDialog.OnDateSetListener date1 = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel1();
        }

    };
    DatePickerDialog.OnDateSetListener date2 = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel2();
        }

    };



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);


        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner4 = (Spinner) findViewById(R.id.spinner4);
        textView1 = (TextView)findViewById(R.id.depdateTextView);
        textView2 = (TextView)findViewById(R.id.arrdateTextView);
        departure = (EditText) findViewById(R.id.departure_editText);
        arrival = (EditText) findViewById(R.id.arrival_editText);
        login = (Button) findViewById(R.id.loginButton);
        flights = (Button) findViewById(R.id.flights);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.spinner1, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.spinner2, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,R.array.spinner3, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this,R.array.spinner4, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter2);
        spinner3.setAdapter(adapter3);
        spinner4.setAdapter(adapter4);

        // Spinner item selection Listener
        addListenerOnSpinnerItemSelection();

        textView1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(searchMy.this, date1, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(searchMy.this, date2, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }
    // Add spinner data
    public void addListenerOnSpinnerItemSelection(){
        /*spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        spinner2.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        spinner3.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        spinner4.setOnItemSelectedListener(new CustomOnItemSelectedListener());*/
    }
    //get the selected dropdown list value
    public void addListenerOnButton() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner4 = (Spinner) findViewById(R.id.spinner4);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    private void updateLabel1() {

        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ENGLISH);

        textView1.setText(sdf.format(myCalendar.getTime()));
    }
    private void updateLabel2() {

        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ENGLISH);

        textView2.setText(sdf.format(myCalendar.getTime()));
    }

    public void loginView(View view) {
        //Intent intent = new Intent(this, HomeActivity.class);
        //startActivity(intent);
        if (login.getText().toString().compareTo("Login") == 0) {
            loginDataBaseAdapter = new LoginDataBaseAdapter(this);
            loginDataBaseAdapter = loginDataBaseAdapter.open();
            signIn(login);
        } else {
            Toast.makeText(getApplicationContext(), "Logged out", Toast.LENGTH_LONG).show();
            login.setText("Login");
            flights.setVisibility(View.GONE);
        }

        //loginDataBaseAdapter.close();
    }
    public void signIn(View V)
    {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.login);
        dialog.setTitle("Login");

        // get the Refferences of views
        final  EditText editTextUserName=(EditText)dialog.findViewById(R.id.editTextUserNameToLogin);
        final  EditText editTextPassword=(EditText)dialog.findViewById(R.id.editTextPasswordToLogin);

        Button btnSignIn=(Button)dialog.findViewById(R.id.buttonSignIn);
        Button btnSignUp=(Button)dialog.findViewById(R.id.buttonSignUp);

        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                //Toast.makeText(getApplicationContext(), "done", Toast.LENGTH_LONG).show();
                loginDataBaseAdapter.close();
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub

                /// Create Intent for SignUpActivity  and Start The Activity
                Intent intentSignUP=new Intent(getApplicationContext(),SignUPActivity.class);
                startActivity(intentSignUP);
            }
        });

        // Set On ClickListener
        btnSignIn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // get The User name and Password
                String userName=editTextUserName.getText().toString();
                String password=editTextPassword.getText().toString();

                // fetch the Password form database for respective user name
                String storedPassword=loginDataBaseAdapter.getSingleEntry(userName);

                // check if the Stored password matches with  Password entered by user
                if(password.equals(storedPassword))
                {
                    Toast.makeText(getApplicationContext(), "Congrats: Login Successfull", Toast.LENGTH_LONG).show();
                    loginDataBaseAdapter.close();
                    login.setText("Logout");
                    flights.setVisibility(View.VISIBLE);
                    dialog.dismiss();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "User Name or Password does not match", Toast.LENGTH_LONG).show();
                }
            }
        });

        dialog.show();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_settings:
                Intent i = new Intent(this, Settings.class);
                startActivityForResult(i, RESULT_SETTINGS);
                break;

        }

        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case RESULT_SETTINGS:
                showUserSettings();
                break;

        }

    }

    private void showUserSettings() {

        SharedPreferences sharedPrefs = PreferenceManager
                .getDefaultSharedPreferences(this);

        StringBuilder builder = new StringBuilder();

        builder.append("\n Username: "
                + sharedPrefs.getString("prefUsername", "NULL"));

        builder.append("\n Send report:"
                + sharedPrefs.getBoolean("prefSendReport", false));

        builder.append("\n Sync Frequency: "
                + sharedPrefs.getString("prefSyncFrequency", "NULL"));

        TextView settingsTextView = (TextView) findViewById(R.id.textUserSettings);

        settingsTextView.setText(builder.toString());
    }

    public void openSiteView(View view){
        String url = "http://www.skyscanner.com/transport/flights/";

        url += departure.getText().toString().toLowerCase();
        url += "/";
        url += arrival.getText().toString().toLowerCase();
        url += "/";
        String dateArr[] = new String[3];
        dateArr = textView1.getText().toString().split("/");
        url += dateArr[2] + dateArr[1] + dateArr[0];
        url += "/";
        dateArr = textView2.getText().toString().split("/");
        url += dateArr[2] + dateArr[1] + dateArr[0];

        if (!url.startsWith("http://") && !url.startsWith("https://"))
            url = "http://" + url;
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
        //Uri uri = Uri.parse(url);
        //Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        //startActivity(intent);
        //WebView webview = new WebView(this);
        //setContentView(webview);
        //webview.loadUrl(url);
    }


}

