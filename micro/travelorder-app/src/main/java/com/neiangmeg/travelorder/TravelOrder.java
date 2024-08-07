package com.neiangmeg.travelorder;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class TravelOrder extends PanacheEntity {

    public static TravelOrder of(TravelOrder order, Flight byTravelOrderId, Hotel byTravelOrderId2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'of'");
    }



//    public static Object of(TravelOrder order, Flight byTravelOrderId, Hotel byTravelOrderId2) {
        // TODO Auto-generated method stub
 //       throw new UnsupportedOperationException("Unimplemented method 'of'");
 //   }
    
}
