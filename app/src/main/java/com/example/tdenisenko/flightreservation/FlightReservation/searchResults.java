package com.example.tdenisenko.flightreservation.FlightReservation;

/**
 * Created by SULUNGOZ on 13.12.2014.
 */
public class searchResults {

    FlightData [] flightList=new FlightData[1000];
    String sortBy;
    int passngerCount;
    Passengers passengers;
    int elementPerPage;
    String cityOfDestination;
    String cityOfDeparture;

    private FlightData[]  changeSearch(){
        return flightList;
    }
    private FlightData[] previousDay(){
        return previousDay();
    }
    private FlightData[] nextDay(){
        return nextDay();
    }
    private FlightData [] sort()  {
        return sort();
    }
    private void previousPage(){

    }
    private void nextPage(){

    }
    private FlightData[] getFlightList(){
        return getFlightList();
    }
    private String getSortBy(){
        return getSortBy();
    }
    private int getPassngerCount(){
        return getPassngerCount();
    }
    private Passengers getPassengers(){
        return getPassengers();
    }
    private int getElementPerPage(){
        return getElementPerPage();
    }
    private String getCityOfDestination(){
        return getCityOfDestination();
    }
    private String getCityOfDeparture(){
        return getCityOfDestination();
    }
    private FlightData[] setFlightList(){
        return  setFlightList();
    }
    private String setSortBy(){
        return setSortBy();
    }
    private int setPassengerCount(){
        return setPassengerCount();
    }
    private int setElementPerPage(){
        return setElementPerPage();
    }
    private String setCityOfDestination(){
        return setCityOfDestination();
    }
    private String setCityOfDeparture(){
        return setCityOfDeparture();
    }

}
