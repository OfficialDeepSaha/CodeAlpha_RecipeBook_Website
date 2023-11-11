package com.RecipeBook;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Recipes")
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	private String description;
	
	private String imageName;
	
	
	public Recipe() {
		
		
	}


	public Recipe(Long id, String title, String description, String imageName) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.imageName = imageName;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImageName() {
		return imageName;
	}


	public void setImageName(String imageName) {
		this.imageName = imageName;
	}


	@Override
	public String toString() {
		return "Recipe [id=" + id + ", title=" + title + ", description=" + description + ", imageName=" + imageName
				+ "]";
	}


	
	
	
	

}
