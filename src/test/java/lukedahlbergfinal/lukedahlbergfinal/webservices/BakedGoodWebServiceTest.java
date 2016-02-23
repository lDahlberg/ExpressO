package lukedahlbergfinal.lukedahlbergfinal.webservices;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import lukedahlbergfinal.lukedahlbergfinal.entities.BakedGood;
import lukedahlbergfinal.lukedahlbergfinal.services.BakedGoodService;

/**
 * The web service for the Baked Good
 * @author ldahlberg
 */
public class BakedGoodWebServiceTest {

	private BakedGoodWebService target;
	private BakedGood mockBakedGood;
	private BakedGoodService mockBakedGoodService;
	
	@Before
	public void setup() {
		
		target = new BakedGoodWebService();
		mockBakedGoodService = mock(BakedGoodService.class);
		mockBakedGood = mock(BakedGood.class);
		target.setBakedGoodService(mockBakedGoodService);
		
	}
	
	/**
	 * This test checks the BakedGoodWebService getAllBakedGoods functionality.
	 */
	@Test
	public void testGetAllBakedGoods(){
		
		target.getAllBakedGoods();

		verify(mockBakedGoodService, times(1)).getAllBakedGoods();
		
	}
	
	/**
	 * This test checks the BakedGoodWebService add functionality.
	 */
	@Test
	public void testAdd(){
		
		target.add(mockBakedGood);
		verify(mockBakedGoodService, times(1)).add(mockBakedGood);	
	
	}
	
	/**
	 * This test checks the BakedGoodWebService getBakedGoodById functionality.
	 */
	@Test
	public void testGetBakedGoodById(){
		
		target.getBakedGoodById(1);
		
		verify(mockBakedGoodService, times(1)).getBakedGoodById(1);
		
	}
	
	/**
	 * This test checks the BakedGoodWebService update functionality.
	 */
	@Test
	public void testUpdate(){	
		target.update(mockBakedGood);
		verify(mockBakedGoodService, times(1)).update(mockBakedGood);	
	}
	
	/**
	 * This test checks the BakedGoodWebService getAllAllergens functionality.
	 */
	@Test
	public void testGetAllAllergens(){
		
		target.getAllAllergens();

		verify(mockBakedGoodService, times(1)).getAllAllergens();
		
	}
	
	/**
	 * This test checks the BakedGoodWebService getAllCategories functionality.
	 */
	@Test
	public void testGetAllCategories(){
		
		target.getAllCategories();

		verify(mockBakedGoodService, times(1)).getAllCategories();
		
	}

	/**
	 * This test checks the BakedGoodWebService getAllVendors functionality.
	 */
	@Test
	public void testGetAllVendors(){
		
		target.getAllVendors();

		verify(mockBakedGoodService, times(1)).getAllVendors();
		
	}
}
