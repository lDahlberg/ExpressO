package lukedahlbergfinal.lukedahlbergfinal.entities;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * This Java class tests the Vendor class.
 * @author ldahlberg
 */
public class VendorTest {

	private Vendor vendor;
	private Integer expectedInt = 1;
	private String expectedString = "test";
	
	@Before
	public void setup() {
		
		vendor = new Vendor();
		
	}
	
	/**
	 * This test ensures that the Vendor id getter and setter is functioning.
	 */
	@Test
	public void testSetAndGetVendorId(){
		vendor.setVendorId(1);
		assertEquals(expectedInt,vendor.getVendorId());
		
	}
	
	/**
	 * This test ensures that the Vendor name getter and setter is functioning.
	 */
	@Test
	public void testSetAndGetName(){
		
		vendor.setName("test");
		assertEquals(expectedString,vendor.getName());
		
	}
}
