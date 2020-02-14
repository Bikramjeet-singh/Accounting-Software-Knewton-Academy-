package com.knewton.services;

import java.util.List;

import com.knewton.model.Category;

public interface AddCategoryServices {
	public List<Category> categorylist();
	public void addcategory(String categoryName);
	public Category findCategory(int id);
}
