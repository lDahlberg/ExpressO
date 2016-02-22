package lukedahlbergfinal.lukedahlbergfinal.daos.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import lukedahlbergfinal.lukedahlbergfinal.daos.BakedGoodDao;
import lukedahlbergfinal.lukedahlbergfinal.entities.BakedGood;

/**
 * The Hibernate functionality for the Baked Good Table
 * @author ldahlberg
 */
@Transactional
@Component
public class BakedGoodHibernateDao implements BakedGoodDao {

		@PersistenceContext
		private EntityManager em;
		
		/**
		 * Sets the EntityManager
		 * @param em
		 */
		public void setEm(EntityManager em) {
			
			this.em = em;
			
		}
		
		/**
		 * Creates a new row in the BakedGood table.
		 * @param ingredient
		 */
		public void add(BakedGood bakedGood) {
			
				em.persist(bakedGood);	
				
		}
		
		/**
		 * Updates a single row from the BakedGood table corresponding to the 
		 * passed-in BakedGood object:
		 * @param bakedGood
		 */
		public void update(BakedGood bakedGood) {
			
			em.merge(bakedGood);
			
		}

		/**
		 * Returns a list of all the rows in the BakedGood table.
		 * @return List<EndUser>
		 */
		public List<BakedGood> getAllBakedGoods() {
			
				return em.createQuery("SELECT b FROM BakedGood b", BakedGood.class).
						getResultList();
			
		}

		/**
		 * Returns a single row from the BakedGood table with the parameter:
		 * @param ingredientId
		 * @return BakedGood
		 */
		public BakedGood getBakedGoodById(Integer bakedGoodId) {
			
				return em.createQuery("SELECT b FROM BakedGood b WHERE b.bakedGoodId = :id", BakedGood.class)
						.setParameter("id", bakedGoodId)
						.getSingleResult();
				
		}

		/**
		 * Returns a single row from the BakedGood table with the parameter:
		 * @param ingredientName
		 * @return BakedGood
		 */
		public BakedGood getBakedGoodByName(String bakedGoodName){
			
				return em.createQuery("SELECT b FROM Ingredient b WHERE b.name = :bakedGoodName", BakedGood.class)
						 .setParameter("bakedGoodName", bakedGoodName)
						 .getSingleResult();
			
		}
}
