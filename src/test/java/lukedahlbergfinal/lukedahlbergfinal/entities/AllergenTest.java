package lukedahlbergfinal.lukedahlbergfinal.entities;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * This Java class tests the Allergen class.
 * @author ldahlberg
 */
public class AllergenTest {

	private Allergen allergen;
	private Integer expectedInt = 1;
	private String expectedString = "test";
	
	@Before
	public void setup() {
		
		allergen = new Allergen();
		
	}
	
	/**
	 * This test ensures that the Allergen id getter and setter is functioning.
	 */
	@Test
	public void testSetAndGetAllergenId(){
		allergen.setAllergenId(1);
		assertEquals(expectedInt,allergen.getAllergenId());
		
	}
	
	/**
	 * This test ensures that the Allergen name getter and setter is functioning.
	 */
	@Test
	public void testSetAndGetName(){
		
		allergen.setName("test");
		assertEquals(expectedString,allergen.getName());
		
	}
}
