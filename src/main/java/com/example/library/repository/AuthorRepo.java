package com.example.library.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.library.model.Author;
import com.example.library.model.Book;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long>{

}
