package org.example.AirlineManagement;

import java.util.ArrayList;
import java.util.List;

public class Admin {
    private String username;
    private String password;
    private List<AirCraft> airCraftList =new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<AirCraft> getAirCraftsList() {
        return airCraftList;
    }

    public void setAirCraftsList(List<AirCraft> airCraftList) {
        this.airCraftList = airCraftList;
    }
}
