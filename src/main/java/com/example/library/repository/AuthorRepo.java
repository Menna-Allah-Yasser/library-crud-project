package com.example.library.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.library.model.Author;

@Repository
public interface AuthorRepo extends CrudRepository<Author, Long>{

}
