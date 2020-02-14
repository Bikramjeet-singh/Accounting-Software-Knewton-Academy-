package com.knewton.services;

import java.util.List;

import com.knewton.model.Category;
import com.knewton.model.Item;

public interface UpdateServices {
	public List<Category> categoryList();

	public List<Item> itemlist(int categoryId);

	public void changeName(int itemid, String itemName);

	public void changeItemPrice(int itemid, float price);

	public void changeItemQuantity(int itemid, int quantity);

}
