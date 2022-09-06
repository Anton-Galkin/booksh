package com.senla.bookshop.model;

import java.time.LocalDate;
import java.util.List;

public class Order {

	private Integer id;

	private OrderStatus status = OrderStatus.NEW;

	private List<Book> books;

	private LocalDate dateExecution;
	private Float orderPrice = 0f;   //TODO List<Book.getPrice> summary

	public Float getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(Float orderPrice) { //TODO Order.java 15
//		this.orderPrice = orderPrice;
//		Float price = 0f;
		for (Book book : books) {
			this.orderPrice += book.getPrice();
		}
	}

	public LocalDate getDateExecution() {
		return dateExecution;
	}

	public void setDateExecution(LocalDate dateExecution) {
		this.dateExecution = dateExecution;
	}

	public Order(int id) {
		this.id = id;
	}

	public Order(int id, List<Book> books) {  //TODO add new fields to the constructor
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
