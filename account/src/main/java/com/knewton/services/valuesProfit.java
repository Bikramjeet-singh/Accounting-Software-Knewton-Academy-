package com.knewton.services;

public class valuesProfit {
private int quantitysell;
private int quantitybuy;
private int quantityreturn;
private int amountsell;
private int amountbuy;
private int amountreturn;
private int totalprofit;
public int getQuantitysell() {
	return quantitysell;
}
public void setQuantitysell(int quantitysell) {
	this.quantitysell = quantitysell;
}
public int getQuantitybuy() {
	return quantitybuy;
}
public void setQuantitybuy(int quantitybuy) {
	this.quantitybuy = quantitybuy;
}
@Override
public String toString() {
	return "valuesProfit [quantitysell=" + quantitysell + ", quantitybuy=" + quantitybuy + ", quantityreturn="
			+ quantityreturn + ", amountsell=" + amountsell + ", amountbuy=" + amountbuy + ", amountreturn="
			+ amountreturn + ", getQuantitysell()=" + getQuantitysell() + ", getQuantitybuy()=" + getQuantitybuy()
			+ ", getQuantityreturn()=" + getQuantityreturn() + ", getAmountsell()=" + getAmountsell()
			+ ", getAmountbuy()=" + getAmountbuy() + ", getAmountreturn()=" + getAmountreturn() + ", getClass()="
			+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}
public int getQuantityreturn() {
	return quantityreturn;
}
public void setQuantityreturn(int quantityreturn) {
	this.quantityreturn = quantityreturn;
}
public int getAmountsell() {
	return amountsell;
}
public void setAmountsell(int amountsell) {
	this.amountsell = amountsell;
}
public int getAmountbuy() {
	return amountbuy;
}
public void setAmountbuy(int amountbuy) {
	this.amountbuy = amountbuy;
}
public int getAmountreturn() {
	return amountreturn;
}
public void setAmountreturn(int amountreturn) {
	this.amountreturn = amountreturn;
}
public int getTotalprofit() {
	return totalprofit;
}
public void setTotalprofit(int totalprofit) {
	this.totalprofit = totalprofit;
}
}
