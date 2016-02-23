package lukedahlbergfinal.lukedahlbergfinal.webservices;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import lukedahlbergfinal.lukedahlbergfinal.entities.Ingredient;
import lukedahlbergfinal.lukedahlbergfinal.services.IngredientService;

/**
 * The web service for the Baked Good
 * @author ldahlberg
 */
public class IngredientWebServiceTest {

	private IngredientWebService target;
	private Ingredient mockIngredient;
	private IngredientService mockIngredientService;
	
	@Before
	public void setup() {
		
		target = new IngredientWebService();
		mockIngredientService = mock(IngredientService.class);
		mockIngredient = mock(Ingredient.class);
		target.setIngredientService(mockIngredientService);
		
	}
	
	/**
	 * This test checks the IngredientWebService getAllIngredients functionality.
	 */
	@Test
	public void testGetAllIngredients(){
		
		target.getAllIngredients();

		verify(mockIngredientService, times(1)).getAllIngredients();
		
	}
	
	/**
	 * This test checks the IngredientWebService add functionality.
	 */
	@Test
	public void testAdd(){
		
		target.add(mockIngredient);
		verify(mockIngredientService, times(1)).add(mockIngredient);	
	
	}
	
	/**
	 * This test checks the IngredientWebService getIngredientById functionality.
	 */
	@Test
	public void testGetIngredientById(){
		
		target.getIngredientById(1);
		
		verify(mockIngredientService, times(1)).getIngredientById(1);
		
	}
	
	/**
	 * This test checks the IngredientWebService update functionality.
	 */
	@Test
	public void testUpdate(){	
		target.update(mockIngredient);
		verify(mockIngredientService, times(1)).update(mockIngredient);	
	}
}
