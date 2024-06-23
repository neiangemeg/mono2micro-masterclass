package com.neiangmeg.flight;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Flight extends PanacheEntity {
    public long travelOrderId;
    public String fromAirport;
    public String toAirport;

}
