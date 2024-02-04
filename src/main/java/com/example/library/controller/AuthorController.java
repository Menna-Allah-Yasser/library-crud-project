package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.model.Author;
import com.example.library.service.AuthorService;
import com.example.library.service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping("")
	public ResponseEntity<?> findAll(){
		return ResponseEntity.ok(authorService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		return ResponseEntity.ok(authorService.findById(id));
		
	}
	
	@PostMapping("")
	public ResponseEntity<?> addAuthor(@RequestBody Author author){
		return ResponseEntity.ok(authorService.addAuthor(author));
		
	}
	
//	@PostMapping("/addAuthors")
//	public ResponseEntity<?> addAuthors(@RequestBody List <Author> authors) {
//		return ResponseEntity.ok(authorService.addAuthors(authors));
//	}
	
	
	@PutMapping("")
	public ResponseEntity<?> update(@RequestBody Author author) {
		return ResponseEntity.ok(authorService.update(author));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>  deleteById(@PathVariable Long id){
		authorService.deleteById(id);
		return ResponseEntity.ok(null);
	}
	
	@DeleteMapping("")
	public ResponseEntity<?>  deleteAll() {
		authorService.deleteAll();
		return ResponseEntity.ok(null);
	}

}
