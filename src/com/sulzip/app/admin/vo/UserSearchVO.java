package com.sulzip.app.admin.vo;

public class UserSearchVO {
	private String keyword;
	private String select;
	private String date;
	private String gender;
	
	public UserSearchVO() {}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "UserSearchVO [keyword=" + keyword + ", select=" + select + ", date=" + date + ", gender=" + gender
				+ "]";
	}
	
	
}
