package com.senla.bookshop;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import com.senla.bookshop.model.*;
import com.senla.bookshop.service.BookService;
import com.senla.bookshop.service.OrderService;
import com.senla.bookshop.service.RequestService;

public class Bookshop {

	private BookService bookService;
	private OrderService orderService;
	private RequestService requestService;

	private ConsoleView consoleView = new ConsoleView();

	private Book b1 = new Book("Python for beginners", "A. Galkin", LocalDate.of(1986, Month.MAY, 16), 10f);
	private Book b2 = new Book("War and peace", "L. Tolstoy", LocalDate.of(1869, Month.JANUARY, 1), 20f);
	private Book b3 = new Book("Eugene Onegin", "A. Pushkin", LocalDate.of(1831, Month.OCTOBER, 5), 15f);

	public static void main(String[] args) {
		new Bookshop().start();
	}

	public void start() {
		bookService = ApplicationStarter.getBookService();
		orderService = ApplicationStarter.getOrderService();
		requestService = ApplicationStarter.getRequestService();

		addBooks();
		testBookService();
		testOrderService();
		testRequestService();
	}

	public void addBooks() {
		bookService.addBook(b1);
		bookService.addBook(b2);
	}

	public void testBookService() {
		System.out.println("Test book service");
		System.out.println("All books :");

		for (Book b : bookService.getAll()) {
			consoleView.displayBook(b);
		}

		Book book = bookService.getBook(0);

		System.out.println("Discard book :");
		bookService.discardBook(book);
		consoleView.displayBook(book);

		System.out.println("Add book :");
		int id = bookService.addBook(book);
		book = bookService.getBook(id);
		consoleView.displayBook(book);
	}

	public void testOrderService() {
		int id = orderService.addOrder(List.of(b1, b2));
		Order order = orderService.getOrder(id);
		orderService.addOrder(List.of(b1));
		System.out.println("Test order service!");
		consoleView.displayOrder(order);
		orderService.changeOrderStatus(order, OrderStatus.COMPLETED);
		order = orderService.getOrder(id);
		consoleView.displayOrder(order);
		orderService.remove(id);
//		order = orderService.getOrder(id);
//		consoleView.displayOrder(order);
	}

	public void testRequestService() {
		b1.setAvailable(false);
		int id = requestService.addRequest(b1);
		Request request = requestService.getRequest(id);
		System.out.println("Test request service!");
		consoleView.displayRequest(request);
	}
}
