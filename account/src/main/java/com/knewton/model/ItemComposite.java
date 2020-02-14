package com.knewton.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ItemComposite implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column
	private int itemId;
	@Column
	private int billId;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public ItemComposite() {

	}

	public ItemComposite(int itemId, int billId) {
		// TODO Auto-generated constructor stub
		this.itemId = itemId;
		this.billId = billId;
	}

	@Override
	public String toString() {
		return   billId + "            " + itemId +"";
	}

}
