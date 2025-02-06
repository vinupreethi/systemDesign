package org.example.BookingCom.bookingService;

import org.example.BookingCom.Hotel;
import org.example.BookingCom.Location;
import org.example.BookingCom.Room;

import java.util.List;
import java.util.Objects;

public class HotelBookingService {
    private List<Hotel> hotel;
    private Location location;
    private String checkInDate;
    private String checkOutDate;
    private double price;

    public HotelBookingService(Location location, String checkInDate, String checkOutDate, double price) {
        this.location = location;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.price = price;
    }


    public Hotel reserveRoominHotel(Hotel hotel,Room room) throws Exception {
        List<Room> roomList=hotel.getAvailableroomList();
        if(!Objects.isNull(room))
        roomList.remove(room);
        else
            throw new Exception();
        return hotel;
    }
}
