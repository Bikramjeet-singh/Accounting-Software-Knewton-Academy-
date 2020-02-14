package com.knewton.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knewton.model.Category;
import com.knewton.model.Item;
import com.knewton.repository.CategoryRepository;
import com.knewton.repository.ItemRepository;

@Service
public class AddItemserviceImplements implements AddItemServices {
	@Autowired
	ItemRepository itemrepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public List<Category> categorylist() {

		List<Category> categorylist = (List<Category>) categoryRepository.findAll();
		return categorylist;
	}

	public List<Item> fetchitem(int categoryId) {
		List<Item> itemlist = itemrepository.findByCategoryId(categoryId);
		return itemlist;

	}

	@Override
	public void additem(int categoryId, int itemId, String itemName, float sellingPrice, int quantity) {
		// TODO Auto-generated method stub
		Item item = new Item();
		item.setCategoryId(categoryId);
		item.setItemName(itemName);
		item.setItemId(itemId);
		item.setQuantity(quantity);
		item.setSellingPrice(sellingPrice);
		itemrepository.save(item);

	}
}
