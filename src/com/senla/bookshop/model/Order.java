package com.senla.bookshop.model;

import java.util.List;

public class Order {

	private Integer id;

	private OrderStatus status = OrderStatus.NEW;

	private List<Book> books;

	public Order(int id) {
		this.id = id;
	}

	public Order(int id, List<Book> books) {
		this(id);
		this.books = books;
	}

	public int getId() {
		return id;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setId(int id) {
		this.id = id;
	}
}
