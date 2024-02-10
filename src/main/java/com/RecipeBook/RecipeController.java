package com.RecipeBook;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class RecipeController {
	
	@Autowired
	private RecipeService recipeService;
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	
	@GetMapping("/")
	public String RecipeViewPage(Model model) {
		List<Recipe> list = recipeRepository.findAll();
		model.addAttribute("list", list);
				return "home";
	}
	
	

	
	
	
	
	
//	@GetMapping("/recipes")
//	public String getallrecipes(Model model) {
//		List<Recipe> getRecipes = recipeService.getallRecipes();
//		model.addAttribute("recipes", getRecipes);
//		return "recipes";
//		
//		
//	}
	
	
	@GetMapping("/add-recipes")
	public String addrecipes(Model model) {
		Recipe recipe = new Recipe();
		model.addAttribute("recipe", recipe);
		
		return "add-recipes";
	}
	
	@PostMapping("/add-recipes")
	public String saverecipes(@ModelAttribute("recipe") Recipe recipe , @RequestParam MultipartFile img, HttpSession session) throws IOException {
		
		 recipe.setImageName(img.getOriginalFilename());
		 recipeRepository.save(recipe);
		 File saveFile = new ClassPathResource("static/img").getFile();                                                               
		 Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + img.getOriginalFilename());
		 Files.copy(img.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		 session.setAttribute("msg", "Image Upload Sucessfully");
			return "redirect:/";
			
		}
			

			
		@GetMapping("/update")
		public String viewupdateform(@RequestParam Long id , Model model) {
			
			Recipe recipe = recipeRepository.findById(id).get();
			model.addAttribute("recipe", recipe);
			return "update";
		}

		
	
	
	
	@PostMapping("/update")
	public String updaterecipes(@ModelAttribute("recipe") Recipe recipe , @RequestParam Long id , @RequestParam MultipartFile img) throws IOException {
		
		recipe.setId(id);
		
		//return recipeService.updateRecipe(recipe);
		recipe.setImageName(img.getOriginalFilename());
		recipeRepository.save(recipe);
		File saveFile = new ClassPathResource("static/img").getFile();
		 Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + img.getOriginalFilename());
		 Files.copy(img.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		return "redirect:/";
		
	}
	
	
	@GetMapping("/delete{id}")
	public String delterecipes(@RequestParam Long id) {
		
		recipeService.deleteRecipe(id);
		
		return "redirect:/";
	}
	
	
	
	
	

}
