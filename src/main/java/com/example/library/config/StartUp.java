package com.example.library.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.library.model.Author;
import com.example.library.model.Books;
import com.example.library.service.AuthorService;
import com.example.library.service.BooksService;

@Component
public class StartUp implements CommandLineRunner {

	@Autowired
	private BooksService booksService;
	
	@Autowired
	private AuthorService authorService;
	
	
	@Override
	public void run(String... args) throws Exception {
		if (authorService.findAll().isEmpty()) {
            Author author1 = new Author("Amr");
            Author author2 = new Author("Yossef");
            authorService.addAuthor(author1);
            authorService.addAuthor(author2);

            Books book1 = new Books("E1", 450);
            Books book2 = new Books("E2", 650);

            author1.getBooks().add(book1);
            author2.getBooks().add(book2);

            authorService.addAuthor(author1);
            authorService.addAuthor(author2);
        }
		
		if(booksService.findAll().isEmpty()){
			
			 Books book1=new Books("java" , 450);
			 Books book2=new Books("spring" , 650);
			
			//booksService.addBooks(Arrays.asList(book1 , book2));
			 booksService.addBook(book1);
			 booksService.addBook(book2);
			
		}
		
	}
	

}
