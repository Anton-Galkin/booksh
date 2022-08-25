package com.senla.bookshop.model;

import com.senla.bookshop.repository.OrderRepository;
import com.senla.bookshop.service.OrderService;

public class ApplicationStarter {

	public static OrderService getOrderService() {
		OrderRepository repository = new OrderRepository();
		return new OrderService(repository);
	}
	
	// TODO the same for other services
}
