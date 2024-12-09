package com.example.LibraryManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.LibraryManagementSystem.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
