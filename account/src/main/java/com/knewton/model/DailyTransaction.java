package com.knewton.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dailytransaction")
public class DailyTransaction {
	@EmbeddedId
	private ItemComposite itemcomposite;
	@Column
	private float actualPrice;
	@Column
	private int quantity;
	@Column
	private int transactionTypeId;
	@Column
	private Date date;

	@OneToOne
	@JoinColumn(name = "itemId", referencedColumnName = "itemId")
	private Item item;

	public DailyTransaction(ItemComposite itemComposite, float actualPrice, int quantity, int transactionTypeId,
			Date date) {
		this.actualPrice = actualPrice;
		this.quantity=quantity;
		this.date = date;
		this.transactionTypeId = transactionTypeId;
		this.itemcomposite = itemComposite;

	}

	public ItemComposite getItemcomposite() {
		return itemcomposite;
	}

	public void setItemcomposite(ItemComposite itemcomposite) {
		this.itemcomposite = itemcomposite;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public float getActualPrice() {
		return actualPrice;
	}

	public void setActualPrice(float actualPrice) {
		this.actualPrice = actualPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTransactionTypeId() {
		return transactionTypeId;
	}

	public void setTransactionTypeId(int transactionTypeId) {
		this.transactionTypeId = transactionTypeId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return   itemcomposite+"       "+actualPrice+"       "+quantity+"             "+transactionTypeId+"             "+date ;
	}

}
