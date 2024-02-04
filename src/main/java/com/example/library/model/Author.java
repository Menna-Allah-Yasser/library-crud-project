package com.example.library.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Author {

	@Id
	@Column(name = "Author_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "AUTHOR_GENERATOR")
	@SequenceGenerator(name = "AUTHOR_GENERATOR", sequenceName = "Books_id", initialValue = 1000)
	private Long id;

	@Column
	private String name;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "author", cascade = { CascadeType.REMOVE, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH })

	private List<Books> books;

	public Author() {
	}

	public Author(String name) {
		super();
		this.name = name;
	}

	public Author(String name, List<Books> books) {
		super();
		this.name = name;
		this.books = books;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Books> getBooks() {
		return books;
	}

	public void setBooks(List<Books> books) {
		this.books = books;
	}

}
