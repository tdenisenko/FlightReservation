package com.example.tdenisenko.flightreservation.FlightReservation;

/**
 * Created by SULUNGOZ on 13.12.2014.
 * Edited by Karaakin on 16.12.2014.
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
    public String getSortBy() {
        return sortBy;
    }

    public FlightData[] getFlightList() {
        return flightList;
    }
    public int getPassngerCount() {
        return passngerCount;
    }

    public Passengers getPassengers() {
        return passengers;
    }
    public int getElementPerPage() {
        return elementPerPage;
    }

    public String getCityOfDestination() {
        return cityOfDestination;
    }

    public String getCityOfDeparture() {
        return cityOfDeparture;
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
