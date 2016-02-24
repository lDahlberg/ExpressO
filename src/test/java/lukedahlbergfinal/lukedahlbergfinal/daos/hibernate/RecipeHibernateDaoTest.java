package lukedahlbergfinal.lukedahlbergfinal.daos.hibernate;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import lukedahlbergfinal.lukedahlbergfinal.entities.Recipe;

/**
 * This class tests the Hibernate functionality for the Recipe's Database Table
 * @author ldahlberg
 */
public class RecipeHibernateDaoTest {

	private RecipeHibernateDao target;
	private Recipe mockRecipe;
	private EntityManager mockEm;
	
	@Before
	public void setup() {
		
		target = new RecipeHibernateDao();
		mockEm = mock(EntityManager.class);
		mockRecipe =mock(Recipe.class);
		target.setEm(mockEm);
		
	}
	
	/**
	 * This test checks the RecipeHibernateDAO add functionality.
	 */
	@Test
	public void testAdd(){
		
		target.add(mockRecipe);
		verify(mockEm, times(1)).persist(mockRecipe);	
	
	}
	
	/**
	 * This test checks the RecipeHibernateDAO update functionality.
	 */
	@Test
	public void testUpdate(){
		
		target.update(mockRecipe);
		verify(mockEm, times(1)).merge(mockRecipe);	
		
	}
	
	/**
	 * This test checks the BakedGoodHibernateDAO delete functionality.
	 */
	@Test
	public void testDelete(){
		
		TypedQuery<Recipe> mockTypedQuery = mock(TypedQuery.class);

		when(mockEm.createQuery(anyString(), eq(Recipe.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
		when(target.getRecipeById(1)).thenReturn(mockRecipe);
		
		target.delete(1);
		verify(mockEm, times(1)).remove(mockRecipe);	
	}
	
	/**
	 * This test checks the RecipeHibernateDAO getAllRecipes functionality.
	 */
	@Test
	public void testGetAllRecipes(){
		
		List<Recipe> expected = new ArrayList();

		TypedQuery<Recipe> mockTypedQuery = mock(TypedQuery.class);

		when(mockEm.createQuery(anyString(), eq(Recipe.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(expected);

		target.getAllRecipes();

		verify(mockTypedQuery, times(1)).getResultList();
		
	}
	
	/**
	 * This test checks the RecipeHibernateDAO getRecipeById functionality.
	 */
	@Test
	public void testGetRecipeById(){
		
		TypedQuery<Recipe> mockTypedQuery = mock(TypedQuery.class);

		when(mockEm.createQuery(anyString(), eq(Recipe.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
		 		 
		target.getRecipeById(0);
		verify(mockTypedQuery, times(1)).setParameter(eq("id"), eq(0));
		
	}
	
	/**
	 * This test checks the RecipeHibernateDAO getRecipeById functionality.
	 */
	@Test
	public void testGetRecipeByName(){
		
		TypedQuery<Recipe> mockTypedQuery = mock(TypedQuery.class);

		when(mockEm.createQuery(anyString(), eq(Recipe.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
		 		 
		target.getRecipeByName("test");
		verify(mockTypedQuery, times(1)).setParameter(eq("recipeName"), eq("test"));
		
	}
}
