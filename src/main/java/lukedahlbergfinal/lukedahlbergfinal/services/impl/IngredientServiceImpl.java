package lukedahlbergfinal.lukedahlbergfinal.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lukedahlbergfinal.lukedahlbergfinal.daos.IngredientDao;
import lukedahlbergfinal.lukedahlbergfinal.entities.Ingredient;
import lukedahlbergfinal.lukedahlbergfinal.services.IngredientService;

@Service
public class IngredientServiceImpl implements IngredientService {

	@Autowired
	private IngredientDao ingredientDao;

	/**
	 * Sets the ingredientDao object
	 * @param ingredientDao
	 */
	public void setIngredientDao(IngredientDao ingredientDao) {
		
		this.ingredientDao = ingredientDao;
		
	}

	/**
	 * Add a new Ingredient to the application.
	 * @param ingredient
	 */
	public void add(Ingredient ingredient) {

		ingredientDao.add(ingredient);
		
	}

	/**
	 * Update the information in an existing Ingredient. The ingredientId is used to
	 * find the unique ingredient's information.
	 * @param ingredient
	 */
	public void update(Ingredient ingredient) {
		ingredientDao.update(ingredient);
	}
	
	/**
	 * Delete an existing Ingredient by referencing its parameter:
	 * @parameter: ingredientId
	 */
	public void delete(Integer ingredientId) {
		ingredientDao.delete(ingredientId);
	}
	
	/**
	 * Retrieve all Ingredients from the application.
	 * @return
	 */
	public List<Ingredient> getAllIngredients() {

		List<Ingredient> ingredients = ingredientDao.getAllIngredients();
		return ingredients;
		
	}

	/**
	 * Retrieve a single ingredient's information if that ingredient's ingredientId
	 * matches the supplied ingredientId
	 * @param ingredientId
	 * @return Ingredient
	 */
	public Ingredient getIngredientById(Integer ingredientId){
		return ingredientDao.getIngredientById(ingredientId);
	}

	/**
	 * Retrieve a single ingredient's information if that ingredient's ingredientName
	 * matches the supplied ingredientName.
	 * @param ingredientName
	 * @return Ingredient
	 **/
	public Ingredient getIngredientByName(String ingredientName) {
		return ingredientDao.getIngredientByName(ingredientName);

	}
}
