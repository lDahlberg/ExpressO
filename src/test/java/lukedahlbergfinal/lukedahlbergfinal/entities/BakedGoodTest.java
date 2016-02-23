package lukedahlbergfinal.lukedahlbergfinal.entities;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * This Java class tests the Baked Goods class.
 * @author ldahlberg
 */
public class BakedGoodTest {
	
	private BakedGood bakedGood;
	private Integer expectedInt = 1;
	private Double expectedDouble = 1.00;
	private String expectedString = "test";
	private Category expectedCategory;
	private Vendor expectedVendor;
	private List<Allergen> expectedAllergen;
	
	@Before
	public void setup() {
		
		bakedGood = new BakedGood();
		expectedCategory = new Category();
		expectedAllergen = new ArrayList<Allergen>();
		expectedVendor = new Vendor();
		
	}
	
	/**
	 * This test ensures that the BakedGood id getter and setter is functioning.
	 */
	@Test
	public void testSetAndGetBakedGoodId(){
		bakedGood.setBakedGoodId(1);
		assertEquals(expectedInt,bakedGood.getBakedGoodId());
		
	}
	
	/**
	 * This test ensures that the BakedGood name getter and setter is functioning.
	 */
	@Test
	public void testSetAndGetName(){
		
		bakedGood.setName("test");
		assertEquals(expectedString,bakedGood.getName());
		
	}
	
	/**
	 * This test ensures that the BakedGood cost getter and setter is functioning.
	 */
	@Test
	public void testSetAndGetCost(){
		
		bakedGood.setCost(1.00);
		assertEquals(expectedDouble,bakedGood.getCost());
		
	}
	
	/**
	 * This test ensures that the BakedGood vendor getter and setter is functioning.
	 */
	@Test
	public void testSetAndGetVendorName(){
		
		bakedGood.setVendor(expectedVendor);
		assertEquals(expectedVendor,bakedGood.getVendor());
		
	}
	
	/**
	 * This test ensures that the BakedGood category getter and setter is functioning.
	 */
	@Test
	public void testSetAndGetCategory(){
		
		bakedGood.setCategory(expectedCategory);
		assertEquals(expectedCategory,bakedGood.getCategory());
		
	}
	
	/**
	 * This test ensures that the BakedGood category getter and setter is functioning.
	 */
	@Test
	public void testSetAndGetAllergen(){
		
		bakedGood.setAllergen(expectedAllergen);
		assertEquals(expectedAllergen,bakedGood.getAllergen());
		
	}
	
}
