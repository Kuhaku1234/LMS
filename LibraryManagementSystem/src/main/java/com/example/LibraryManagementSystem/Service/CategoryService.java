package com.example.LibraryManagementSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LibraryManagementSystem.entity.Book;
import com.example.LibraryManagementSystem.entity.Category;
import com.example.LibraryManagementSystem.repo.CategoryRepo;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepo categoryRepo;
	
	 public List<Category> getAllCategorys(){
			return categoryRepo.findAll();}
			
				
			  public Category getCategoryById(int id) {
		return categoryRepo.findById(id).
				orElse(null);
				  
			  }
			  public Category saveOrUpdateCategory(Category category) {
				  return categoryRepo.save(category);
			  }
			  public void deleteCategoryById(int id) {
				  categoryRepo.findById(id).
				  orElse(null);
				 
				  categoryRepo.deleteById(id);
			  }

}
