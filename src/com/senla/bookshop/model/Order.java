package com.senla.bookshop.model;

import java.util.ArrayList;

public class Order {

	private int id;

	private OrderStatus status = OrderStatus.NEW;

	private ArrayList<Book> books;

	public Order(int id) {
		this.id = id;
	}

	public Order(int id, ArrayList<Book> books) {
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

	// TODO getters and setters


}
