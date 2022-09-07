package com.senla.bookshop.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.SortedSet;

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

	public List<Request> getAllSortByQuantity() { // TODO add field QUANTITY
		List<Request> list = new ArrayList<>();
		list.addAll(requests);

//		list.sort(new Comparator<Request>() {
//
//			@Override
//			public int compare(Request request1, Request request2) {
//				return request1.getBook().getTitle().compareTo(request2.getBook().getTitle());
//			}
//		});
		
		HashMap<Book, Integer> requestMap = new HashMap<Book, Integer>();
		
		for (Request request : requests) {
//			if (!requestMap.containsKey(request.getBook())) {
//				requestMap.put(request.getBook(), 1);
//			} else {
//				requestMap.
//			}
			
			Integer i = requestMap.putIfAbsent(request.getBook(), 1);
			
			if (i != null) {
				requestMap.put(request.getBook(), ++i);
			}
			
			Set<Entry<Book, Integer>> entrySet = requestMap.entrySet();
			
			
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
