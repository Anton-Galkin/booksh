package com.senla.bookshop.repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.senla.bookshop.model.Book;
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

	public List<Order> getAllSortByDateExecution() {
		List<Order> list = new ArrayList<>();
		list.addAll(orders);

		list.sort(new Comparator<Order>() {

			@Override
			public int compare(Order order1, Order order2) {
				return order1.getDateExecution().compareTo(order2.getDateExecution());
			}
		});

		return list;
	}

	public List<Order> getAllSortByOrderPrice() {
		List<Order> list = new ArrayList<>();
		list.addAll(orders);

		list.sort(new Comparator<Order>() {

			@Override
			public int compare(Order order1, Order order2) {
				return order1.getOrderPrice().compareTo(order2.getOrderPrice());
			}
		});

		return list;
	}

	public List<Order> getAllSortByOrderStatus() {
		List<Order> list = new ArrayList<>();
		list.addAll(orders);

		list.sort(new Comparator<Order>() {

			@Override
			public int compare(Order order1, Order order2) {
//				if (order1.getStatus() == order2.getStatus()) {
//					return 0;
//				}
				return order1.getStatus().compareTo(order2.getStatus());
			}
		});

		return list;
	}
}
