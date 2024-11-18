package com.moreira.desafioCDI.services;

import com.moreira.desafioCDI.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double shipment(Order order) {
        if(order.getBasic() >= 200) {
            return 00.00;
        } else if(order.getBasic() >= 100) {
            return 12.00;
        } else {
            return 20.00;
        }
    }
}
