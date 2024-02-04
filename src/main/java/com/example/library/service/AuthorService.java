package com.example.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.model.Author;
import com.example.library.repository.AuthorRepo;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepo authorRepo;

	public List<Author> findAll() {
		return (List<Author>) authorRepo.findAll();
	}

	public Author findById(Long id) {
		return authorRepo.findById(id).orElseThrow();

	}

	public Author addAuthor(Author author) {
		return authorRepo.save(author);

	}
	
//	public List<Author> addAuthors(List <Author> authors) {
//		return (List<Author>) authorRepo.saveAll(authors);
//	}

	public Author update(Author newAuthor) {
		Author oldAuthor = findById(newAuthor.getId());

		if (newAuthor.getName() == null) {
			newAuthor.setName(oldAuthor.getName());
		}

		if (newAuthor.getId() == null) {
			newAuthor.setId(oldAuthor.getId());
		}

		return authorRepo.save(newAuthor);
	}

	public void deleteById(Long id) {
		authorRepo.deleteById(id);
	}

	public void deleteAll() {
		authorRepo.deleteAll();
	}

}
