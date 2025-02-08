package org.example.AirlineManagement.search;

import org.example.AirlineManagement.Flight;
import org.example.AirlineManagement.FlightScheduler;

import java.util.ArrayList;
import java.util.List;

public class LocationSearchStrategy implements SearchStrategy {
    private String source;
    private String destination;

    public LocationSearchStrategy(String source, String desination) {
        this.source = source;
        this.destination = desination;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public List<Flight> Search(List<FlightScheduler> flightSchedulerList) {
        List<Flight> flightList = new ArrayList<>();
        String source = getSource();
        String destination = getDestination();
        for (FlightScheduler flightScheduler : flightSchedulerList) {
            if (flightScheduler.getEndLocation() == destination && flightScheduler.getStartLocation() == source) {
                flightList.add(flightScheduler.getFlight());
            }
        }
        return flightList;


    }
}
