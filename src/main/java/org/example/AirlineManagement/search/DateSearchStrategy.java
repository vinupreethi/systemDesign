package org.example.AirlineManagement.search;

import org.example.AirlineManagement.Flight;
import org.example.AirlineManagement.FlightScheduler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DateSearchStrategy implements SearchStrategy {
    private LocalDate startDate;
    private LocalDate endDate;

    public DateSearchStrategy(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate =endDate;
    }

    @Override
    public List<Flight> Search(List<FlightScheduler> flightSchedulerList) {
        List<Flight> flightList=new ArrayList<>();
        for(FlightScheduler flightScheduler : flightSchedulerList)
        {
            if(flightScheduler.getStartDate().equals(getStartDate()) && flightScheduler.getEndDate().equals(getEndDate()))
            {
                flightList.add(flightScheduler.getFlight());
            }
        }
        return flightList;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
