package com.example.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.exception.AuthorNotFoundException;
import com.example.library.exception.BookNotFoundException;
import com.example.library.model.Author;
import com.example.library.repository.AuthorRepo;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepo authorRepo;

	public List<Author> getAllAuthors() {
		return authorRepo.findAll();
	}

	public Author getAuthorById(Long id) {
		return authorRepo.findById(id).
				orElseThrow(() -> new AuthorNotFoundException("Author with ID: "+id+" NOT Founded"));
	}

	public Author addAuthor(Author author) {
		return authorRepo.save(author);
	}

	public Author updateAuthor(Author author) {
		
		Author oldAuthor = getAuthorById(author.getId());

		if (author.getFirstName() == null) {
			author.setFirstName(oldAuthor.getFirstName());
		}
		
		if (author.getLasttName() == null) {
			author.setLasttName(oldAuthor.getLasttName());
		}

		return authorRepo.save(author);
	}

	public void deleteAuthor(Long id) {
		authorRepo.deleteById(id); 
	}
	
	

}
