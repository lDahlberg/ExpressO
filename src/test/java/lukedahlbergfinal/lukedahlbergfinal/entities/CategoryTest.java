package lukedahlbergfinal.lukedahlbergfinal.entities;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * This Java class tests the Category class.
 * @author ldahlberg
 */
public class CategoryTest {

	private Category category;
	private Integer expectedInt = 1;
	private String expectedString = "test";
	
	@Before
	public void setup() {
		
		category = new Category();
		
	}
	
	/**
	 * This test ensures that the Category id getter and setter is functioning.
	 */
	@Test
	public void testSetAndGetCategoryId(){
		category.setCategoryId(1);
		assertEquals(expectedInt,category.getCategoryId());
		
	}
	
	/**
	 * This test ensures that the Category name getter and setter is functioning.
	 */
	@Test
	public void testSetAndGetName(){
		
		category.setName("test");
		assertEquals(expectedString,category.getName());
		
	}
}
