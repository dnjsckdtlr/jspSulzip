package com.sulzip.app.myrecipe.dto;

//int myRecipeNumber;
//String myRecipeNameKor;
//String myRecipeNameEng;
//String myRecipeDesc;
//String myRecipeRecipe;
//int myRecipeHits;
//int userNumber;

public class MyRecipeDTO {
	private int myRecipeNumber;
	private String myRecipeNameKor;
	private String myRecipeNameEng;
	private String myRecipeDesc;
	private String myRecipeRecipe;
	private int myRecipeHits;
	private int userNumber;
	private String thumbnail;
	

	public MyRecipeDTO() {
	}
	
	public String getThumbnail() {
		return thumbnail;
	}
	
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	public int getMyRecipeNumber() {
		return myRecipeNumber;
	}
	public void setMyRecipeNumber(int myRecipeNumber) {
		this.myRecipeNumber = myRecipeNumber;
	}
	public String getMyRecipeNameKor() {
		return myRecipeNameKor;
	}
	public void setMyRecipeNameKor(String myRecipeNameKor) {
		this.myRecipeNameKor = myRecipeNameKor;
	}
	public String getMyRecipeNameEng() {
		return myRecipeNameEng;
	}
	public void setMyRecipeNameEng(String myRecipeNameEng) {
		this.myRecipeNameEng = myRecipeNameEng;
	}
	public String getMyRecipeDesc() {
		return myRecipeDesc;
	}
	public void setMyRecipeDesc(String myRecipeDesc) {
		this.myRecipeDesc = myRecipeDesc;
	}
	public String getMyRecipeRecipe() {
		return myRecipeRecipe;
	}
	public void setMyRecipeRecipe(String myRecipeRecipe) {
		this.myRecipeRecipe = myRecipeRecipe;
	}
	public int getMyRecipeHits() {
		return myRecipeHits;
	}
	public void setMyRecipeHits(int myRecipeHits) {
		this.myRecipeHits = myRecipeHits;
	}
	public int getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	@Override
	public String toString() {
		return "MyRecipeDTO [myRecipeNumber=" + myRecipeNumber + ", myRecipeNameKor=" + myRecipeNameKor
				+ ", myRecipeNameEng=" + myRecipeNameEng + ", myRecipeDesc=" + myRecipeDesc + ", myRecipeRecipe="
				+ myRecipeRecipe + ", myRecipeHits=" + myRecipeHits + ", userNumber=" + userNumber + ", thumbnail="
				+ thumbnail + "]";
	}
	
}
