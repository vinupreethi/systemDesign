package org.example.AirlineManagement;

import java.util.ArrayList;
import java.util.List;

public class AirCraft {
    private int aircraftName;
    private int aircraftid;
    private List<Flight> flightList=new ArrayList<>();

    public List<Flight> getFlightList() {
        return flightList;
    }

    public void setFlightList(List<Flight> flightList) {
        this.flightList = flightList;
    }

    public int getName() {
        return aircraftName;
    }

    public void setName(int name) {
        this.aircraftName = name;
    }

    public int getId() {
        return aircraftid;
    }

    public void setId(int id) {
        this.aircraftid = id;
    }
}
