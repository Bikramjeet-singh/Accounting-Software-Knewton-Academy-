package com.knewton.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knewton.model.Category;
import com.knewton.model.DailyTransaction;
import com.knewton.model.Item;
import com.knewton.repository.CategoryRepository;
import com.knewton.repository.ItemRepository;

@Service
public class AddTransactionServicesImplements implements AddTransactionServices {
	@Autowired
	CategoryRepository catrep;
	@Autowired
	ItemRepository itemrep;

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
	public void addtransaction(int transactionTypeId) {
		DailyTransaction dt = new DailyTransaction();
		dt.setTransactionTypeId(transactionTypeId);

	}

	@Override
	public float getprice(int itemId) {
		Item it = itemrep.findByItemid(itemId);
		float p = it.getSellingPrice();
		return p;
	}

	@Override
	public void setprice(int itemId, float price) {
		Item it = itemrep.findByItemid(itemId);
		it.setSellingPrice(price);
	}

	@Override
	public int getquantity(int itemId) {
		Item it = itemrep.findByItemid(itemId);
		int q=it.getQuantity();
		return q;
	}

	@Override
	public void setquantity(int itemId, int quantity) {
		Item it = itemrep.findByItemid(itemId);
		it.setQuantity(quantity);
		
	}

}
