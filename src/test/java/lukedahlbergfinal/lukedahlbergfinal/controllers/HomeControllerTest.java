package lukedahlbergfinal.lukedahlbergfinal.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The following methods tests the Request Mapping functionality
 * @author ldahlberg
 *
 */
public class HomeControllerTest {
	
	/**
	 * This test checks the HomeController functionality.
	 */
	@Test
	public void testIndex(){
		
		HomeController target = new HomeController();
		
		String expected = "index.html";
		String result = target.index();
		
		assertEquals(expected, result);	
	
	}
}

