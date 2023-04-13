package com.sulzip.app.user.dto;

//int userNumber;
//String userStatus;
//String userRegistrationDate;
//String userId;
//String userPw;
//String userName;
//String userPhone;
//String userGender;
//String userEmail;
//String userRegistrationNumber;

public class UserDTO {
	private int userNumber;
	private String userStatus;
	private String userRegistrationDate;
	private String userId;
	private String userPw;
	private String userName;
	private String userPhone;
	private String userGender;
	private String userEmail;
	private String userRegistrationNumber;

	public UserDTO() {}

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getUserRegistrationDate() {
		return userRegistrationDate;
	}

	public void setUserRegistrationDate(String userRegistrationDate) {
		this.userRegistrationDate = userRegistrationDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserRegistrationNumber() {
		return userRegistrationNumber;
	}

	public void setUserRegistrationNumber(String userRegistrationNumber) {
		this.userRegistrationNumber = userRegistrationNumber;
	}
	
	

	@Override
	public String toString() {
		return "UserDTO [userNumber=" + userNumber + ", userStatus=" + userStatus + ", userRegistrationDate="
				+ userRegistrationDate + ", userId=" + userId + ", userPw=" + userPw + ", userName=" + userName
				+ ", userPhone=" + userPhone + ", userGender=" + userGender + ", userEmail=" + userEmail
				+ ", userRegistrationNumber=" + userRegistrationNumber + "]";
	}
	
	
}
