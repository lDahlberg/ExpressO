package lukedahlbergfinal.lukedahlbergfinal.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lukedahlbergfinal.lukedahlbergfinal.entities.Ingredient;
import lukedahlbergfinal.lukedahlbergfinal.services.IngredientService;

/**
 * The web service for the Baked Good
 * @author ldahlberg
 */
@RestController
public class IngredientWebService {

	@Autowired
	private IngredientService ingredientService;
	
	/**
	 * Sets a IngredientService object
	 * @param ingredientService
	 */
	public void setIngredientService(IngredientService ingredientService) {
		this.ingredientService = ingredientService;
	}
		
	/**
	 * Returns a list of all the Ingredients.
	 * @return List<Ingredient>
	 */
	@RequestMapping(value="/ingredients", method = RequestMethod.GET)
	public List<Ingredient> getAllIngredients(){
		return ingredientService.getAllIngredients();
	}	
	
	 /**
     * Retrieves Ingredient from Web and sends to Hibernate
     * @param Ingredient
     */
	@RequestMapping(value="/ingredients", method=RequestMethod.POST)
	public void add(@RequestBody Ingredient ingredient){
		ingredientService.add(ingredient);
	} 
	
    /**
     * Returns the information for an Ingredient with parameter:
     * @param id
     * @return Ingredient
     */
	@RequestMapping(value="/ingredients/{id}", method=RequestMethod.GET)
	public Ingredient getIngredientById(@PathVariable Integer id){ 
		return ingredientService.getIngredientById(id);
	}
	
	/**
	 * Edits an existing user in the Ingredient table
	 * @param id
	 * @param user
	 */
	@RequestMapping(value="/ingredients/{id}", method = RequestMethod.PUT)
	public void update(@RequestBody Ingredient ingredient){
		ingredientService.update(ingredient);
	}
	

	/**
	 * Deletes an existing Ingredient in the Ingredient table
	 * @param id
	 */
	@RequestMapping(value="/ingredients/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id){
		
		ingredientService.delete(id);
		 
	}
}
