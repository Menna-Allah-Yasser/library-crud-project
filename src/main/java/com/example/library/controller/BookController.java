package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.model.Book;
import com.example.library.service.BookService;

@RestController
@RequestMapping("/Books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("")
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable Long id) {
		return bookService.getBookById(id);
	}
	
	@GetMapping("/author/{id}")
	public List<Book> getBooksByAuthorId(@PathVariable Long id){
		return bookService.getBooksByAuthorId(id);
	}
	
	@PostMapping("/add")
	public Book addBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}
	
	@PutMapping("/update")
	public Book updateBook(@RequestBody Book book) {
		return bookService.updateBook(book);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteBook(@PathVariable Long id) {
		bookService.deleteBook(id);
	}

}
