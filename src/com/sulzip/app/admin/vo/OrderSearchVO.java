package com.sulzip.app.admin.vo;

public class OrderSearchVO {
	
	private String keyword;
	private String date;
	private String select;
	
	public OrderSearchVO() {}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}

	@Override
	public String toString() {
		return "OrderSearchVO [keyword=" + keyword + ", date=" + date + ", select=" + select + "]";
	}
	
	
}
