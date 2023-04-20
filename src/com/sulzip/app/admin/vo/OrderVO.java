package com.sulzip.app.admin.vo;

public class OrderVO {
	
	private String orderDate;
	private int orderNumber;
	private String userName;
	private String productNameKor;
	private String productTotalPrice;
	private int orderPay;
	
	public OrderVO() {}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProductNameKor() {
		return productNameKor;
	}

	public void setProductNameKor(String productNameKor) {
		this.productNameKor = productNameKor;
	}

	public String getProductTotalPrice() {
		return productTotalPrice;
	}

	public void setProductTotalPrice(String productTotalPrice) {
		this.productTotalPrice = productTotalPrice;
	}

	public int getOrderPay() {
		return orderPay;
	}

	public void setOrderPay(int orderPay) {
		this.orderPay = orderPay;
	}

	@Override
	public String toString() {
		return "OrderVO [orderDate=" + orderDate + ", orderNumber=" + orderNumber + ", userName=" + userName
				+ ", productNameKor=" + productNameKor + ", productTotalPrice=" + productTotalPrice + ", orderPay="
				+ orderPay + "]";
	}
	
	
	
}
