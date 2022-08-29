package com.senla.bookshop.model;

public class ConsoleView {

	public void displayBook(Book book) {
		StringBuilder builder = new StringBuilder();

		builder.append("id : ").append(book.getId()).append("\n");
		builder.append("title : ").append(book.getTitle()).append("\n");
		builder.append("author : ").append(book.getAuthor()).append("\n");
		builder.append("year of publication : ").append(book.getYearPubl().toString()).append("\n");
		builder.append("availability : ").append(book.isAvailable()).append("\n");

		System.out.println(builder.toString());
	}

	public void displayOrder(Order order) {
		StringBuilder builder = new StringBuilder();

		builder.append("id : ").append(order.getId()).append("\n");
		builder.append("id : ").append(order.getStatus()).append("\n");
	}

	public void displayRequest(Request request) {
		StringBuilder builder = new StringBuilder();

		builder.append("id : ").append(request.getId()).append("\n");
		builder.append("id : ").append(request.getRequestDate()).append("\n");
		builder.append("id : ").append(request.getRequestCompleted()).append("\n");
		builder.append("id : ").append(request.getBook()).append("\n");
	}

}
