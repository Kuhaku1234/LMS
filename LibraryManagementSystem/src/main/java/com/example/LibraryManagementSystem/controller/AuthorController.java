package com.example.LibraryManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LibraryManagementSystem.Service.AuthorService;
import com.example.LibraryManagementSystem.entity.Author;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
	 
	
	     @Autowired
	       private AuthorService authorService;
	     

	    
	     @GetMapping
	     public ResponseEntity< List<Author>> getAllAuthors() {
	    	 List<Author> authors = authorService.getAllAuthors();
	         return ResponseEntity.ok(authors);
	     }

	     
	     @GetMapping("/{id}")
	     public ResponseEntity<Author> getAuthorById(@PathVariable int id) {
	    	 Author author = authorService.getAuthorById(id);
	    	 if(author == null) {
	    		 return ResponseEntity.notFound().build();
	    	 }
	    	 return ResponseEntity.ok(author);
	     }

	     
	     @PostMapping
	     public ResponseEntity<Author> saveAuthor(@RequestBody Author author) {
	    	 Author createdAuthor = authorService.saveOrUpdateAuthor(author);
	         return ResponseEntity.status(HttpStatus.CREATED).body(createdAuthor);
	     }

	     
	     @PutMapping("/{id}")
	     public ResponseEntity <Author> updateAuthor(@PathVariable int id, @RequestBody Author author) {
	        Author exsistingAuthor =authorService.getAuthorById(id);
	        if(author == null) {
	    		 return ResponseEntity.notFound().build();}
	    	 author.setId(id);
	    	 authorService.saveOrUpdateAuthor(author);
	         return  ResponseEntity.ok(author) ;
	     }

	     
	     @DeleteMapping("/{id}")
	     public ResponseEntity<Void> deleteAuthor(@PathVariable int id) {
	    	 Author author = authorService.getAuthorById(id);
	    	 if(author == null) {
	    		 return ResponseEntity.notFound().build();}
	         authorService.deleteAuthorById(id);
	         return ResponseEntity.noContent().build();     }

}
