package lukedahlbergfinal.lukedahlbergfinal.services.impl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import lukedahlbergfinal.lukedahlbergfinal.daos.RecipeDao;
import lukedahlbergfinal.lukedahlbergfinal.entities.Recipe;

/**
 * This class tests the Service Implementation functionality for the Recipe's Database Table
 * @author ldahlberg
 */
public class RecipeServiceImplTest {

	private RecipeServiceImpl target;
	private Recipe mockRecipe;
	private RecipeDao mockRecipeDao;
	
	@Before
	public void setup() {
		
		target = new RecipeServiceImpl();
		mockRecipeDao = mock(RecipeDao.class);
		mockRecipe = mock(Recipe.class);
		target.setRecipeDao(mockRecipeDao);
		
	}
	
	/**
	 * This test checks the RecipeHibernateDAO add functionality.
	 */
	@Test
	public void testAdd(){
		
		target.add(mockRecipe);
		verify(mockRecipeDao, times(1)).add(mockRecipe);	
	
	}
	
	/**
	 * This test checks the RecipeHibernateDAO update functionality.
	 */
	@Test
	public void testUpdate(){	
		target.update(mockRecipe);
		verify(mockRecipeDao, times(1)).update(mockRecipe);	
	}
	
	/**
	 * This test checks the RecipeDAO delete functionality.
	 */
	@Test
	public void testDelete(){	
		target.delete(1);
		verify(mockRecipeDao, times(1)).delete(1);	
	}

	/**
	 * This test checks the RecipeHibernateDAO getAllRecipes functionality.
	 */
	@Test
	public void testGetAllRecipes(){
		
		target.getAllRecipes();

		verify(mockRecipeDao, times(1)).getAllRecipes();
		
	}

	/**
	 * This test checks the RecipeHibernateDAO getRecipeById functionality.
	 */
	@Test
	public void testGetRecipeById(){
		
		target.getRecipeById(1);
		
		verify(mockRecipeDao, times(1)).getRecipeById(1);
		
	}
	
	/**
	 * This test checks the RecipeHibernateDAO getRecipeById functionality.
	 */
	@Test
	public void testGetRecipeByName(){
		
		target.getRecipeByName("test");
		
		verify(mockRecipeDao, times(1)).getRecipeByName("test");
		
	}
}
