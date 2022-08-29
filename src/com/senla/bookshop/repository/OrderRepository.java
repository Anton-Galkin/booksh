package com.senla.bookshop.repository;

import java.util.ArrayList;
import java.util.Optional;

import com.senla.bookshop.model.Order;

public class OrderRepository {

	private ArrayList<Order> orders = new ArrayList<>();

	public int add(Order order) {
		order.setId(getNexId());
		orders.add(order);
		return order.getId();
	}

	public Optional<Order> get(int id) {
		for (Order order : orders) {
			if (order.getId() == id) {
				return Optional.of(order);
			}
		}

		return Optional.empty();
	}

	public void remove(int id) {
		for (Order order : orders) {
			if (order.getId() == id) {
				orders.remove(order);
				return;
			}
		}
	}

	public void remove(Order order) {
		orders.remove(order);
	}

	public void update(Order order) {
		remove(order.getId());
		orders.add(order);
	}

	public int getNexId() {
		return orders.size();
	}
}
