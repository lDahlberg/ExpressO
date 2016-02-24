package lukedahlbergfinal.lukedahlbergfinal.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lukedahlbergfinal.lukedahlbergfinal.entities.Recipe;
import lukedahlbergfinal.lukedahlbergfinal.services.RecipeService;

/**
 * The web service for the Baked Good
 * @author ldahlberg
 */
@RestController
public class RecipeWebService {

	@Autowired
	private RecipeService recipeService;
	
	/**
	 * Sets a RecipeService object
	 * @param recipeService
	 */
	public void setRecipeService(RecipeService recipeService) {
		this.recipeService = recipeService;
	}
		
	/**
	 * Returns a list of all the Recipes.
	 * @return List<Recipe>
	 */
	@RequestMapping(value="/recipes", method = RequestMethod.GET)
	public List<Recipe> getAllRecipes(){
		return recipeService.getAllRecipes();
	}	
	
	 /**
     * Retrieves Recipe from Web and sends to Hibernate
     * @param Recipe
     */
	@RequestMapping(value="/recipes", method=RequestMethod.POST)
	public void add(@RequestBody Recipe recipe){
		recipeService.add(recipe);
	} 
	
    /**
     * Returns the information for an Recipe with parameter:
     * @param id
     * @return Recipe
     */
	@RequestMapping(value="/recipes/{id}", method=RequestMethod.GET)
	public Recipe getRecipeById(@PathVariable Integer id){ 
		return recipeService.getRecipeById(id);
	}
	
	/**
	 * Edits an existing user in the Recipe table
	 * @param id
	 * @param user
	 */
	@RequestMapping(value="/recipes/{id}", method = RequestMethod.PUT)
	public void update(@RequestBody Recipe recipe){
		recipeService.update(recipe);
	}
	

	/**
	 * Deletes an existing Recipe in the Recipe table
	 * @param id
	 */
	@RequestMapping(value="/recipes/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id){
		
		recipeService.delete(id);
		 
	}
}
