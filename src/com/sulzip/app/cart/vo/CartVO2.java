package com.sulzip.app.cart.vo;

public class CartVO2 {
	private int userNumber;
	private int productNumber;
	private int productTotalPrice;
	private int productEa;
	
	public CartVO2() {}

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public int getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}

	public int getProductTotalPrice() {
		return productTotalPrice;
	}

	public void setProductTotalPrice(int productTotalPrice) {
		this.productTotalPrice = productTotalPrice;
	}

	public int getProductEa() {
		return productEa;
	}

	public void setProductEa(int productEa) {
		this.productEa = productEa;
	}

	@Override
	public String toString() {
		return "CartVO2 [userNumber=" + userNumber + ", productNumber=" + productNumber + ", productTotalPrice="
				+ productTotalPrice + ", productEa=" + productEa + "]";
	}
}
