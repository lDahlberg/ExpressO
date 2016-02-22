package lukedahlbergfinal.lukedahlbergfinal.services.impl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import lukedahlbergfinal.lukedahlbergfinal.daos.BakedGoodDao;
import lukedahlbergfinal.lukedahlbergfinal.entities.BakedGood;

/**
 * This class tests the Service Implementation functionality for the BakedGood's Database Table
 * @author ldahlberg
 */
public class BakedGoodServiceImplTest {

	private BakedGoodServiceImpl target;
	private BakedGood mockBakedGood;
	private BakedGoodDao mockBakedGoodDao;
	
	@Before
	public void setup() {
		
		target = new BakedGoodServiceImpl();
		mockBakedGoodDao = mock(BakedGoodDao.class);
		mockBakedGood = mock(BakedGood.class);
		target.setBakedGoodDao(mockBakedGoodDao);
		
	}
	
	/**
	 * This test checks the BakedGoodHibernateDAO add functionality.
	 */
	@Test
	public void testAdd(){
		
		target.add(mockBakedGood);
		verify(mockBakedGoodDao, times(1)).add(mockBakedGood);	
	
	}
	
	/**
	 * This test checks the BakedGoodHibernateDAO update functionality.
	 */
	@Test
	public void testUpdate(){	
		target.update(mockBakedGood);
		verify(mockBakedGoodDao, times(1)).update(mockBakedGood);	
	}

	/**
	 * This test checks the BakedGoodHibernateDAO getAllBakedGoods functionality.
	 */
	@Test
	public void testGetAllBakedGoods(){
		
		target.getAllBakedGoods();

		verify(mockBakedGoodDao, times(1)).getAllBakedGoods();
		
	}

	/**
	 * This test checks the BakedGoodHibernateDAO getBakedGoodById functionality.
	 */
	@Test
	public void testGetBakedGoodById(){
		
		target.getBakedGoodById(1);
		
		verify(mockBakedGoodDao, times(1)).getBakedGoodById(1);
		
	}
	
	/**
	 * This test checks the BakedGoodHibernateDAO getBakedGoodById functionality.
	 */
	@Test
	public void testGetBakedGoodByName(){
		
		target.getBakedGoodByName("test");
		
		verify(mockBakedGoodDao, times(1)).getBakedGoodByName("test");
		
	}
}
