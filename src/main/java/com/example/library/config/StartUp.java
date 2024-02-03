package com.example.library.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.library.model.Books;
import com.example.library.service.BooksService;

@Component
public class StartUp implements CommandLineRunner {

	@Autowired
	private BooksService booksService;
	
	@Override
	public void run(String... args) throws Exception {
		if(booksService.findAll().isEmpty()){
			
			Books book1=new Books("Math" , "menna" , 450);
			Books book2=new Books("science" , "salma" , 650);
			
			booksService.addBook(book1);
			booksService.addBook(book2);
		}
		
	}
	

}
