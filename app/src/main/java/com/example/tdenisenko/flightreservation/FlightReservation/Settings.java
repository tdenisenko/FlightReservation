package com.example.tdenisenko.flightreservation.FlightReservation;

/**
 * Created by SULUNGOZ on 13.12.2014.
 */
public class Settings {
    String country;
    String language;
    String currency;
    Boolean isImperial;

    public Settings(String country, String language, String currency, Boolean isImperial) {
        this.country = country;
        this.language = language;
        this.currency = currency;
        this.isImperial = isImperial;
    }
}
