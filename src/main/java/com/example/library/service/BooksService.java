package com.example.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.library.model.Author;
import com.example.library.model.Books;
import com.example.library.repository.BooksRepo;

@Service
public class BooksService {
	
	@Autowired
	private BooksRepo booksRepo;
	
	public List<Books> findAll(){
		return (List<Books>) booksRepo.findAll();
	}
	
	public Books findById(Long id){
		return booksRepo.findById(id).orElseThrow();
		
	}
	
	public Books addBook(Books book){
		return booksRepo.save(book);
		
	}
	
//	public List<Books> addBooks(List <Books> books) {
//		return (List<Books>) booksRepo.saveAll(books);
//	}
	
	public Books update(Books newBook){
		Books oldBook=findById(newBook.getId());
		
		if(newBook.getName() == null) {
			newBook.setName(oldBook.getName());
		}
		
		if(newBook.getAuthor() == null) {
			newBook.setAuthor(oldBook.getAuthor());
		}
		
		if(newBook.getId() == null) {
			newBook.setId(oldBook.getId());
		}
		
		if(Double.compare(newBook.getPrice(), 0.0)==0){
			newBook.setPrice(oldBook.getPrice());
		}
		
		return booksRepo.save(newBook);
	}
	
	@Transactional
	public void deleteById(Long id){
		booksRepo.deleteById(id);
	}
	
	public void deleteAll() {
		booksRepo.deleteAll();
	}
	
	

}
