package com.example.dto;


import lombok.Data;

//when request will be send consist of json data it will interact with DTO first 
@Data
public class UserRequestDTO {
	

	private String username;
	private String password;
	private String role;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public UserRequestDTO(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;

}
}