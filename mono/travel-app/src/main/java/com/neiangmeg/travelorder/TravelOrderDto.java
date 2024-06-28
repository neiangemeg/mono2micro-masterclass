package com.neiangmeg.travelorder;

import com.neiangmeg.flight.Flight;
import com.neiangmeg.hotel.Hotel;

public class TravelOrderDto {

    private String fromAirport;
    private String toAirport;
    private  Integer nights;

    public TravelOrderDto() {

    }
    private TravelOrderDto ( String fromAirport,String toAirport, Integer nights ) {
               this.fromAirport = fromAirport;
               this.toAirport = toAirport;
               this.nights = nights;
}

    public static TravelOrderDto of (TravelOrder order, Flight flight , Hotel hotel)   {
      
        return new TravelOrderDto( flight.fromAirport, flight.toAirport, hotel.nights );
    } 

    public static TravelOrderDto of (String fromAString, String toString , Integer nights) {
         return new TravelOrderDto( fromAString , toString , nights);        
    }

    public String getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(String fromAirport) {
        this.fromAirport = fromAirport;
    }

    public String getToAirport() {
        return toAirport;
    }

    public void setToAirport(String toAirport) {
        this.toAirport = toAirport;
    }

    public Integer getNights() {
        return nights;
    }

    public void setNights(Integer nights) {
        this.nights = nights;
    }

}



