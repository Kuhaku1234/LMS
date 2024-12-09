package com.example.LibraryManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LibraryManagementSystem.entity.Publisher;

public interface PublisherRepo extends JpaRepository<Publisher, Integer> {

}
