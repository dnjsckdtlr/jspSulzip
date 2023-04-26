package com.sulzip.app.myrecipe.vo;

//product_name_kor, p.product_system_name, b.pmBridge_vol 

public class MyRecipeVO {
	private String productNameKor;
	private String productSystemName;
	private String pmBridgeVol;
	private int productNumber; 
	private int categoryNumber;
	
	public MyRecipeVO() {
	}

	public String getProductNameKor() {
		return productNameKor;
	}

	public void setProductNameKor(String productNameKor) {
		this.productNameKor = productNameKor;
	}

	public String getProductSystemName() {
		return productSystemName;
	}

	public void setProductSystemName(String productSystemName) {
		this.productSystemName = productSystemName;
	}

	public String getPmBridgeVol() {
		return pmBridgeVol;
	}

	public void setPmBridgeVol(String pmBridgeVol) {
		this.pmBridgeVol = pmBridgeVol;
	}

	public int getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}

	public int getCategoryNumber() {
		return categoryNumber;
	}

	public void setCategoryNumber(int categoryNumber) {
		this.categoryNumber = categoryNumber;
	}

	@Override
	public String toString() {
		return "MyRecipeVO [productNameKor=" + productNameKor + ", productSystemName=" + productSystemName
				+ ", pmBridgeVol=" + pmBridgeVol + ", productNumber=" + productNumber + ", categoryNumber="
				+ categoryNumber + "]";
	}

}
