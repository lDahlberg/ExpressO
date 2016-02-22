package lukedahlbergfinal.lukedahlbergfinal.daos;

import java.util.List;

import lukedahlbergfinal.lukedahlbergfinal.entities.Ingredient;

/**
 * The methods declared in this interface are to provide basic CRUD functionality related to ingredient objects.
 * @author lDahlberg
 *
 */
public interface IngredientDao {

	/**
	 * Adds information about an ingredient to storage.
	 * @param ingredient
	 */
	void add(Ingredient ingredient);

	/**
	 * Updates the information about an ingredient already in storage.
	 * @param ingredient
	 */
	void update(Ingredient ingredient);
	
	/**
	 * Retrieves all ingredients currently in storage.
	 * @return List<Ingredient>
	 */
	List<Ingredient> getAllIngredients();
	
	/**
	 * Retrieve information about a single ingredient from storage with a matching ingredientId
	 * @param ingredientId
	 * @return Ingredient
	 */
	Ingredient getIngredientById(Integer ingredientId);

	/**
	 * Retrieves an ingredient with a matching ingredientName.
	 * 
	 * @param ingredientName
	 * @return Ingredient
	 */
	Ingredient getIngredientByName(String ingredientName);
	
}
