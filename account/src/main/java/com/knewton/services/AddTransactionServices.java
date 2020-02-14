package com.knewton.services;

import java.util.List;

import com.knewton.model.Category;
import com.knewton.model.Item;

public interface AddTransactionServices {
	public List<Category> categoryList();

	public List<Item> itemlist(int categoryId);

	public void addtransaction(int transactionTypeId);

	float getprice(int itemId);

	void setprice(int itemId, float price);

	int getquantity(int itemId);

	void setquantity(int itemId, int quantity);

}
