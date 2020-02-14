package com.knewton.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knewton.model.Category;

import com.knewton.repository.CategoryRepository;


@Service
public class AddCategoryServicesImplements implements AddCategoryServices {
	

	@Autowired
	private CategoryRepository categoryRepository;
	
	

	public AddCategoryServicesImplements() {
		
	}

	@Override
	public List<Category> categorylist() {

		List<Category> categorylist = (List<Category>) categoryRepository.findAll();
		return categorylist;
	}
	
	@Override
	public Category findCategory(int id)
	{
			return categoryRepository.findById(id).get();
			
	}

	@Override
	public void addcategory(String categoryName) {

		System.out.println(categoryName+" -categoryName");
		// TODO Auto-generated method stub
		Category category = new Category();
	
		category.setCategoryName(categoryName);
		System.out.println(category);
		
		System.out.println(categoryRepository.save(category)+"   -save function");

	}

	@Override
	public String toString() {
		return "AddCategoryServicesImplements [categoryRepository=" + categoryRepository + "]";
	}


}