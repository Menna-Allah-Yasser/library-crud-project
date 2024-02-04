package com.example.library.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Books {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ID_GENERATOR")
	@SequenceGenerator(name = "ID_GENERATOR", sequenceName = "Books_id", initialValue = 1000)
	private Long id;

	@Column
	private String name;

	@ManyToOne()
	@JoinColumn(name = "Author_ID")
	private Author author;

	@Column
	private double price;

	public Books() {
	}

	public Books(String name, double price) {
		super();
		this.name = name;
		this.price = price;
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

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

}
