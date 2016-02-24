package lukedahlbergfinal.lukedahlbergfinal.services;

import java.util.List;

import lukedahlbergfinal.lukedahlbergfinal.entities.Recipe;

/**
 * The methods declared in this interface provide WebService functionality for Recipes
 * @author ldahlberg
 */
public interface RecipeService {
	
	/**
	 * Add a new recipe to the application.
	 * 
	 * @param recipe
	 */
	void add(Recipe recipe);

	/**
	 * Update the information in an existing recipe. Uses parameter:
	 * @param recipe
	 */
	void update(Recipe recipe);

	/**
	 * Deletes the Recipe in storage by searching for its parameter:
	 * @param recipeId
	 */
	void delete(Integer recipeId);
	
	/**
	 * Retrieve all recipes from the application.
	 * @return List<Recipe>
	 */
	List<Recipe> getAllRecipes();

	/**
	 * Retrieve a single recipe's information if that recipe's recipeId
	 * matches @param recipeId
	 * @return Recipe
	 */
	Recipe getRecipeById(Integer recipeId);

	/**
	 * Retrieve a single recipe's information if that recipe's recipeName
	 * matches the supplied recipeName.
	 * 
	 * @param recipeName
	 * @return Recipe
	 */
	Recipe getRecipeByName(String recipeName);
}
