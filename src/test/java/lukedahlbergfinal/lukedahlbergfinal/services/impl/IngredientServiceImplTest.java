package lukedahlbergfinal.lukedahlbergfinal.services.impl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import lukedahlbergfinal.lukedahlbergfinal.daos.IngredientDao;
import lukedahlbergfinal.lukedahlbergfinal.entities.Ingredient;

/**
 * This class tests the Service Implementation functionality for the Ingredient's Database Table
 * @author ldahlberg
 */
public class IngredientServiceImplTest {

	private IngredientServiceImpl target;
	private Ingredient mockIngredient;
	private IngredientDao mockIngredientDao;
	
	@Before
	public void setup() {
		
		target = new IngredientServiceImpl();
		mockIngredientDao = mock(IngredientDao.class);
		mockIngredient = mock(Ingredient.class);
		target.setIngredientDao(mockIngredientDao);
		
	}
	
	/**
	 * This test checks the IngredientHibernateDAO add functionality.
	 */
	@Test
	public void testAdd(){
		
		target.add(mockIngredient);
		verify(mockIngredientDao, times(1)).add(mockIngredient);	
	
	}
	
	/**
	 * This test checks the IngredientHibernateDAO update functionality.
	 */
	@Test
	public void testUpdate(){	
		target.update(mockIngredient);
		verify(mockIngredientDao, times(1)).update(mockIngredient);	
	}
	
	/**
	 * This test checks the IngredientDAO delete functionality.
	 */
	@Test
	public void testDelete(){	
		target.delete(1);
		verify(mockIngredientDao, times(1)).delete(1);	
	}

	/**
	 * This test checks the IngredientHibernateDAO getAllIngredients functionality.
	 */
	@Test
	public void testGetAllIngredients(){
		
		target.getAllIngredients();

		verify(mockIngredientDao, times(1)).getAllIngredients();
		
	}

	/**
	 * This test checks the IngredientHibernateDAO getIngredientById functionality.
	 */
	@Test
	public void testGetIngredientById(){
		
		target.getIngredientById(1);
		
		verify(mockIngredientDao, times(1)).getIngredientById(1);
		
	}
	
	/**
	 * This test checks the IngredientHibernateDAO getIngredientById functionality.
	 */
	@Test
	public void testGetIngredientByName(){
		
		target.getIngredientByName("test");
		
		verify(mockIngredientDao, times(1)).getIngredientByName("test");
		
	}
}
