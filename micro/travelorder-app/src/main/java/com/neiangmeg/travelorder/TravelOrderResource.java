package com.neiangmeg.travelorder;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.NotFoundException;

@Path("travelorder")
public class TravelOrderResource {

    @Inject
    @RestClient
    FlightService flightService;

    @Inject
    @RestClient
    HotelService hotelService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TravelOrder> orders() {
        return TravelOrder.<TravelOrder>listAll().stream()
              .map(order -> TravelOrder.of(
                     order,
                     flightService.findByTravelOrderId(order.id),
                     hotelService.findByTravelOrderId(order.id)
                ))
              .collect(Collectors.toList());
    }

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@QueryParam("id") long id) {
        TravelOrder order = TravelOrder.findById(id);
        if (order == null) {
            throw new NotFoundException("Travel order not found with ID: " + id);
        }
        return Response.ok(order).build();
    }

    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response newTravelOrder(TravelOrderDTO orderDto) {
        TravelOrder order = new TravelOrder();
        order.id = null;
        order.persist();

        Flight flight = new Flight();
        flight.setFromAirport(orderDto.getFromAirport());
        flight.setToAirport(orderDto.getToAirport());     
        flight.setTravelOrderId(order.id);
        flightService.newFlight(flight);

        Hotel hotel = new Hotel();
        hotel.setNights(orderDto.getNights());
        hotel.setTravelOrderId(order.id);  
        hotelService.newHotel(hotel);

        return Response.ok(order).status(Response.Status.CREATED).build();
    }
}
