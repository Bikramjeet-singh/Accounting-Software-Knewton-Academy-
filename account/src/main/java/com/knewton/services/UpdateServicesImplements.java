package com.knewton.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.knewton.model.Category;
import com.knewton.model.Item;
import com.knewton.repository.CategoryRepository;
import com.knewton.repository.ItemRepository;

public class UpdateServicesImplements implements UpdateServices {

	@Autowired
	ItemRepository itemrep;
	CategoryRepository catrep;

	@Override
	public List<Category> categoryList() {
		List<Category> catlist = (List<Category>) catrep.findAll();
		return catlist;
	}

	@Override
	public List<Item> itemlist(int categoryId) {
		List<Item> itlist = itemrep.findByCategoryId(categoryId);
		return itlist;
	}

	@Override
	public void changeName(int itemId, String itemName) {
		Item it = itemrep.findByItemid(itemId);
		it.setItemName(itemName);

	}

	@Override
	public void changeItemPrice(int itemId, float price) {
		Item it = itemrep.findByItemid(itemId);
		it.setSellingPrice(price);

	}

	@Override
	public void changeItemQuantity(int itemId, int qty) {
		Item it = itemrep.findByItemid(itemId);
		it.setQuantity(qty);

	}

}
