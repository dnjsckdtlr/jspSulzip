package com.sulzip.app.cart.vo;
//c.product_number, c.product_ea, p.product_name_kor, p.product_price, p.product_system_name
/**
 * @author hyuno
 *
 */
public class CartVO {
	private int productNumber;
	private int productEa;
	private String productNameKor;
	private int productPrice;
	private int categoryNumber;
	private String productSystemName;
	
	public CartVO() {}

	public int getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}

	public int getProductEa() {
		return productEa;
	}

	public void setProductEa(int productEa) {
		this.productEa = productEa;
	}

	public String getProductNameKor() {
		return productNameKor;
	}

	public void setProductNameKor(String productNameKor) {
		this.productNameKor = productNameKor;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getCategoryNumber() {
		return categoryNumber;
	}

	public void setCategoryNumber(int categoryNumber) {
		this.categoryNumber = categoryNumber;
	}

	public String getProductSystemName() {
		return productSystemName;
	}

	public void setProductSystemName(String productSystemName) {
		this.productSystemName = productSystemName;
	}

	@Override
	public String toString() {
		return "CartVO [productNumber=" + productNumber + ", productEa=" + productEa + ", productNameKor="
				+ productNameKor + ", productPrice=" + productPrice + ", categoryNumber=" + categoryNumber
				+ ", productSystemName=" + productSystemName + "]";
	}
	
}