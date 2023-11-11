package com.RecipeBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl implements RecipeService {
	
	@Autowired
	private RecipeRepository recipeRepository;

	@Override
	public List<Recipe> getallRecipes() {
		
		return recipeRepository.findAll();
	}

	@Override
	public Recipe createRecipe(Recipe recipe) {
		
		return recipeRepository.save(recipe);
	}

	@Override
	public void deleteRecipe(Long id) {
		recipeRepository.deleteById(id);
		
	}

	@Override
	public  Recipe updateRecipe(Recipe recipe) {	
	Recipe u = recipeRepository.findById(recipe.getId()).get();
	u.setId(recipe.getId());
    u.setTitle(recipe.getTitle());
    u.setDescription(recipe.getDescription());
    Recipe saveRecipe = recipeRepository.save(u);
    return saveRecipe;
		
		
		
	}

}
