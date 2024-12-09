package com.example.LibraryManagementSystem.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToMany;
@Entity
@Table(name = "authors")
public class Author {
        
	
	  private int id;
	  
	  private String name;
	  
	  @ManyToMany(mappedBy = "authors", cascade= CascadeType.ALL)
	  @JsonIgnore
	  private List<Book> books;
	  
	  public Author() {
		  
	  }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
