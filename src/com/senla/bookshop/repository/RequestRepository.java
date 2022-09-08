package com.senla.bookshop.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;

import com.senla.bookshop.model.Book;
import com.senla.bookshop.model.Request;

public class RequestRepository {

	private ArrayList<Request> requests = new ArrayList<>();

	public int add(Request request) {
		request.setId(getNextId());
		requests.add(request);
		return request.getId();
	}

	public boolean contains(Request request) {
		return requests.contains(request);
	}

	public Optional<Request> get(int id) {
		for (Request request : requests) {
			if (request.getId() == id) {
				return Optional.of(request);
			}
		}

		return Optional.empty();
	}

	public List<Request> getAll() {
		return requests;
	}

	public List<Request> getAllSortByAlphabet() {
		List<Request> list = new ArrayList<>();
		list.addAll(requests);

		list.sort(new Comparator<Request>() {

			@Override
			public int compare(Request request1, Request request2) {
				return request1.getBook().getTitle().compareTo(request2.getBook().getTitle());
			}
		});
		return list;
	}

	public List<Request> getAllSortByQuantity() {
		List<Request> list = new ArrayList<>();
		HashMap<Book, Integer> requestQuantityMap = new HashMap<Book, Integer>();

		for (Request request : requests) {

			Integer i = requestQuantityMap.putIfAbsent(request.getBook(), 1);

			if (i != null) {
				requestQuantityMap.put(request.getBook(), ++i);
			}
		}

		LinkedList<Entry<Book, Integer>> requestQuantityList = new LinkedList<>(requestQuantityMap.entrySet());

		Collections.sort(requestQuantityList, new Comparator<Entry<Book, Integer>>() {

			@Override
			public int compare(Entry<Book, Integer> e1, Entry<Book, Integer> e2) {
				return e1.getValue().compareTo(e2.getValue()) * -1;
			}
		});

		for (Entry<Book, Integer> entry : requestQuantityList) {
			list.addAll(getRequests(entry.getKey()));
		}

		return list;
	}

	public List<Request> getRequests(Book book) {
		List<Request> list = new ArrayList<>();

		for (Request request : requests) {
			if (request.getBook().equals(book)) {
				list.add(request);
			}
		}

		return list;
	}

	public void remove(int id) {
		for (Request request : requests) {
			if (request.getId() == id) {
				requests.remove(request);
				return;
			}
		}
	}

	public void remove(Request request) {
		requests.remove(request);
	}

	public void update(Request request) {
		remove(request.getId());
		requests.add(request);
	}

	private int getNextId() {
		return requests.size();
	}
}
