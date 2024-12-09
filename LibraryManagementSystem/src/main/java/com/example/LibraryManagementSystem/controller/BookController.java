package com.example.LibraryManagementSystem.controller;

import java.util.List;

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

import com.example.LibraryManagementSystem.Service.BookService;
import com.example.LibraryManagementSystem.entity.Book;

@RestController
@RequestMapping("/api/books")
public class BookController {

	      private BookService bookService;
	      

		     @GetMapping
		     public ResponseEntity< List<Book>> getAllBooks() {
		    	 List<Book> books = bookService.getAllBooks();
		         return ResponseEntity.ok(books);
		     }

		     
		     @GetMapping("/{id}")
		     public ResponseEntity<Book> getBookById(@PathVariable int id) {
		    	 Book book = bookService.getBookById(id);
		    	 if(book == null) {
		    		 return ResponseEntity.notFound().build();
		    	 }
		    	 return ResponseEntity.ok(book);
		     }

		     
		     @PostMapping
		     public ResponseEntity<Book> saveBook(@RequestBody Book book) {
		    	 Book createdBook = bookService.saveOrUpdateBook(book);
		         return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
		     }

		     
		     @PutMapping("/{id}")
		     public ResponseEntity <Book> updateBook(@PathVariable int id, @RequestBody Book book) {
		        Book exsistingBook =bookService.getBookById(id);
		        if(book == null) {
		    		 return ResponseEntity.notFound().build();}
		    	 book.setId(id);
		    	 bookService.saveOrUpdateBook(book);
		         return  ResponseEntity.ok(book) ;
		     }

		     
		     @DeleteMapping("/{id}")
		     public ResponseEntity<Void> deleteBook(@PathVariable int id) {
		    	 Book book = bookService.getBookById(id);
		    	 if(book == null) {
		    		 return ResponseEntity.notFound().build();}
		         bookService.deleteBookById(id);
		         return ResponseEntity.noContent().build();     }
	
	       
}
