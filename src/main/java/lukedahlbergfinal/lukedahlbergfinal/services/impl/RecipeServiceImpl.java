package lukedahlbergfinal.lukedahlbergfinal.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lukedahlbergfinal.lukedahlbergfinal.daos.RecipeDao;
import lukedahlbergfinal.lukedahlbergfinal.entities.Recipe;
import lukedahlbergfinal.lukedahlbergfinal.services.RecipeService;

@Service
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	private RecipeDao recipeDao;

	/**
	 * Sets the recipeDao object
	 * @param recipeDao
	 */
	public void setRecipeDao(RecipeDao recipeDao) {
		
		this.recipeDao = recipeDao;
		
	}

	/**
	 * Add a new Recipe to the application.
	 * @param recipe
	 */
	public void add(Recipe recipe) {

		recipeDao.add(recipe);
		
	}

	/**
	 * Update the information in an existing Recipe. The recipeId is used to
	 * find the unique recipe's information.
	 * @param recipe
	 */
	public void update(Recipe recipe) {
		recipeDao.update(recipe);
	}
	
	/**
	 * Delete an existing Recipe by referencing its parameter:
	 * @parameter: recipeId
	 */
	public void delete(Integer recipeId) {
		recipeDao.delete(recipeId);
	}
	
	/**
	 * Retrieve all Recipes from the application.
	 * @return
	 */
	public List<Recipe> getAllRecipes() {

		List<Recipe> recipes = recipeDao.getAllRecipes();
		return recipes;
		
	}

	/**
	 * Retrieve a single recipe's information if that recipe's recipeId
	 * matches the supplied recipeId
	 * @param recipeId
	 * @return Recipe
	 */
	public Recipe getRecipeById(Integer recipeId){
		return recipeDao.getRecipeById(recipeId);
	}

	/**
	 * Retrieve a single recipe's information if that recipe's recipeName
	 * matches the supplied recipeName.
	 * @param recipeName
	 * @return Recipe
	 **/
	public Recipe getRecipeByName(String recipeName) {
		return recipeDao.getRecipeByName(recipeName);

	}
}
