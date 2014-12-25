package com.example.tdenisenko.flightreservation.FlightReservation;

/**
 * Created by SULUNGOZ on 13.12.2014.
 */
public class RegisteredUser extends User {
    static String email;
    static int userID;
    static String username;
    static String password;
    static String location;
    static boolean isAdmin = false;
    static int USER_COUNT = 0;

    public RegisteredUser(String username, String password){
        userID = 1000 + USER_COUNT;
        username = username;
        password = password;
    }
    private void logOut(){

    }

    private void favFlight(){


    }

    private void offers(){

    }

    public String getEmail() {
        return email;
    }

    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getLocation() {
        return location;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}
