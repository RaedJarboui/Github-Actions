package com.github.actions.entity;

public class User {
	
	Long id;
	String name;
	
	
	public User() {
		
	}
	
	public User(Long idUser, String nameUser) {
		this.id=idUser;
		this.name=nameUser;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
