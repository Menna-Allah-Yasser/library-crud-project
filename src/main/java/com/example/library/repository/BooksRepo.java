package com.example.library.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.library.model.Books;

@Repository
public interface BooksRepo extends CrudRepository<Books, Long>{
	

}
