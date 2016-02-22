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

/**
 * This class tests the Hibernate functionality for the BakedGood's Database Table
 * @author ldahlberg
 */
public class BakedGoodHibernateDaoTest {

	private BakedGoodHibernateDao target;
	private BakedGood mockBakedGood;
	private EntityManager mockEm;
	
	@Before
	public void setup() {
		
		target = new BakedGoodHibernateDao();
		mockEm = mock(EntityManager.class);
		mockBakedGood =mock(BakedGood.class);
		target.setEm(mockEm);
		
	}
	
	/**
	 * This test checks the BakedGoodHibernateDAO add functionality.
	 */
	@Test
	public void testAdd(){
		
		target.add(mockBakedGood);
		verify(mockEm, times(1)).persist(mockBakedGood);	
	
	}
	
	/**
	 * This test checks the BakedGoodHibernateDAO update functionality.
	 */
	@Test
	public void testUpdate(){	
		target.update(mockBakedGood);
		verify(mockEm, times(1)).merge(mockBakedGood);	
	}
	
	/**
	 * This test checks the BakedGoodHibernateDAO getAllBakedGoods functionality.
	 */
	@Test
	public void testGetAllBakedGoods(){
		
		List<BakedGood> expected = new ArrayList();

		TypedQuery<BakedGood> mockTypedQuery = mock(TypedQuery.class);

		when(mockEm.createQuery(anyString(), eq(BakedGood.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(expected);

		target.getAllBakedGoods();

		verify(mockTypedQuery, times(1)).getResultList();
		
	}
	
	/**
	 * This test checks the BakedGoodHibernateDAO getBakedGoodById functionality.
	 */
	@Test
	public void testGetBakedGoodById(){
		
		TypedQuery<BakedGood> mockTypedQuery = mock(TypedQuery.class);

		when(mockEm.createQuery(anyString(), eq(BakedGood.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
		 		 
		target.getBakedGoodById(0);
		verify(mockTypedQuery, times(1)).setParameter(eq("id"), eq(0));
		
	}
	
	/**
	 * This test checks the BakedGoodHibernateDAO getBakedGoodById functionality.
	 */
	@Test
	public void testGetBakedGoodByName(){
		
		TypedQuery<BakedGood> mockTypedQuery = mock(TypedQuery.class);

		when(mockEm.createQuery(anyString(), eq(BakedGood.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
		 		 
		target.getBakedGoodByName("test");
		verify(mockTypedQuery, times(1)).setParameter(eq("bakedGoodName"), eq("test"));
		
	}
}
