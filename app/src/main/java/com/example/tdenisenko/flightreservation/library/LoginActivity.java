package com.example.tdenisenko.flightreservation.library;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tdenisenko.flightreservation.R;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends Activity {
    Button btnLogin;
    Button btnLinkToRegister;
    EditText inputEmail;
    EditText inputPassword;
    TextView loginErrorMsg;

    // JSON Response node names
    private static String KEY_SUCCESS = "success";
    private static String KEY_ERROR = "error";
    private static String KEY_ERROR_MSG = "error_msg";

    private static String KEY_NAME = "name";
    private static String KEY_EMAIL = "email";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Toast.makeText(getApplicationContext(), "Loggingin",
                Toast.LENGTH_SHORT).show();
        // Importing all assets like buttons, text fields
        inputEmail = (EditText) findViewById(R.id.loginEmail);
        inputPassword = (EditText) findViewById(R.id.loginPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLinkToRegister = (Button) findViewById(R.id.btnLinkToRegisterScreen);
        loginErrorMsg = (TextView) findViewById(R.id.login_error);
        Toast.makeText(getApplicationContext(), "variableset",
                Toast.LENGTH_SHORT).show();
        // Login button Click Event
        btnLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();
                UserFunctions userFunction = new UserFunctions();
                Log.d("Button", "Login");
                JSONObject json = userFunction.loginUser(email, password);
                Toast.makeText(getApplicationContext(), "clicked",
                        Toast.LENGTH_SHORT).show();
                // check for login1 response
                try {
                    if (json.getString(KEY_SUCCESS) != null) {
                        loginErrorMsg.setText("");
                        String res = json.getString(KEY_SUCCESS);
                        if(Integer.parseInt(res) == 1){
                            // user successfully logged in
                            // Store user details in SQLite Database
                            DatabaseHandler db = new DatabaseHandler(getApplicationContext());
                            JSONObject json_user = json.getJSONObject("user");

                            // Clear all previous data in database
                            userFunction.logoutUser(getApplicationContext());
                            db.addUser(json_user.getString(KEY_NAME), json_user.getString(KEY_EMAIL));

                            // Launch Dashboard Screen
                            Intent dashboard = new Intent(getApplicationContext(), DashboardActivity.class);

                            // Close all views before launching Dashboard
                            dashboard.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(dashboard);
                            Toast.makeText(getApplicationContext(), "annen!!!",
                                    Toast.LENGTH_SHORT).show();
                            // Close Login Screen
                            finish();
                        }else{
                            // Error in login1
                            loginErrorMsg.setText("Incorrect username/password");
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        // Link to Register Screen
        btnLinkToRegister.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),
                        RegisterActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
