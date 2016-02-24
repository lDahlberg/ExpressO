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

import lukedahlbergfinal.lukedahlbergfinal.entities.BakedGood;
import lukedahlbergfinal.lukedahlbergfinal.entities.Ingredient;

/**
 * This class tests the Hibernate functionality for the Ingredient's Database Table
 * @author ldahlberg
 */
public class IngredientHibernateDaoTest {

	private IngredientHibernateDao target;
	private Ingredient mockIngredient;
	private EntityManager mockEm;
	
	@Before
	public void setup() {
		
		target = new IngredientHibernateDao();
		mockEm = mock(EntityManager.class);
		mockIngredient =mock(Ingredient.class);
		target.setEm(mockEm);
		
	}
	
	/**
	 * This test checks the IngredientHibernateDAO add functionality.
	 */
	@Test
	public void testAdd(){
		
		target.add(mockIngredient);
		verify(mockEm, times(1)).persist(mockIngredient);	
	
	}
	
	/**
	 * This test checks the IngredientHibernateDAO update functionality.
	 */
	@Test
	public void testUpdate(){
		
		target.update(mockIngredient);
		verify(mockEm, times(1)).merge(mockIngredient);	
		
	}
	
	/**
	 * This test checks the BakedGoodHibernateDAO delete functionality.
	 */
	@Test
	public void testDelete(){
		
		TypedQuery<Ingredient> mockTypedQuery = mock(TypedQuery.class);

		when(mockEm.createQuery(anyString(), eq(Ingredient.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
		when(target.getIngredientById(1)).thenReturn(mockIngredient);
		
		target.delete(1);
		verify(mockEm, times(1)).remove(mockIngredient);	
	}
	
	/**
	 * This test checks the IngredientHibernateDAO getAllIngredients functionality.
	 */
	@Test
	public void testGetAllIngredients(){
		
		List<Ingredient> expected = new ArrayList();

		TypedQuery<Ingredient> mockTypedQuery = mock(TypedQuery.class);

		when(mockEm.createQuery(anyString(), eq(Ingredient.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(expected);

		target.getAllIngredients();

		verify(mockTypedQuery, times(1)).getResultList();
		
	}
	
	/**
	 * This test checks the IngredientHibernateDAO getIngredientById functionality.
	 */
	@Test
	public void testGetIngredientById(){
		
		TypedQuery<Ingredient> mockTypedQuery = mock(TypedQuery.class);

		when(mockEm.createQuery(anyString(), eq(Ingredient.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
		 		 
		target.getIngredientById(0);
		verify(mockTypedQuery, times(1)).setParameter(eq("id"), eq(0));
		
	}
	
	/**
	 * This test checks the IngredientHibernateDAO getIngredientById functionality.
	 */
	@Test
	public void testGetIngredientByName(){
		
		TypedQuery<Ingredient> mockTypedQuery = mock(TypedQuery.class);

		when(mockEm.createQuery(anyString(), eq(Ingredient.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
		 		 
		target.getIngredientByName("test");
		verify(mockTypedQuery, times(1)).setParameter(eq("ingredientName"), eq("test"));
		
	}
}
