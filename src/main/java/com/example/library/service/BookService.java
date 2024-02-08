package com.example.library.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.exception.BookNotFoundException;
import com.example.library.model.Book;
import com.example.library.repository.BookRepo;

import jakarta.validation.Valid;

@Service
public class BookService {
	
	@Autowired
	private BookRepo bookRepo;

	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}

	public Book getBookById(@Valid Long id){
		return bookRepo.findById(id).
				orElseThrow(() -> new BookNotFoundException("User with ID: "+id+" NOT Founded"));
		
	}

	public List<Book> getBooksByAuthorId(Long id) {
		return bookRepo.findByAuthorId(id);
	}

	public Book addBook(Book book) {
		return bookRepo.save(book);
	}

	public Book updateBook(Book book){
		Book oldBook= getBookById(book.getId());
		
		if(book.getName()==null) {
			book.setName(oldBook.getName());
		}
		
		if(Double.compare(book.getPrice(), 0.0)==0){
			book.setPrice(oldBook.getPrice());
		}
		
		if(book.getAuthor() == null) {
			book.setAuthor(oldBook.getAuthor());
		}
		
		
		return bookRepo.save(book);
	}

	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
		
	}

}
