package org.example.AirlineManagement;

import java.util.ArrayList;
import java.util.List;

public class Flight {
    private int flightId;
    private List<Seat> seatList=new ArrayList<>();
    private AirCraft airCraft;
    private FlightScheduler flightScheduler;


    public AirCraft getAirCraft() {
        return airCraft;
    }

    public void setAirCraft(AirCraft airCraft) {
        this.airCraft = airCraft;
    }

    public Flight(int flightId, List<Seat> seatList, AirCraft airCraft) {
        this.flightId = flightId;
        this.seatList = seatList;
        this.airCraft = airCraft;
    }

    public AirCraft getAirCrafts() {
        return airCraft;
    }

    public void setAirCrafts(AirCraft airCraft) {
        this.airCraft = airCraft;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }
}
