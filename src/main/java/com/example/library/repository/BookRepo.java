package com.example.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.library.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long>{
	
	List<Book> findByAuthorId(Long id);
	
	
	
	

}
