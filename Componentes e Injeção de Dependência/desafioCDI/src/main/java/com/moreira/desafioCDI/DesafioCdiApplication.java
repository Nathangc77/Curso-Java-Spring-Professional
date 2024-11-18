package com.moreira.desafioCDI;

import com.moreira.desafioCDI.entities.Order;
import com.moreira.desafioCDI.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioCdiApplication implements CommandLineRunner {

		@Autowired
		private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(DesafioCdiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Order order = new Order(1034, 150.00,20.0);

		System.out.println("Pedido código: " + order.getCode());
		System.out.printf("Valor total: R$ %.2f%n", this.orderService.total(order));

	}
}
