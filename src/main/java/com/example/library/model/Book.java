package com.example.library.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Book {

	@Id
	@Column(name = "Book_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ID_GENERATOR")
	@SequenceGenerator(name = "ID_GENERATOR", sequenceName = "Books_id", initialValue = 2003)
	private Long id;

	private String name;

	private double price;

	@ManyToOne()
	@JoinColumn(name = "author_id")
	private Author author;

	
	public Book() {
	}


	public Book(Long id, String name, double price, Author author) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.author = author;
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


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	@JsonBackReference
	public Author getAuthor() {
		return author;
	}


	public void setAuthor(Author author) {
		this.author = author;
	}
	
	
	
}

