package lukedahlbergfinal.lukedahlbergfinal.services;

import java.util.List;

import lukedahlbergfinal.lukedahlbergfinal.entities.Ingredient;

/**
 * The methods declared in this interface provide WebService functionality for Ingredients 
 * @author ldahlberg
 */
public interface IngredientService {

		/**
		 * Add a new ingredient to the application.
		 * 
		 * @param ingredient
		 */
		void add(Ingredient ingredient);

		/**
		 * Update the information in an existing ingredient. Uses parameter:
		 * @param ingredient
		 */
		void update(Ingredient ingredient);

		/**
		 * Retrieve all ingredients from the application.
		 * @return List<Ingredient>
		 */
		List<Ingredient> getAllIngredients();

		/**
		 * Retrieve a single ingredient's information if that ingredient's ingredientId
		 * matches @param ingredientId
		 * @return Ingredient
		 */
		Ingredient getIngredientById(Integer ingredientId);

		/**
		 * Retrieve a single ingredient's information if that ingredient's ingredientName
		 * matches the supplied ingredientName.
		 * 
		 * @param ingredientName
		 * @return Ingredient
		 */
		Ingredient getIngredientByName(String ingredientName);

}
