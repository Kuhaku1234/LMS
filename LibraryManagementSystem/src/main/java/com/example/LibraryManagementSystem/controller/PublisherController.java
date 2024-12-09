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

import com.example.LibraryManagementSystem.Service.PublisherService;
import com.example.LibraryManagementSystem.entity.Publisher;

@RestController
@RequestMapping("/api/publisher")
public class PublisherController {
	
	@Autowired
     private PublisherService publisherService;
	
	 @GetMapping
     public ResponseEntity< List<Publisher>> getAllPublishers() {
    	 List<Publisher> publishers = publisherService.getAllPublishers();
         return ResponseEntity.ok(publishers);
     }

     
     @GetMapping("/{id}")
     public ResponseEntity<Publisher> getPublisherById(@PathVariable int id) {
    	 Publisher publisher = publisherService.getPublisherById(id);
    	 if(publisher == null) {
    		 return ResponseEntity.notFound().build();
    	 }
    	 return ResponseEntity.ok(publisher);
     }

     
     @PostMapping
     public ResponseEntity<Publisher> savePublisher(@RequestBody Publisher publisher) {
    	 Publisher createdPublisher = publisherService.saveOrUpdatePublisher(publisher);
         return ResponseEntity.status(HttpStatus.CREATED).body(createdPublisher);
     }

     
     @PutMapping("/{id}")
     public ResponseEntity <Publisher> updatePublisher(@PathVariable int id, @RequestBody Publisher publisher) {
        Publisher exsistingPublisher =publisherService.getPublisherById(id);
        if(publisher == null) {
    		 return ResponseEntity.notFound().build();}
    	 publisher.setId(id);
    	 publisherService.saveOrUpdatePublisher(publisher);
         return  ResponseEntity.ok(publisher) ;
     }

     
     @DeleteMapping("/{id}")
     public ResponseEntity<Void> deletePublisher(@PathVariable int id) {
    	 Publisher publisher = publisherService.getPublisherById(id);
    	 if(publisher == null) {
    		 return ResponseEntity.notFound().build();}
         publisherService.deletePublisherById(id);
         return ResponseEntity.noContent().build();     }
	
	
}


