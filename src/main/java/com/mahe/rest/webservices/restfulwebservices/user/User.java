package com.mahe.rest.webservices.restfulwebservices.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Details about User")
public class User {
	
	private Integer userId;
	
	@Size(min=2)
	@ApiModelProperty(notes="Name should have atleast 2 characters.")
	private String userName;
	
	@Past
	@ApiModelProperty(notes="BirthDate should be in the past.")
	private Date userBirthDate;
	
	public User(Integer userId, String userName, Date userBirthDate) {
		super();
		this.setUserId(userId);
		this.userName = userName;
		this.userBirthDate = userBirthDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Date getUserBirthDate() {
		return userBirthDate;
	}

	public void setUserBirthDate(Date userBirthDate) {
		this.userBirthDate = userBirthDate;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userBirthDate=" + userBirthDate + "]";
	}
	
	

}
