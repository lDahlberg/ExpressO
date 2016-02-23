package lukedahlbergfinal.lukedahlbergfinal.daos.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import lukedahlbergfinal.lukedahlbergfinal.daos.BakedGoodDao;
import lukedahlbergfinal.lukedahlbergfinal.entities.Allergen;
import lukedahlbergfinal.lukedahlbergfinal.entities.BakedGood;
import lukedahlbergfinal.lukedahlbergfinal.entities.Category;
import lukedahlbergfinal.lukedahlbergfinal.entities.Vendor;

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
		 * @return List<Allergen>
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
		
		/**
		 * Returns a list of all the rows in the Allergen table.
		 * @return List<Allergen>
		 */
		public List<Allergen> getAllAllergens() {
			
				return em.createQuery("SELECT a FROM Allergen a", Allergen.class).
						getResultList();
			
		}
		
		/**
		 * Returns a list of all the rows in the Category table.
		 * @return List<Category>
		 */
		public List<Category> getAllCategories() {
			
				return em.createQuery("SELECT c FROM Category c", Category.class).
						getResultList();
			
		}
		
		/**
		 * Returns a list of all the rows in the Vendor table.
		 * @return List<Vendor>
		 */
		public List<Vendor> getAllVendors() {
			
				return em.createQuery("SELECT v FROM Vendor v", Vendor.class).
						getResultList();
			
		}
}
