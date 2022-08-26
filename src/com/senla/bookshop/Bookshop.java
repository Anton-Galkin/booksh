package com.senla.bookshop;

import java.time.LocalDate;
import java.time.Month;

import com.senla.bookshop.model.ApplicationStarter;
import com.senla.bookshop.model.Book;
import com.senla.bookshop.model.ConsoleView;
import com.senla.bookshop.model.Order;
import com.senla.bookshop.model.OrderStatus;
import com.senla.bookshop.service.BookService;
import com.senla.bookshop.service.OrderService;
import com.senla.bookshop.service.RequestService;

public class Bookshop {

	public BookService bookService;
	public OrderService orderService;
	public RequestService requestService;

	public ConsoleView consoleView = new ConsoleView();

	public static void main(String[] args) {
		new Bookshop().start();
	}

	public void start() {
		bookService = ApplicationStarter.getBookService();
		orderService = ApplicationStarter.getOrderService();
		requestService = ApplicationStarter.getRequestService();

		addBooks();
		testBookService();
//		testOrderService();
	}

	public void addBooks() {
		Book b1 = new Book("Python for beginners", "A. Galkin", LocalDate.of(1986, Month.MAY, 16));
		Book b2 = new Book("Java for Python developers", "V. Bolshov", LocalDate.now());

		bookService.addBook(b1);
		bookService.addBook(b2);
	}

	public void testBookService() {
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
		orderService.createOrder(null);

		Order order = orderService.getOrder(0);

		System.out.println("old status - " + order.getStatus().toString());

		orderService.changeOrderStatus(order, OrderStatus.CANCELED);

		System.out.println("new status - " + order.getStatus().toString());
	}
}
