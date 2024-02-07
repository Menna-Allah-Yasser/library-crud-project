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

import com.example.library.model.Author;
import com.example.library.service.AuthorService;

@RestController
@RequestMapping("/Authors")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping("")
	public List<Author> getAllAuthors(){
		return authorService.getAllAuthors();
	}
	
	@GetMapping("/{id}")
	public Author getAuthorById(@PathVariable Long id) {
		return authorService.getAuthorById(id);
	}
	
	@PostMapping("/add")
	public Author addAuthor(@RequestBody Author author) {
		return authorService.addAuthor(author); 
	}
	
	@PutMapping("/update")
	public Author updateAuthor(@RequestBody Author author) {
		return authorService.updateAuthor(author);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteAuthor(@PathVariable Long id) {
		 authorService.deleteAuthor(id);
	}

}
