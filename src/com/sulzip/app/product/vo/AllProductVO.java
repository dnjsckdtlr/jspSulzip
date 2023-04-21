package com.sulzip.app.product.vo;

public class AllProductVO {
	private int number;
	private String nameKor;
	private String nameEng;
	private int price;
	private String img;
	private String sulkitDesc;
	private String sulkitRecipe;
	private String productEa;
	private String productVol;
	private String productAlcoholDegree;
	private String categoryNumber;
	
	public AllProductVO() {}

	public int getNumber() {
		return number;
	}

	public String getNameKor() {
		return nameKor;
	}

	public String getNameEng() {
		return nameEng;
	}

	public String getSulkitDesc() {
		return sulkitDesc;
	}

	public String getSulkitRecipe() {
		return sulkitRecipe;
	}

	public int getPrice() {
		return price;
	}

	public String getImg() {
		return img;
	}

	public String getProductEa() {
		return productEa;
	}

	public String getProductVol() {
		return productVol;
	}

	public String getProductAlcoholDegree() {
		return productAlcoholDegree;
	}

	public String getCategoryNumber() {
		return categoryNumber;
	}

	@Override
	public String toString() {
		return "AllProductVO [number=" + number + ", nameKor=" + nameKor + ", nameEng=" + nameEng + ", sulkitDesc="
				+ sulkitDesc + ", sulkitRecipe=" + sulkitRecipe + ", price=" + price + ", img=" + img + ", productEa="
				+ productEa + ", productVol=" + productVol + ", productAlcoholDegree=" + productAlcoholDegree
				+ ", categoryNumber=" + categoryNumber + "]";
	}

}
