package com.senla.bookshop;

import com.senla.bookshop.model.ApplicationStarter;
import com.senla.bookshop.model.Order;
import com.senla.bookshop.model.OrderStatus;
import com.senla.bookshop.service.OrderService;

public class Bookshop {

	public OrderService orderService;

	// TODO services

	public static void main(String[] args) {
		new Bookshop().start();
	}

	public void start() {
		orderService = ApplicationStarter.getOrderService();
		// TODO

		testOrderService();
	}

	public void testOrderService() {
		orderService.createOrder(null);

		Order order = orderService.getOrder(0);

		System.out.println("old status - " + order.getStatus().toString());

		orderService.changeOrderStatus(order, OrderStatus.CANCELED);

		System.out.println("new status - " + order.getStatus().toString());
	}
}
