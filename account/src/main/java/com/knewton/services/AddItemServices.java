package com.knewton.services;
import java.util.List;

import com.knewton.model.Category;

public interface AddItemServices {
	public List<Category> categorylist();
	public void additem(int categoryId,int itemId,String itemName,float sellingPrice,int quantity);
}
