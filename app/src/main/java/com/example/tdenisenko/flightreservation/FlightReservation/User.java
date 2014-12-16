package com.example.tdenisenko.flightreservation.FlightReservation;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by SULUNGOZ on 13.12.2014.
 * Edited by Karaakin on 16.12.2014.
 */
public class User extends registerUser{

    String sessionID;
    String ipLocation;
    Settings setting;
    Context context;
    CharSequence text;
    int duration = Toast.LENGTH_SHORT;

    public User(Settings setting, String sessionID, String ipLocation) {
        this.setting = setting;
        this.sessionID = sessionID;
        this.ipLocation = ipLocation;
    }

    private void register(){
        if(userID==null){
            //do something;
        }
        else{
            context.getApplicationContext();
            text="You've already registered";
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

    }

    private void login(){

    }
    private void searchFlight(){

    }
    private void bookFlight(){

    }
    private void changeCurrency(){

    }
    private void changeLanguage(){

    }
    private void changeCountry(){

    }
    private void changeCouuntry(){

    }
}
