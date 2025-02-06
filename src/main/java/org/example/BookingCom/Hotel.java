package org.example.BookingCom;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String hotelName;
    private int hotelId;
    private List<Room> availableroomList=new ArrayList<>();
    private Location location;
    private Room chosenRoom;

    public Room getChosenRoom() {
        return chosenRoom;
    }

    public void setChosenRoom(Room chosenRoom) {
        this.chosenRoom = chosenRoom;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }


    public Hotel(Location location) {
        this.availableroomList = availableroomList;
        this.location=location;
    }

    public List<Room> getRoomList() {
        return availableroomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.availableroomList = roomList;
    }

    public List<Room> getAvailableroomList() {
        return availableroomList;
    }

    public void setAvailableroomList(List<Room> availableroomList) {
        this.availableroomList = availableroomList;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }




}
