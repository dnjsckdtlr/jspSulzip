package com.sulzip.app.myrecipe.vo;
//number, file sys name, myr name, hits
public class MyRecipeListVO {
	private int myRecipeNumber;
	private String fileSystemName;

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

	@Override
	public String toString() {
		return "MyRecipeListVO [myRecipeNumber=" + myRecipeNumber + ", fileSystemName=" + fileSystemName + "]";
	}
	
}
