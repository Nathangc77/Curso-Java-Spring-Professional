package com.moreira.desafioCDI.services;

import com.moreira.desafioCDI.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public double total(Order order) {
        double discount = order.getDiscount()/100;

        return order.getBasic() - order.getBasic() * discount + shippingService.shipment(order);
    }
}
