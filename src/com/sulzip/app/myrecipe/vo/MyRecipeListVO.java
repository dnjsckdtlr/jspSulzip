package com.sulzip.app.myrecipe.vo;
//number, file sys name, myr name, hits
public class MyRecipeListVO {
	private int myRecipeNumber;
	private String fileSystemName;
	private String myRecipeNameKor;
	private int myRecipeHits;

	public MyRecipeListVO() {
	}
	
	public int getMyRecipeNumber() {
		return myRecipeNumber;
	}



	public void setMyRecipeNumber(int myRecipeNumber) {
		this.myRecipeNumber = myRecipeNumber;
	}



	public String getFileSystemName() {
		return fileSystemName;
	}



	public void setFileSystemName(String fileSystemName) {
		this.fileSystemName = fileSystemName;
	}



	public String getMyRecipeNameKor() {
		return myRecipeNameKor;
	}



	public void setMyRecipeNameKor(String myRecipeNameKor) {
		this.myRecipeNameKor = myRecipeNameKor;
	}



	public int getMyRecipeHits() {
		return myRecipeHits;
	}



	public void setMyRecipeHits(int myRecipeHits) {
		this.myRecipeHits = myRecipeHits;
	}


	@Override
	public String toString() {
		return "MyRecipeListVO [myRecipeNumber=" + myRecipeNumber + ", fileSystemName=" + fileSystemName
				+ ", myRecipeNameKor=" + myRecipeNameKor + ", myRecipeHits=" + myRecipeHits + "]";
	}

	
}
