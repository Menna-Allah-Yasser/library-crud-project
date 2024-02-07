package com.example.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.model.Book;
import com.example.library.repository.BookRepo;

@Service
public class BookService {
	
	@Autowired
	private BookRepo bookRepo;

	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}

	public Book getBookById(Long id) {
		return bookRepo.findById(id).orElseThrow();
	}

	public List<Book> getBooksByAuthorId(Long id) {
		return bookRepo.findByAuthorId(id);
	}

	public Book addBook(Book book) {
		return bookRepo.save(book);
	}

	public Book updateBook(Book book) {
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

}
