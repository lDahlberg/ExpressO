package lukedahlbergfinal.lukedahlbergfinal.entities;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * This Java class tests the Recipe class.
 * @author ldahlberg
 */
public class RecipeTest {

	private Recipe recipe;
	private Integer expectedInt = 1;
	private String expectedString = "test";
	
	@Before
	public void setup() {
		
		recipe = new Recipe();
		
	}
	
	/**
	 * This test ensures that the Recipe id getter and setter is functioning.
	 */
	@Test
	public void testSetAndGetRecipeId(){
		
		recipe.setRecipeId(expectedInt);
		assertEquals(expectedInt,recipe.getRecipeId());
		
	}
	
	/**
	 * This test ensures that the Recipe name getter and setter is functioning.
	 */
	@Test
	public void testSetAndGetInstructions(){
		
		recipe.setInstructions("test");
		assertEquals(expectedString,recipe.getInstructions());
		
	}
	
	/**
	 * This test ensures that the Recipe ingredient getter and setter is functioning.
	 */
	@Test
	public void testSetAndGetIngredients(){
		
		ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
		recipe.setIngredient(ingredients);
		assertEquals(ingredients,recipe.getIngredient());
		
	}
}
