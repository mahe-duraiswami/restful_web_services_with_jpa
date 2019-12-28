package com.mahe.rest.webservices.restfulwebservices.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Details about User")
@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Integer userId;
	
	@Size(min=2)
 	@ApiModelProperty(notes="Name should have atleast 2 characters.")
	private String userName;
	
	@Past
	@ApiModelProperty(notes="BirthDate should be in the past.")
	private Date userBirthDate;
	
	@OneToMany(mappedBy="user")
	private List<Post> posts;
	
	public User() {
		super();
	}

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
	
	

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userBirthDate=" + userBirthDate + "]";
	}
	
	

}
