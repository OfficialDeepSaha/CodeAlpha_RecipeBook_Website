package com.RecipeBook;

import java.util.List;

public interface RecipeService {
	
	List<Recipe> getallRecipes();
	
	Recipe createRecipe(Recipe recipe);
	
	void deleteRecipe(Long id);
	

	public Recipe updateRecipe(Recipe recipe);
	
}
