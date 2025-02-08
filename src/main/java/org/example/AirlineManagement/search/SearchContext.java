package org.example.AirlineManagement.search;

import org.example.AirlineManagement.Flight;
import org.example.AirlineManagement.FlightScheduler;

import java.util.List;

public class SearchContext {
    private SearchStrategy searchStrategy;

    public SearchContext(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    public List<Flight> doSearch(List<FlightScheduler> flightSchedulerList) {
        return searchStrategy.Search(flightSchedulerList);
    }
}
