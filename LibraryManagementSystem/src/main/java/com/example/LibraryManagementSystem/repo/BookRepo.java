package com.example.LibraryManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.LibraryManagementSystem.entity.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {
	

}
