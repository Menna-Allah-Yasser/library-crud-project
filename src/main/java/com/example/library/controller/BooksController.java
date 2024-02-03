package com.example.library.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.model.Books;
import com.example.library.service.BooksService;

@RestController
@RequestMapping("/book")
public class BooksController {
	
	@Autowired
	private BooksService booksService;
	
	@GetMapping("")
	public ResponseEntity<?> findAll(){
		return ResponseEntity.ok(booksService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		return ResponseEntity.ok(booksService.findById(id));
		
	}
	
	@PostMapping("")
	public ResponseEntity<?> addBook(@RequestBody Books book){
		return ResponseEntity.ok(booksService.addBook(book));
		
	}
	
	@PutMapping("")
	public ResponseEntity<?> updateById(@RequestBody Books book) {
		return ResponseEntity.ok(booksService.updateById(book));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>  deleteById(Long id){
		booksService.deleteById(id);
		return ResponseEntity.ok(null);
	}
	
	@DeleteMapping("")
	public ResponseEntity<?>  deleteAll() {
		booksService.deleteAll();
		return ResponseEntity.ok(null);
	}

}
