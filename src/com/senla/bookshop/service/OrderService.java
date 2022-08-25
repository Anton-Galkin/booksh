package com.senla.bookshop.service;

import java.util.ArrayList;
import java.util.Optional;

import com.senla.bookshop.model.Book;
import com.senla.bookshop.model.Order;
import com.senla.bookshop.model.OrderStatus;
import com.senla.bookshop.repository.OrderRepository;

public class OrderService {

	private OrderRepository repository;

	public OrderService(OrderRepository repository) {
		this.repository = repository;
	}

	public boolean createOrder(ArrayList<Book> books) {
		Order order = new Order(repository.getNexId(), books);
		return repository.add(order);
	}

	public boolean remove(Order order) {
		return repository.remove(order);
	}

	public boolean changeOrderStatus(Order order, OrderStatus status) {
		order.setStatus(status);
		return repository.update(order);
	}

	public Order getOrder(int id) {
		Optional<Order> optional = repository.get(id);
		return optional.get();
	}
}
