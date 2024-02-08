package com.example.library.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Author {

	@Id
	@Column(name = "Author_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "AUTHOR_GENERATOR")
	@SequenceGenerator(name = "AUTHOR_GENERATOR", sequenceName = "Author_id", initialValue = 1002)
	private Long id;

	@Column(name = "FName")
	@NotBlank(message = "First Name is mandatory")
	private String firstName;
	
	@Column(name = "LName")
	@NotBlank(message = "Last Name is mandatory")
	private String lasttName;
	
	@Email
	@NotBlank(message = "Author Email is  mandatory")
	private String email;
	
	@OneToMany(mappedBy = "author" , cascade = CascadeType.ALL)
	private List<Book> books;

	public Author() {
	}	

	public Author(Long id, @NotBlank(message = "First Name is mandatory") String firstName, String lasttName,
			@Email String email, List<Book> books) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lasttName = lasttName;
		this.email = email;
		this.books = books;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLasttName() {
		return lasttName;
	}

	public void setLasttName(String lasttName) {
		this.lasttName = lasttName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@JsonManagedReference
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
	
	
}
