package lukedahlbergfinal.lukedahlbergfinal.entities;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * This Java class represents the Ingredients.
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
	
	@Test
	public void testSetAndGetBakedGoodId(){
		ingredient.setIngredientId(1);
		assertEquals(expectedInt,ingredient.getIngredientId());
		
	}
	
	@Test
	public void testSetAndGetName(){
		
		ingredient.setName("test");
		assertEquals(expectedString,ingredient.getName());
		
	}
	
	@Test
	public void testSetAndGetCost(){
		
		ingredient.setCost(1.00);
		assertEquals(expectedDouble,ingredient.getCost());
		
	}
	
	@Test
	public void testSetAndGetMeasure(){
		
		ingredient.setMeasure("test");
		assertEquals(expectedString,ingredient.getMeasure());
		
	}
}
