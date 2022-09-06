package com.senla.bookshop.service;

import java.util.ArrayList;
import java.util.List;
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

	public int addOrder(List<Book> books) {
		Order order = new Order(repository.getNexId(), books);
		return repository.add(order);
	}

	public void remove(Order order) {
		repository.remove(order);
	}

	public void remove(int id) {
		repository.remove(id);
	}

	public void changeOrderStatus(Order order, OrderStatus status) {
		order.setStatus(status);
		repository.update(order);
	}

	public Order getOrder(int id) {
		Optional<Order> optional = repository.get(id);
		return optional.get();
	}

	public List<Order> getAllSortByDateExecution() {
		return repository.getAllSortByDateExecution();
	}

	public List<Order> getAllSortByOrderPrice() {
		return repository.getAllSortByOrderPrice();
	}

	public List<Order> getAllSortByOrderStatus() {
		return repository.getAllSortByOrderStatus();
	}
}
