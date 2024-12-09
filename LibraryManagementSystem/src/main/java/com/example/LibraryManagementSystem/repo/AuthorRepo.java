package com.example.LibraryManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LibraryManagementSystem.entity.Author;

public interface AuthorRepo extends JpaRepository<Author, Integer> {

}
