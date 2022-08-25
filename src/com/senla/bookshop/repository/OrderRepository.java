package com.senla.bookshop.repository;

import java.util.ArrayList;
import java.util.Optional;

import com.senla.bookshop.model.Order;

public class OrderRepository {

	private ArrayList<Order> orders = new ArrayList<>();

	public boolean add(Order order) {
		return orders.add(order);
	}

	public Optional<Order> get(int id) {
		for (Order order : orders) {
			if (order.getId() == id) {
				return Optional.of(order);
			}
		}

		return Optional.empty();
	}

	public boolean remove(int id) {
		for (Order order : orders) {
			if (order.getId() == id) {
				return orders.remove(order);
			}
		}

		return false;
	}

	public boolean remove(Order order) {
		return orders.remove(order);
	}

	public boolean update(Order order) {
		remove(order.getId());
		return orders.add(order);
	}

	public int getNexId() {
		return orders.size();
	}
}
