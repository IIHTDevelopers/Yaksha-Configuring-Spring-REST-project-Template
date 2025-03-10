package com.yaksha.assignment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.yaksha.assignment.entity.Book;

@RestController
public class BookController {

	// Sample hard-coded list of books
	private List<Book> books = List.of(new Book(1L, "The Great Gatsby", "F. Scott Fitzgerald"),
			new Book(2L, "1984", "George Orwell"), new Book(3L, "To Kill a Mockingbird", "Harper Lee"));

	// Endpoint to fetch all books
	@GetMapping("/books")
	public List<Book> getBooks() {
		return books;
	}

	// Endpoint to fetch a book by its ID
	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable Long id) {
		// Return the book with the matching ID, or null if not found
		Optional<Book> book = books.stream().filter(b -> b.getId().equals(id)).findFirst();
		return book.orElse(null);
	}
}
