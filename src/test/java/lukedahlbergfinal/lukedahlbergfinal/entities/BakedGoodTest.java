package lukedahlbergfinal.lukedahlbergfinal.entities;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


/**
 * This Java class represents the Baked Goods.
 * @author ldahlberg
 */
public class BakedGoodTest {
	
	private BakedGood bakedGood;
	private Integer expectedInt = 1;
	private Double expectedDouble = 1.00;
	private String expectedString = "test";
	
	@Before
	public void setup() {
		
		bakedGood = new BakedGood();
		
	}
	
	@Test
	public void testSetAndGetBakedGoodId(){
		bakedGood.setBakedGoodId(1);
		assertEquals(expectedInt,bakedGood.getBakedGoodId());
		
	}
	
	@Test
	public void testSetAndGetName(){
		
		bakedGood.setName("test");
		assertEquals(expectedString,bakedGood.getName());
		
	}
	
	@Test
	public void testSetAndGetCost(){
		
		bakedGood.setCost(1.00);
		assertEquals(expectedDouble,bakedGood.getCost());
		
	}
	
	@Test
	public void testSetAndGetVendorName(){
		
		bakedGood.setVendorName("test");
		assertEquals(expectedString,bakedGood.getVendorName());
		
	}
	
	/*@Test
	public void testSetAndGetCategory(){
		
		bakedGood.setCategory("test");
		assertEquals(expectedString,bakedGood.getCategory());
		
	}*/
	
}
