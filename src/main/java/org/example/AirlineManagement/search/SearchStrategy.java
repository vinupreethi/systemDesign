package org.example.AirlineManagement.search;

import org.example.AirlineManagement.Flight;
import org.example.AirlineManagement.FlightScheduler;

import java.util.List;

public interface SearchStrategy {
     List<Flight> Search(List<FlightScheduler> flightSchedulerList);
}
