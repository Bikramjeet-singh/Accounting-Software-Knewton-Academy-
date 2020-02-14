package com.knewton.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Item")
public class Item {
	@Id
	private int categoryId;
	@Id
	private int itemId;
	@Column
	private String itemName;
	@Column
	private float sellingPrice;
	@Column
	private float buyingPrice;
	@Column
	private int quantity;

	@OneToOne
	@JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
	private Category category;

	public Item(int categoryId, int itemId, String itemName, float sellingPrice, float buyingPrice, int quantity) {
		this.categoryId = categoryId;
		this.itemId = itemId;
		this.itemName = itemName;
		this.sellingPrice = sellingPrice;
		this.quantity = quantity;
		this.buyingPrice = buyingPrice;

	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(float sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public float getBuyingPrice() {
		return buyingPrice;
	}

	public void setBuyingPrice(float buyingPrice) {
		this.buyingPrice = buyingPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return categoryId + "                     "+ itemId+ "       " + itemName + "              "+ sellingPrice + "               " + buyingPrice + "                 " + quantity + "             " + category ;
	}

}
