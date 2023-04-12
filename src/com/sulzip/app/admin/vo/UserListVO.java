package com.sulzip.app.admin.vo;


public class UserListVO {
	private String userName;
	private String userId;
	private String userPhone;
	private String userGender;
	private String userRegistrationDate;
	
	public UserListVO() {}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserRegistrationDate() {
		return userRegistrationDate;
	}

	public void setUserRegistrationDate(String userRegistrationDate) {
		this.userRegistrationDate = userRegistrationDate;
	}

	@Override
	public String toString() {
		return "UserListVO [userName=" + userName + ", userId=" + userId + ", userPhone=" + userPhone + ", userGender="
				+ userGender + ", userRegistrationDate=" + userRegistrationDate + "]";
	}




	
	
	
}


