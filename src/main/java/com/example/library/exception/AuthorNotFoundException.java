package com.example.library.exception;

import java.util.NoSuchElementException;

public class AuthorNotFoundException extends NoSuchElementException{
	
	public AuthorNotFoundException(String message) {
        super(message);
    }

}
