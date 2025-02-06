package org.example.BookingCom;

import org.example.BookingCom.transport.Transport;

import java.util.List;

public class Location {
   private String address;
   private String city;
   private String country;
   private List<Hotel> hotelList;
   private List<Transport> transportList;

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public List<Transport> getTransportList() {
      return transportList;
   }

   public void setTransportList(List<Transport> transportList) {
      this.transportList = transportList;
   }

   public Location(String city, String country) {
      this.city = city;
      this.country = country;
   }

   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getCountry() {
      return country;
   }

   public void setCountry(String country) {
      this.country = country;
   }

   public List<Hotel> getHotelList() {
      return hotelList;
   }

   public void setHotelList(List<Hotel> hotelList) {
      this.hotelList = hotelList;
   }
}
