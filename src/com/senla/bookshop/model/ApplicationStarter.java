package com.senla.bookshop.model;

import com.senla.bookshop.repository.BookRepository;
import com.senla.bookshop.repository.OrderRepository;
import com.senla.bookshop.repository.RequestRepository;
import com.senla.bookshop.service.BookService;
import com.senla.bookshop.service.OrderService;
import com.senla.bookshop.service.RequestService;

public class ApplicationStarter {
	
	private static BookRepository bookRepository = new BookRepository();
	private static OrderRepository orderRepository = new OrderRepository();
	private static RequestRepository requestRepository = new RequestRepository();
	
	private static BookService bookService = new BookService(bookRepository);
	private static OrderService orderService = new OrderService(orderRepository);
	private static RequestService requestService = new RequestService(requestRepository);

	public static OrderService getOrderService() {
		return orderService;
	}
	
	public static BookService getBookService() {
		bookService.setRequestService(requestService);
		return bookService;
	}

	public static RequestService getRequestService() {
		return requestService;
	}
}
