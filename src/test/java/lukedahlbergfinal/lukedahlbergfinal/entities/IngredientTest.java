package lukedahlbergfinal.lukedahlbergfinal.entities;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * This Java class tests the Ingredients class.
 * @author ldahlberg
 */
public class IngredientTest {

	private Ingredient ingredient;
	private Integer expectedInt = 1;
	private Double expectedDouble = 1.00;
	private String expectedString = "test";
	
	@Before
	public void setup() {
		
		ingredient = new Ingredient();
		
	}
	
	/**
	 * This test ensures that the IngredientID getter and setter is functioning.
	 */
	@Test
	public void testSetAndGetIngredientId(){
		ingredient.setIngredientId(1);
		assertEquals(expectedInt,ingredient.getIngredientId());
		
	}
	
	/**
	 * This test ensures that the Ingredient name getter and setter is functioning.
	 */
	@Test
	public void testSetAndGetName(){
		
		ingredient.setName("test");
		assertEquals(expectedString,ingredient.getName());
		
	}
	
	/**
	 * This test ensures that the Ingredient cost getter and setter is functioning.
	 */
	@Test
	public void testSetAndGetCost(){
		
		ingredient.setCost(1.00);
		assertEquals(expectedDouble,ingredient.getCost());
		
	}
	
	/**
	 * This test ensures that the Ingredient measure getter and setter is functioning.
	 */
	@Test
	public void testSetAndGetMeasure(){
		
		ingredient.setMeasure("test");
		assertEquals(expectedString,ingredient.getMeasure());
		
	}
}
