package lukedahlbergfinal.lukedahlbergfinal.daos;

import java.util.List;

import lukedahlbergfinal.lukedahlbergfinal.entities.Recipe;

/**
 * The methods declared in this interface provide basic CRUD functionality related to recipe objects.
 * @author lDahlberg
 *
 */
public interface RecipeDao {
	
	/**
	 * Adds information about an recipe to storage.
	 * @param recipe
	 */
	void add(Recipe recipe);

	/**
	 * Updates the information about an recipe already in storage.
	 * @param recipe
	 */
	void update(Recipe recipe);
	
	/**
	 * Deletes the Recipe in storage by searching for its parameter:
	 * @param recipeId
	 */
	void delete(Integer recipeId);
	
	/**
	 * Retrieves all recipes currently in storage.
	 * @return List<Recipe>
	 */
	List<Recipe> getAllRecipes();
	
	/**
	 * Retrieve information about a single recipe from storage with a matching recipeId
	 * @param recipeId
	 * @return Recipe
	 */
	Recipe getRecipeById(Integer recipeId);

	/**
	 * Retrieves an recipe with a matching recipeName.
	 * 
	 * @param recipeName
	 * @return Recipe
	 */
	Recipe getRecipeByName(String recipeName);
}
