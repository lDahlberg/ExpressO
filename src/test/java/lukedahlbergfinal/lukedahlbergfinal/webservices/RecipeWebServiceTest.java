package lukedahlbergfinal.lukedahlbergfinal.webservices;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import lukedahlbergfinal.lukedahlbergfinal.entities.Recipe;
import lukedahlbergfinal.lukedahlbergfinal.services.RecipeService;

/**
 * The web service for the Baked Good
 * @author ldahlberg
 */
public class RecipeWebServiceTest {

	private RecipeWebService target;
	private Recipe mockRecipe;
	private RecipeService mockRecipeService;
	
	@Before
	public void setup() {
		
		target = new RecipeWebService();
		mockRecipeService = mock(RecipeService.class);
		mockRecipe = mock(Recipe.class);
		target.setRecipeService(mockRecipeService);
		
	}
	
	/**
	 * This test checks the RecipeWebService getAllRecipes functionality.
	 */
	@Test
	public void testGetAllRecipes(){
		
		target.getAllRecipes();

		verify(mockRecipeService, times(1)).getAllRecipes();
		
	}
	
	/**
	 * This test checks the RecipeWebService add functionality.
	 */
	@Test
	public void testAdd(){
		
		target.add(mockRecipe);
		verify(mockRecipeService, times(1)).add(mockRecipe);	
	
	}
	
	/**
	 * This test checks the RecipeWebService getRecipeById functionality.
	 */
	@Test
	public void testGetRecipeById(){
		
		target.getRecipeById(1);
		
		verify(mockRecipeService, times(1)).getRecipeById(1);
		
	}
	
	/**
	 * This test checks the RecipeWebService update functionality.
	 */
	@Test
	public void testUpdate(){	
		target.update(mockRecipe);
		verify(mockRecipeService, times(1)).update(mockRecipe);	
	}
	
	/**
	 * This test checks the RecipeDAO delete functionality.
	 */
	@Test
	public void testDelete(){	
		target.delete(1);
		verify(mockRecipeService, times(1)).delete(1);	
	}
}
