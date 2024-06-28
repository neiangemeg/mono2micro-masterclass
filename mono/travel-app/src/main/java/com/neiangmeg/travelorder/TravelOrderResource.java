package com.neiangmeg.travelorder;

import java.util.List;
import java.util.stream.Collectors;

import com.neiangmeg.flight.Flight;
import com.neiangmeg.flight.FligthResource;
import com.neiangmeg.hotel.Hotel;
import com.neiangmeg.hotel.HotelResource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("travelorder")
public class TravelOrderResource {

    @Inject
    FligthResource fligthResource;

    @Inject
    HotelResource hotelResource;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TravelOrderDto> orders(){
        return TravelOrder.<TravelOrder>listAll().stream()
              .map(
                 order -> TravelOrderDto.of(
                     order,
                     fligthResource.findByTravelOrderId(order.id),
                     hotelResource.findByTravelOrderId(order.id)
                        )
                 ).collect(Collectors.toList());

                }
    @GET
    @Path("finById")
    public TravelOrder findById (@QueryParam("id") long id) {
        return TravelOrder.findById(id);
    }

    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TravelOrder newTravelOrder (TravelOrderDto orderDto) {

        TravelOrder order = new TravelOrder();

        order.id = null;
        order.persist();

        Flight flight = new Flight();
        flight.fromAirport = orderDto.getFromAirport();
        flight.fromAirport = orderDto.getToAirport();
        flight.travelOrderId = order.id;
        fligthResource.newFlight(flight);

        Hotel hotel = new Hotel();
        hotel.nights = orderDto.getNights();
        hotel.travelOrderId = order.id;
        hotelResource.newHotel(hotel);

        return order;
    }

}