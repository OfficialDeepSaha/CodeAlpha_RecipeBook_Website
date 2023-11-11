package com.RecipeBook;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class Messege {
	
	private String name;
	
	private String email;
		
	private String subject;
	
	private String messege;
	
	
	


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	

	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getMessege() {
		return messege;
	}


	public void setMessege(String messege) {
		this.messege = messege;
	}


	



	

	
	
	

}
